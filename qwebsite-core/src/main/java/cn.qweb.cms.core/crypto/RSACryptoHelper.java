package cn.qweb.cms.core.crypto;


import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by xuebj on 2017/3/10.
 */
public final class RSACryptoHelper {

    public static final String decrypt(String content){
        byte[] decodedData = new byte[0];
        try {
            decodedData = RSACoder.decryptByPrivateKey(RSACoder.decryptBASE64(content),CryptoCache.getRSAPrivateKey());
        } catch (Exception e) {
            throw new BizException(ErrorBuilder.buildBizError("密码解析错误"));

        }
        try {
            return URLDecoder.decode(new String(decodedData),"utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new BizException(ErrorBuilder.buildBizError("密码解析错误"));
        }
    }

    public static final String encrypt(String content){
        byte[] decodedData = new byte[0];
        try {
            decodedData = RSACoder.encryptByPublicKey(content.getBytes("utf-8"),CryptoCache.getRASPublicKey());
        } catch (Exception e) {
            throw new BizException(ErrorBuilder.buildBizError("密码解析错误"));

        }
        try {
            return RSACoder.encryptBASE64(decodedData);
        } catch (UnsupportedEncodingException e) {
            throw new BizException(ErrorBuilder.buildBizError("密码解析错误"));
        } catch (Exception e) {
            throw new BizException(ErrorBuilder.buildBizError("密码解析错误"));
        }
    }
}
