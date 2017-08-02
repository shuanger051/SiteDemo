package cn.qweb.cms.front.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

/**
 * Created by xuebj on 2017/2/8.
 */
public class JwtHelper {

    private static final Logger logger = LoggerFactory.getLogger(JwtHelper.class);

    public static Claims parseJWT(String jsonWebToken, String md5String){
        try
        {
            Claims claims = Jwts.parser()
                    .setSigningKey(md5String.getBytes())
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        }
        catch(Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    public static String createJWT(String userId,long TTLMillis,String md5String){

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //生成签名密钥
        byte[] apiKeySecretBytes = md5String.getBytes();
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("type", "JWT").claim("userId",userId).signWith(signatureAlgorithm,signingKey);
        if (TTLMillis >= 0) {
            long expMillis = nowMillis + TTLMillis * 1000;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }
        return builder.compact();
    }
}
