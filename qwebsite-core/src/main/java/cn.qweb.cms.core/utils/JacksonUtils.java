package cn.qweb.cms.core.utils;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.AnnotationUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 功能说明:
 * <p> 系统版本: v1.0<br>
 * 开发人员: xuebj xuebojie2@sina.com <br>
 * 开发时间: 14-3-26 上午10:12 <br>
 * 功能描述: 写明作用，调用方式，使用场景，以及特殊情况<br>
 */

public abstract class JacksonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // 设置默认日期格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        //提供其它默认设置
        objectMapper.setFilters(new SimpleFilterProvider()
            .setFailOnUnknownId(false));
    }

    /**
     *  转换对象到json 格式字符串，如果转换失败 返回null
     * @param object
     * @return
     */
    public final static String toJsonString(Object object, String... properties) {
        try {
            SimpleFilterProvider fileter = new SimpleFilterProvider();
            fileter.addFilter(
                AnnotationUtils.findAnnotation(object.getClass(),
                    JsonFilter.class).value(),
                SimpleBeanPropertyFilter.filterOutAllExcept(properties));
            return objectMapper.writer(fileter).writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final static String toJsonString(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    /**
     * json格式字符串转换成对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public final static  <T> T json2Object (String json, Class<T> clazz){
        try {
            return objectMapper.readValue(json,clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * json格式字符串转换成List<Object>
     * @param json          json字符串
     * @param clazz         Java类型
     * @param <T>           Java类型
     * @return
     */
    public final static <T> List<T> json2List(String json, Class<T> clazz){
        if(StringUtils.isBlank(json)){
            return Collections.EMPTY_LIST;
        }
        JavaType javaType = getCollectionType(ArrayList.class, clazz);
        try {
            return (List<T>)objectMapper.readValue(json, javaType);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }


    /**
     * 获取泛型的Collection Type
     * @param collectionClass 泛型的Collection
     * @param elementClasses 元素类
     * @return JavaType Java类型
     * @since 1.0
     */
    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }


    /**
     * JSON字符串转换成MAP
     * @param jsonStr
     * @return
     */
    public static Map<String,Object> json2Map(String jsonStr){

        Map<String,Object> map = new HashMap<String,Object>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            map = mapper.readValue(jsonStr, Map.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        return map;
    }

}
