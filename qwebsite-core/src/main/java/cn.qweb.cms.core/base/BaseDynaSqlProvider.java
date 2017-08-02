package cn.qweb.cms.core.base;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by xuebj on 2017/1/16.
 */
public class BaseDynaSqlProvider {

    public static String getField(final String[] fields){
        return getField(fields,null);
    }

    public static String getField(final String[] srcFields, String aliasName){
        String[] fields = ArrayUtils.clone(srcFields);
        if(StringUtils.isNotBlank(aliasName)){
            for (int i = 0; i < fields.length; i++) {
                fields[i] = aliasName +"." + fields[i] + " as " + fields[i];
            }
        }
        return  StringUtils.join(fields,",");
    }
}
