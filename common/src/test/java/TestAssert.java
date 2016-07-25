import org.junit.Test;

/**
 * Created by Yan Meng on 2016/6/23.
 */
public class TestAssert {

    @Test
    public void testAssert () {
        assert false;

        System.out.println("===========================");
    }

    @Test
    public void testString() {
        long a = 10000L;

        String s = String.valueOf(a);

        System.out.println(s);
    }
}
