import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by Yan Meng on 2016/6/15.
 */
public class ZEROStaticTest {
    private static int START = 0;
    private static int END = 100000;


    @Test
    public void testBigDecimal () {
        long start = System.currentTimeMillis();

        for (int i = START; i <= END; i ++) {
            BigDecimal zero = BigDecimal.ZERO;
        }

        long end = System.currentTimeMillis();

        System.out.println("==================" + (end - start));
    }

    @Test
    public void testApache () {
        long start = System.currentTimeMillis();

        for (int i = START; i <= END; i ++) {
            Long longZero = NumberUtils.LONG_ZERO;
        }
        long end = System.currentTimeMillis();
        System.out.println("==================" + (end - start));
    }
}
