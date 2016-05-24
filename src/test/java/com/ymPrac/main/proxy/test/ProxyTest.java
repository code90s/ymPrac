package com.ymPrac.main.proxy.test;

import com.ymPrac.main.proxy.ProxyObj;
import org.junit.Test;

/**
 * Created by Yan Meng on 2016/5/24.
 */
public class ProxyTest {

    @Test
    public void testProxy () {
        ProxyObj proxyObj = new ProxyObj();

        proxyObj.abstractMethod();
    }

}
