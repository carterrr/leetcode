import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
       Map<String, Object> test = new HashMap<>();
       test.put("a", null);
        System.out.println(test.get("a"));
    }
}
