package cn.qweb.cms.front.biz.web;

import cn.qweb.cms.core.crypto.CryptoCache;
import cn.qweb.cms.core.crypto.RSACryptoHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuebj on 2017/3/10.
 */
@RestController
@RequestMapping("/crypto")
public class CryptoController {

    @RequestMapping(value = "/public_key",method = RequestMethod.GET)
    public String key(){
        return StringUtils.replaceEachRepeatedly(CryptoCache.getRASPublicKey(), new String[]{"\r\n", "\n"}, new String[]{"", ""});
    }

    @RequestMapping(value = "/encrypt", method = RequestMethod.GET)
    public String getPwdEncoding(String content) {
        return StringUtils.replaceEachRepeatedly(RSACryptoHelper.encrypt(content), new String[]{"\r\n", "\n"}, new String[]{"", ""});
    }

}
