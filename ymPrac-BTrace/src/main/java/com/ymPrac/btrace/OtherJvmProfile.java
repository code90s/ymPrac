package com.ymPrac.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.Profiler;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Duration;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.OnTimer;
import com.sun.btrace.annotations.ProbeMethodName;
import com.sun.btrace.annotations.Property;

/**
 * @script btrace <pid> E:\IdeaProjects\ymPrac\ymPrac-BTrace\src\main\java\com\ymPrac\btrace\OtherJvmProfile.java
 * Created by Yan Meng on 2017/12/s
 * 13.
 */
@BTrace
class OtherJvmProfile {
    @Property
    Profiler swingProfiler = BTraceUtils.Profiling.newProfiler();

    @OnMethod(clazz = "org.dkimi.demo.Demo2", method = "/.*/")
    void entry(@ProbeMethodName(fqn = true) String probeMethod) {
        BTraceUtils.Profiling.recordEntry(swingProfiler, probeMethod);
    }

    @OnMethod(clazz = "org.dkimi.demo.Demo2", method = "/.*/", location = @Location(value = Kind.RETURN))
    void exit(@ProbeMethodName(fqn = true) String probeMethod, @Duration long duration) {
        BTraceUtils.Profiling.recordExit(swingProfiler, probeMethod, duration);
    }

    @OnTimer(5000)
    void timer() {
        BTraceUtils.Profiling.printSnapshot("Swing performance profile", swingProfiler);
    }
}
