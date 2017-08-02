package cn.qweb.cms.biz.web;

import cn.qweb.cms.core.crypto.CryptoCache;
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
        return CryptoCache.getRASPublicKey();
    }

}
