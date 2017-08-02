package cn.qweb.cms.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by xuebj on 2017/2/20.
 */
public class ImgUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImgUtils.class);
    private static final BASE64Decoder decoder = new BASE64Decoder();

    /**
     * 等比例压缩算法：
     * 算法思想：根据压缩基数和压缩比来压缩原图，生产一张图片效果最接近原图的缩略图
     *
     * @param srcURL  原图地址
     * @param comBase 压缩基数
     * @param scale   压缩限制(宽/高)比例  一般用1：
     *                当scale>=1,缩略图height=comBase,width按原图宽高比例;若scale<1,缩略图width=comBase,height按原图宽高比例
     * @throws Exception
     * @author shenbin
     * @createTime 2014-12-16
     * @lastModifyTime 2014-12-16
     */
    public static byte[] saveMinPhoto(String srcURL, double comBase,
                                      double scale) throws IOException {
        File srcFile = new File(srcURL);
        Image src = ImageIO.read(srcFile);
        return getBytes(src, comBase, scale);

    }


    /**
     * 保存到指定目录
     * @param image
     * @param savePath
     * @param comBase
     * @param scale
     * @throws IOException
     */
    public static void saveMinImg(Image image, String savePath, double comBase, double scale) throws IOException{
        BufferedImage tag = getBufferedImage(image,comBase,scale);
        File newFile = new File(savePath);
        if(!newFile.getParentFile().exists()){
            newFile.getParentFile().mkdirs();
        }
        FileOutputStream deskImage = new FileOutputStream(newFile); //输出到文件流
        try {
            ImageIO.write(tag, "jpeg", deskImage);
            deskImage.flush();
        } finally {
            try {
                if(null != deskImage) {
                    deskImage.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static BufferedImage getBufferedImage(Image src,double comBase, double scale){
        if(null == src){
            return null;
        }
        int srcHeight = src.getHeight(null);
        int srcWidth = src.getWidth(null);
        int deskHeight = 0;// 缩略图高
        int deskWidth = 0;// 缩略图宽
        double srcScale = (double) srcHeight / srcWidth;
        /**缩略图宽高算法*/
        if ((double) srcHeight > comBase || (double) srcWidth > comBase) {
            if (srcScale >= scale || 1 / srcScale > scale) {
                if (srcScale >= scale) {
                    deskHeight = (int) comBase;
                    deskWidth = srcWidth * deskHeight / srcHeight;
                } else {
                    deskWidth = (int) comBase;
                    deskHeight = srcHeight * deskWidth / srcWidth;
                }
            } else {
                if ((double) srcHeight > comBase) {
                    deskHeight = (int) comBase;
                    deskWidth = srcWidth * deskHeight / srcHeight;
                } else {
                    deskWidth = (int) comBase;
                    deskHeight = srcHeight * deskWidth / srcWidth;
                }
            }
        } else {
            deskHeight = srcHeight;
            deskWidth = srcWidth;
        }
        ByteArrayOutputStream swapStream = null;
        BufferedImage tag = new BufferedImage(deskWidth, deskHeight, BufferedImage.TYPE_3BYTE_BGR);
        tag.getGraphics().drawImage(src, 0, 0, deskWidth, deskHeight, null); //绘制缩小后的图
        return tag;
    }

    private static byte[] getBytes(Image src, double comBase, double scale) throws IOException {
        BufferedImage tag = getBufferedImage(src,comBase,scale);
        ByteArrayOutputStream swapStream = null;
        try {
            swapStream = new ByteArrayOutputStream();
            ImageIO.write(tag, "jpeg", swapStream);
            swapStream.flush();
            tag.flush();
            tag = null;
            return swapStream.toByteArray();
        } finally {
            if (null != swapStream) {
                try {
                    swapStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static byte[] base64StringToImage(String base64String, double comBase, double scale) throws IOException {
        byte[] bytes1 = decoder.decodeBuffer(base64String);
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
        Image bi1 = (Image) ImageIO.read(bais);
        return getBytes(bi1, comBase, scale);
    }

//    public static void main(String[] args) {
//        try {
//            saveMinPhoto("/Users/xuebj/Downloads/4.jpg", "/Users/xuebj/Downloads/10.jpeg", 150, 0.9d);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
