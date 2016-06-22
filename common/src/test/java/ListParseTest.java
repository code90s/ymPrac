import com.google.common.collect.Lists;

import org.junit.Test;

import java.util.List;

/**
 * Created by Yan Meng on 2016/6/21.
 */
public class ListParseTest {

    @Test
    public void testListParee () {
        List<Long> nos = Lists.newArrayList();

        nos.add(1L);
        nos.add(1L);
        nos.add(1L);
        nos.add(1L);

//        List<String> noStrs = nos;

        System.out.println(nos.size());
    }
}
