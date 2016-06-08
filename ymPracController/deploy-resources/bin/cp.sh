#!/bin/sh
source $HOME/.bash_profile
SERVER_ROOT_PATH=$(cd "$(dirname "$0")"; cd ..; pwd)
APP_PATH_NAME=${SERVER_ROOT_PATH##*/}

if [ "$JAVA_HOME" = "" ]; then
    echo "Error: JAVA_HOME is not set."
    exit 1
fi

if [ "$COMMON_APP_VAR_ROOT" != "" ]; then
    VAR_ROOT_PATH="${COMMON_APP_VAR_ROOT}/${APP_PATH_NAME}"
else
    VAR_ROOT_PATH="${SERVER_ROOT_PATH}/var"
fi

_RUNJAVA=$JAVA_HOME/bin/java
JAVA_OPTS="-Xmn3072m -Xms4096m -Xmx4096m -Xss256K -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:${VAR_ROOT_PATH}/logs/gc.log"

#if [ "$COMMON_APP_VAR_ROOT" != "" ]; then
    JAVA_OPTS="${JAVA_OPTS} -Dlogging.path=${VAR_ROOT_PATH}/logs"
#fi

STDOUT_LOG=${VAR_ROOT_PATH}/logs/stdout.log
#CLASSPATH=$CLASSPATH:`find "$SERVER_ROOT_PATH/lib" -name *.jar|tr '\n' ':'`
#CLASSPATH=$CLASSPATH:$SERVER_ROOT_PATH/conf
JARFILE=`find "$SERVER_ROOT_PATH/lib" -name *.jar`

cygwin=false
case "`uname`" in
    CYGWIN*) cygwin=true;;
esac

if $cygwin; then
    [ -n "$JAVA_HOME" ] && JAVA_HOME=`cygpath --unix "$JAVA_HOME"`
    [ -n "$CLASSPATH" ] && CLASSPATH=`cygpath --path --windows "$CLASSPATH"`
    [ -n "$SERVER_ROOT_PATH" ] && SERVER_ROOT_PATH=`cygpath --windows "$SERVER_ROOT_PATH"`
fi

echo "Using JAVA     : " $_RUNJAVA
echo "Using JAVA_OPTS: " $JAVA_OPTS
echo "-----------------------------"
echo "Using CLASSPATH: " $CLASSPATH
echo "-----------------------------"
enve=""
profile=""
#if [ ! -z $2 ]; then
#    enve="-D env=$2"
#    profile="--spring.profiles.active=$2"
#fi

enve="-Denv=$2"
profile="--spring.profiles.active=$2"

case "$1" in

    start)
        if [ ! -d ${VAR_ROOT_PATH}/logs ] ; then
            mkdir -p ${VAR_ROOT_PATH}/logs
        fi
        touch $STDOUT_LOG
        exec $_RUNJAVA $JAVA_OPTS -DauthFile="$SERVER_ROOT_PATH/conf/auth.yml" -jar $JARFILE \
         $profile $enve --spring.config.location=$SERVER_ROOT_PATH/conf/ \
        >> "$STDOUT_LOG" 2>&1 &

        echo "$_RUNJAVA $JAVA_OPTS -jar $JARFILE $profile $enve --spring.config.location=$SERVER_ROOT_PATH/conf/"

        echo $! > $SERVER_ROOT_PATH/bin/server.pid
    ;;

    debug)
        if [ ! -d $SERVER_ROOT_PATH/var/logs ] ; then
            mkdir -p $SERVER_ROOT_PATH/var/logs
        fi
        touch $STDOUT_LOG
        exec $_RUNJAVA $JAVA_OPTS \
        -Dcom.sun.management.jmxremote.port=8999 \
        -Dcom.sun.management.jmxremote.ssl=false \
        -Dcom.sun.management.jmxremote.authenticate=false \
        -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=11000 \
        -DauthFile="$SERVER_ROOT_PATH/conf/auth.yml" \
        $enve -jar $JARFILE \
        $profile  --spring.config.location=$SERVER_ROOT_PATH/conf/  \
         >> "$STDOUT_LOG" 2>&1 &

        echo "$_RUNJAVA $JAVA_OPTS -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.port=8999 $profile $enve --spring.config.location=$SERVER_ROOT_PATH/conf/"
        echo $! > $SERVER_ROOT_PATH/bin/server.pid
    ;;

    stop)
        kill `cat $SERVER_ROOT_PATH/bin/server.pid`
        rm -rf $SERVER_ROOT_PATH/bin/server.pid
    ;;

    fstop)
        kill -9 `cat $SERVER_ROOT_PATH/bin/server.pid`
        ret=$?
        i=1;
        while [ $ret -ne 0 ]
        do
            kill -9 `cat $SERVER_ROOT_PATH/bin/server.pid`
            ret=$?
            i=`expr $i + 1`
            echo "正在执行第$i次删掉进程"
            if [ $i -gt 10 ]; then
                break
            fi
            sleep 1
        done
            if [ $ret -eq 0 ];then
                rm -rf $SERVER_ROOT_PATH/bin/server.pid
            fi
    ;;

    restart)
        $0 stop
        sleep 1
        $0 start
    ;;

    *)
        echo "Usage: proxy {start|debug|stop|fstop|restart}"
    ;;

esac

exit 0
