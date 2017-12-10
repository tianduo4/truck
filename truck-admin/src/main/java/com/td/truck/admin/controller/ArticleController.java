package com.td.truck.admin.controller;

//import com.blade.ioc.annotation.Inject;
//import com.blade.jdbc.page.Page;
//import com.blade.kit.StringKit;
//import com.blade.mvc.http.Request;
//import com.blade.mvc.ui.RestResponse;
//import com.blade.validator.annotation.Valid;
//import com.tale.exception.TipException;
//import com.tale.extension.Commons;
//import com.tale.model.dto.LogActions;
//import com.tale.model.dto.Types;
//import com.tale.model.entity.Contents;
//import com.tale.model.entity.Logs;
//import com.tale.model.entity.Metas;
//import com.tale.model.entity.Users;
//import com.tale.service.ContentsService;
//import com.tale.service.MetasService;
//import com.tale.service.SiteService;

import com.td.truck.http.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 文章管理控制器
 * Created by xushipeng on 2017/2/21.
 */
@Slf4j
@Controller
@RequestMapping("admin/article")
public class ArticleController extends BaseController {

//    @Inject
//    private ContentsService contentsService;
//
//    @Inject
//    private MetasService metasService;
//
//    @Inject
//    private SiteService siteService;

    /**
     * 文章管理首页
     *
     * @param page
     * @param limit
     * @param request
     * @return
     */
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String index(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int limit,
                        HttpServletRequest request, ModelMap model) {

//        Page<Contents> articles = new Contents().where("type", Types.ARTICLE).page(page, limit, "created desc");
//        model.put("articles", articles);
        return "admin/article_list";
    }

    /**
     * 文章发布页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "publish", method = RequestMethod.GET)
    public String newArticle(HttpServletRequest request, ModelMap model) {
//        List<Metas> categories = metasService.getMetas(Types.CATEGORY);
//        model.put("categories", categories);
//        model.put(Types.ATTACH_URL, Commons.site_option(Types.ATTACH_URL, Commons.site_url()));
        return "admin/article_edit";
    }

    /**
     * 文章编辑页面
     *
     * @param cid
     * @param request
     * @return
     */
    @RequestMapping(value = {"/{cid}"}, method = RequestMethod.GET)
    public String editArticle(@PathVariable String cid, HttpServletRequest request, ModelMap model) {
//        Optional<Contents> contents = contentsService.getContents(cid);
//        if (!contents.isPresent()) {
//            return render_404();
//        }
//        model.put("contents", contents.get());
//        List<Metas> categories = metasService.getMetas(Types.CATEGORY);
//        model.put("categories", categories);
//        model.put("active", "article");
//        model.put(Types.ATTACH_URL, Commons.site_option(Types.ATTACH_URL, Commons.site_url()));
        return "admin/article_edit";
    }

    /**
     * 发布文章操作
     *
     * @return
     */
    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ResponseBody
//    public RestResponse publishArticle(@Valid Contents contents) {
    public RestResponse publishArticle() {
//        Users users = this.user();
//        contents.setType(Types.ARTICLE);
//        contents.setAuthorId(users.getUid());
//        if (StringKit.isBlank(contents.getCategories())) {
//            contents.setCategories("默认分类");
//        }

        try {
//            Integer cid = contentsService.publish(contents);
//            siteService.cleanCache(Types.C_STATISTICS);
//            return RestResponse.ok(cid);
            return RestResponse.ok();
        } catch (Exception e) {
            String msg = "文章发布失败";
//            if (e instanceof TipException) {
//                msg = e.getMessage();
//            } else {
//                log.error(msg, e);
//            }
            return RestResponse.fail(msg);
        }
    }

    /**
     * 修改文章操作
     *
     * @return
     */
    @RequestMapping(value = "modify", method = RequestMethod.POST)
    @ResponseBody
//    public RestResponse modifyArticle(@Valid Contents contents) {
    public RestResponse modifyArticle() {
        try {
//            if (null == contents || null == contents.getCid()) {
//                return RestResponse.fail("缺少参数，请重试");
//            }
//            Integer cid = contents.getCid();
//            contentsService.updateArticle(contents);
//            return RestResponse.ok(cid);
            return RestResponse.ok();
        } catch (Exception e) {
            String msg = "文章编辑失败";
//            if (e instanceof TipException) {
//                msg = e.getMessage();
//            } else {
//                log.error(msg, e);
//            }
            return RestResponse.fail(msg);
        }
    }

    /**
     * 删除文章操作
     *
     * @param cid
     * @param request
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse delete(@RequestParam int cid, HttpServletRequest request) {
//        try {
//            contentsService.delete(cid);
//            siteService.cleanCache(Types.C_STATISTICS);
//            new Logs(LogActions.DEL_ARTICLE, cid + "", request.address(), this.getUid()).save();
//        } catch (Exception e) {
//            String msg = "文章删除失败";
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
