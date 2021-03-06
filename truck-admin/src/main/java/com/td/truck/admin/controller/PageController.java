package com.td.truck.admin.controller;

//import com.blade.ioc.annotation.Inject;
//import com.blade.jdbc.page.Page;
//import com.blade.mvc.http.HttpMethod;
//import com.blade.mvc.http.Request;
//import com.blade.mvc.ui.RestResponse;
//import com.blade.validator.annotation.Valid;
//import com.tale.exception.TipException;
//import com.tale.extension.Commons;
//import com.tale.init.TaleConst;
//import com.tale.model.dto.LogActions;
//import com.tale.model.dto.Types;
//import com.tale.model.entity.Contents;
//import com.tale.model.entity.Logs;
//import com.tale.model.entity.Users;
//import com.tale.service.ContentsService;
//import com.tale.service.SiteService;

import com.td.truck.http.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 页面管理
 * <p>
 * Created by biezhi on 2017/2/21.
 */
@Slf4j
@Controller
@RequestMapping("admin/page")
public class PageController extends BaseController {

//    @Inject
//    private ContentsService contentsService;
//
//    @Inject
//    private SiteService siteService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(HttpServletRequest request, ModelMap model) {
//        Page<Contents> contentsPage = new Contents().where("type", Types.PAGE).page(1, TaleConst.MAX_POSTS, "created desc");
//        model.put("articles", contentsPage);
        return "admin/page_list";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newPage(HttpServletRequest request, ModelMap model) {
//        model.put(Types.ATTACH_URL, Commons.site_option(Types.ATTACH_URL, Commons.site_url()));
        return "admin/page_edit";
    }

    @RequestMapping(value = {"/{cid}"}, method = RequestMethod.GET)
    public String editPage(@PathVariable String cid, HttpServletRequest request, ModelMap model) {
//        Optional<Contents> contents = contentsService.getContents(cid);
//        if (!contents.isPresent()) {
//            return render_404();
//        }
//        model.put("contents", contents.get());
//        model.put(Types.ATTACH_URL, Commons.site_option(Types.ATTACH_URL, Commons.site_url()));
        return "admin/page_edit";
    }

    @RequestMapping(value = {"publish"}, method = RequestMethod.POST)
    @ResponseBody
//    public RestResponse publishPage(@Valid Contents contents) {
    public RestResponse publishPage() {
//        Users users = this.user();
//        contents.setType(Types.PAGE);
//        contents.setAllowPing(true);
//        contents.setAuthorId(users.getUid());
//        try {
//            contentsService.publish(contents);
//            siteService.cleanCache(Types.C_STATISTICS);
//        } catch (Exception e) {
//            String msg = "页面发布失败";
//            if (e instanceof TipException) {
//                msg = e.getMessage();
//            } else {
//                log.error(msg, e);
//            }
//            return RestResponse.fail(msg);
//        }
        return RestResponse.ok();
    }

//    @RequestMapping(value = "modify", method = RequestMethod.POST)
//    @ResponseBody
//    public RestResponse modifyArticle(@Valid Contents contents) {
//        if (null == contents || null == contents.getCid()) {
//            return RestResponse.fail("缺少参数，请重试");
//        }
//        try {
//            Integer cid = contents.getCid();
//            contents.setType(Types.PAGE);
//            contentsService.updateArticle(contents);
//            return RestResponse.ok(cid);
//        } catch (Exception e) {
//            String msg = "页面编辑失败";
//            if (e instanceof TipException) {
//                msg = e.getMessage();
//            } else {
//                log.error(msg, e);
//            }
//            return RestResponse.fail(msg);
//        }
//    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse delete(@RequestParam int cid, HttpServletRequest request) {
//        try {
//            contentsService.delete(cid);
//            siteService.cleanCache(Types.C_STATISTICS);
//            new Logs(LogActions.DEL_PAGE, cid + "", request.address(), this.getUid()).save();
//        } catch (Exception e) {
//            String msg = "页面删除失败";
//            if (e instanceof TipException) {
//                msg = e.getMessage();
//            } else {
//                log.error(msg, e);
//            }
//            return RestResponse.fail(msg);
//        }
        return RestResponse.ok();
    }
}
