package cn.qweb.cms.biz.web;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.biz.service.SysDictEntryService;
import cn.qweb.cms.biz.service.bo.SysDictEntrySaveBO;
import cn.qweb.cms.biz.service.query.SysDictEntryQUERY;
import cn.qweb.cms.biz.service.bo.SysDictEntryRemoveBO;
import cn.qweb.cms.biz.service.dto.SysDictEntryDTO;
import cn.qweb.cms.biz.service.bo.SysDictEntryUpdateBO;
import cn.qweb.cms.core.base.Pagination;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/sys_dict_entry")
public class SysDictEntryController extends BaseController{

    @Autowired
    private SysDictEntryService sysDictEntryService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "SysDictEntryQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<SysDictEntryDTO> getSysDictEntryList(@Valid SysDictEntryQUERY bean){
        return sysDictEntryService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public SysDictEntryDTO getSysDictEntry(Long id){
        return sysDictEntryService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "SysDictEntrySaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postSysDictEntry(@Valid SysDictEntrySaveBO bean){
        return sysDictEntryService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "SysDictEntryUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public String putSysDictEntry(@Valid SysDictEntryUpdateBO bean){
        sysDictEntryService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteSysDictEntry(Long id) {
        sysDictEntryService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "SysDictEntryRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeSysDictEntry(SysDictEntryRemoveBO bean) {
        sysDictEntryService.doRemove(bean);
        return SUCCESS;
    }

}