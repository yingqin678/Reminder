import com.ying.dairy.DariyService;
import com.ying.dairy.impl.DariyServiceImpl;
import com.ying.spring.context.SpringContext;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yingmeng on 2017/5/23 0023.
 */
public class TestMethod {

    @Test
    public void testDairy()
    {
        DariyService dariyService = (DariyService) SpringContext.getApplicationContext().getBean("dairy");
    }

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
