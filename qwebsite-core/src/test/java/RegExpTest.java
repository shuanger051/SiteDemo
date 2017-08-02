import cn.qweb.cms.core.validator.RegExpConstants;
import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by xuebj on 2017/3/21.
 */
public class RegExpTest {


    @Test
    public void testPhone (){
        Pattern p1 = Pattern.compile(RegExpConstants.PHONE);
        System.out.println(p1.matcher("88889999").matches());
    }


    @Test
    public void testGrender(){
        Pattern p1 = Pattern.compile(RegExpConstants.GENDER);
        System.out.println(p1.matcher("").matches());
    }

    @Test
    public void testRealName(){
        Pattern p1 = Pattern.compile(RegExpConstants.REALNAME);
        System.out.println(p1.matcher("fhdskafh fshakfhskahfkjsd").matches());
    }
}
