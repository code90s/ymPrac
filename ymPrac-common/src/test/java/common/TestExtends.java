package common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yan Meng on 2016/8/31.
 */
public class TestExtends {

    public static void main(String[] args) {
        try {

            Map<String, String> map = new HashMap<>();
            map.put("a", "aaa");
            map.put("a", "aaa");
            map.put("a", "asdf");

            System.out.println(map.size());
            System.out.println(map.get("a"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
