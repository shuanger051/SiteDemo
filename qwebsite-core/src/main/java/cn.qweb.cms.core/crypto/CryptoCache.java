package cn.qweb.cms.core.crypto;


import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuebj on 2017/3/10.
 */
public final class CryptoCache {


    private static Map<String, Object> RSAKeys = new HashMap<>();

    public static  Map<String, Object> getRSAKeys() {
        return RSAKeys;
    }

    private static void setRSAKeys(Map<String, Object> RSAKeys) {
        CryptoCache.RSAKeys.clear();
        CryptoCache.RSAKeys.putAll(RSAKeys);
    }

    public static synchronized String getRASPublicKey(){
        Map<String, Object> RSAKeys = CryptoCache.getRSAKeys();
        if(RSAKeys.isEmpty()){
           initRSAKeys();
        }
        try {
            return RSACoder.getPublicKey(RSAKeys);
        } catch (Exception e) {
            throw new BizException(ErrorBuilder.buildBizError("获取加密key错误,请重试."));
        }
    }

    public static String getRSAPrivateKey(){
        Map<String, Object> RSAKeys = CryptoCache.getRSAKeys();
        if(RSAKeys.isEmpty()){
            initRSAKeys();
        }
        try {
            return RSACoder.getPrivateKey(RSAKeys);
        } catch (Exception e) {
            throw new BizException(ErrorBuilder.buildBizError("获取加密key错误,请重试."));
        }
    }


    private static void initRSAKeys(){
        try {
            synchronized (CryptoCache.getRSAKeys()) {
                if(CryptoCache.getRSAKeys().isEmpty()) {
                    CryptoCache.setRSAKeys(RSACoder.initKey());
                }
            }
        } catch (Exception e) {
            throw new BizException(ErrorBuilder.buildBizError("获取加密key错误,请重试."));
        }
    }
}
