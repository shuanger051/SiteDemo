package cn.qweb.cms.biz.web;

import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuebj on 2017/3/13.
 */

@RestController
public class TestController {
    @RequestMapping("/test")
    public String test(){
        throw new BizException(ErrorBuilder.buildBizError("10000","测试错误"));
    }
}
