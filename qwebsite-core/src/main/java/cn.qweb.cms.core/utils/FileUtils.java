package cn.qweb.cms.core.utils;

import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Author: caijl
 * Package:cn.qweb.cms.core.utils
 * Project:qwebsite
 * Description:文件操作工具类
 * Date: 2017/3/23
 * Time: 10:10
 * 系统版本:1.0.0
 */
public abstract class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /**
     * @info WEB文件上传
     * @return
     */
    public static boolean uploadFile(String fileName,MultipartFile file){
        File dest = new File(fileName);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException | IOException e) {
            logger.error("图片上传失败"+e.getMessage());
            throw new BizException(ErrorBuilder.buildBizError("图片上传失败"));
        }

    }

    /**
     * @info 删除本地文件
     * @param fileName
     * @return
     */
    public static boolean delFile(String fileName){
        File file = new File(fileName);

        if (!file.exists() || !file.isFile()) {
            return false;
        }

        try {
            file.delete();
            return true;
        }catch (Exception e){
            logger.error("图片删除失败"+e.getMessage());
            throw new BizException(ErrorBuilder.buildBizError("图片删除失败"));
        }
    }


}
