package cn.qweb.cms.core.mvc;

import cn.qweb.cms.core.entity.JsonResult;
import cn.qweb.cms.core.entity.UEditeUploadResult;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by xuebj on 16/7/20.
 */
public class SystemHttpMessageConverter extends MappingJackson2HttpMessageConverter {


    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return true;
    }

    protected boolean canWrite(MediaType mediaType) {
        return true;
    }

    /**
     * 修改写出数据,转换成统一格式
     * @param o
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        JsonResult result = new JsonResult(o);
        super.writeInternal(result, outputMessage);
    }

    /**
     * 修改写出数据,转换成统一格式
     * @param object
     * @param type
     * @param outputMessage
     * @throws IOException
     */
    @Override
    protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException {
        if(object instanceof UEditeUploadResult){//ueditor 特殊处理原样返回
            super.writeInternal(object,type,outputMessage);
        }else{
            JsonResult result = new JsonResult(object);
            super.writeInternal(result,type, outputMessage);
        }
    }
}
