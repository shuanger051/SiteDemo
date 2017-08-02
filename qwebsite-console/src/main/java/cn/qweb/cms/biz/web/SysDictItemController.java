package cn.qweb.cms.biz.web;
import cn.qweb.cms.biz.service.SysDictItemService;
import cn.qweb.cms.biz.service.bo.SysDictItemRemoveBO;
import cn.qweb.cms.biz.service.bo.SysDictItemSaveBO;
import cn.qweb.cms.biz.service.bo.SysDictItemUpdateBO;
import cn.qweb.cms.biz.service.dto.SysDictItemDTO;
import cn.qweb.cms.biz.service.query.SysDictItemQUERY;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.constants.SymbolConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/sys_dict_item")
public class SysDictItemController extends BaseController{

    @Autowired
    private SysDictItemService sysDictItemService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "SysDictItemQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<SysDictItemDTO> getSysDictItemList(@Valid SysDictItemQUERY bean){
        return sysDictItemService.list(bean);
    }

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "SysDictItemQUERY")
    @RequestMapping(value = "/list_by_entry_code",method = RequestMethod.GET)
    public Map<String,List<SysDictItemDTO>> getSysDictItemList(String entryCodes){
        List<String> entryCodesList = Arrays.asList(entryCodes.split(SymbolConstants.COMMA));
        return sysDictItemService.list(entryCodesList);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public SysDictItemDTO getSysDictItem(Long id){
        return sysDictItemService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "SysDictItemSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postSysDictItem(@Valid SysDictItemSaveBO bean){
        return sysDictItemService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "SysDictItemUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public String putSysDictItem(@Valid SysDictItemUpdateBO bean){
        sysDictItemService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteSysDictItem(Long id) {
        sysDictItemService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "SysDictItemRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeSysDictItem(SysDictItemRemoveBO bean) {
        sysDictItemService.doRemove(bean);
        return SUCCESS;
    }

}