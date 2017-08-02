package cn.qweb.cms.front.biz.web;

import cn.qweb.cms.biz.service.SysDictItemService;
import cn.qweb.cms.biz.service.dto.SysDictItemDTO;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.constants.SymbolConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by xuebj on 2017/5/16.
 */
@RestController
@RequestMapping("/dict")
public class DictController extends BaseController{

    @Autowired
    private SysDictItemService itemService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "SysDictItemQUERY")
    @RequestMapping(value = "/list_by_entry_code",method = RequestMethod.GET)
    public Map<String,List<SysDictItemDTO>> getSysDictItemList(String entryCodes){
        List<String> entryCodesList = Arrays.asList(entryCodes.split(SymbolConstants.COMMA));
        return itemService.list(entryCodesList);
    }
}
