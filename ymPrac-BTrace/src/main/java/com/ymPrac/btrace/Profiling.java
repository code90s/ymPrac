package com.ymPrac.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.Profiler;
import com.sun.btrace.annotations.*;

/**
 * @script btrace ,pid. com.ymPrac.btrace.Profiling
 * Created by Yan Meng on 2017/12/13.
 */
@BTrace
class Profiling {
    @Property
    Profiler swingProfiler = BTraceUtils.Profiling.newProfiler();

    @OnMethod(clazz = "com.ymPrac.btrace.BtraceTest", method = "/.*/")
    void entry(@ProbeMethodName(fqn = true) String probeMethod) {
        BTraceUtils.Profiling.recordEntry(swingProfiler, probeMethod);
    }

    @OnMethod(clazz = "com.ymPrac.btrace.BtraceTest", method = "/.*/", location = @Location(value = Kind.RETURN))
    void exit(@ProbeMethodName(fqn = true) String probeMethod, @Duration long duration) {
        BTraceUtils.Profiling.recordExit(swingProfiler, probeMethod, duration);
    }

    @OnTimer(5000)
    void timer() {
        BTraceUtils.Profiling.printSnapshot("Swing performance profile", swingProfiler);
    }
}
