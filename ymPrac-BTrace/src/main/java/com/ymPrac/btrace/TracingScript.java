package com.ymPrac.btrace;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

/**
 *
 * @script btrace ,pid. com.ymPrac.btrace.TracingScript
 * BTrace Script Template
 * Created by Yan Meng on 2017/12/13.
 */
@BTrace
public class TracingScript {
    /* put your code here */
    @TLS
    private static long startTime = 0;

    @OnMethod(
            clazz = "com.ymPrac.btrace.BtraceTest",
            method = "getret"
    )
    public static void startExecute() {
        startTime = timeNanos();
    }

    @OnMethod(
            clazz = "com.ymPrac.btrace.BtraceTest",
            method = "getret",
            location = @Location(Kind.RETURN)
    )
    public static void traceExecute(@Duration long duration, @ProbeMethodName String pmn) {
        long time = timeNanos() - startTime;
        println(strcat("duration(nanos): ", str(duration)));
        println(strcat("execute time(nanos): ", str(time)));

        println(strcat("ProbeMethodName(pmn): ", str(pmn)));
    }
}