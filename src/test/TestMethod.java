import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yingmeng on 2017/5/23 0023.
 */
public class TestMethod {


    @Test
    public void testRegex()
    {
// 按指定模式在字符串查找
        String line = "12345678|qwert";
        String pattern = "^.*(?=\\|)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
        } else {
            System.out.println("NO MATCH");
        }
    }
}
