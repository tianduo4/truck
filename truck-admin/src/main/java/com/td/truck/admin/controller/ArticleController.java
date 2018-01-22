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

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.td.truck.admin.common.Commons;
import com.td.truck.admin.common.PageVo;
import com.td.truck.dto.Types;
import com.td.truck.http.RestResponse;
import com.td.truck.model.Content;
import com.td.truck.model.Meta;
import com.td.truck.service.ContentService;
import com.td.truck.service.MetaService;
import com.td.truck.service.SiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * 文章管理控制器
 * Created by xushipeng on 2017/2/21.
 */
@Slf4j
@Controller
@RequestMapping("admin/article")
public class ArticleController extends BaseController {

    @Autowired
    private ContentService contentService;

    @Autowired
    private MetaService metaService;

    @Autowired
    private SiteService siteService;

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
        Page<Content> pageQuery = new Page<Content>();
        pageQuery.setCurrent(page);
        pageQuery.setSize(limit);
        EntityWrapper<Content> ew = new EntityWrapper<Content>();
        ew.orderBy("fcreate_time", false);
        Page<Content> contentPage = contentService.selectPage(pageQuery, ew);
        PageVo<Content> pageVo=new PageVo<Content>(contentPage);
        model.put("pageInfo", pageVo);
        return "admin/content/index";
    }

    /**
     * 文章发布页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "publish", method = RequestMethod.GET)
    public String newArticle(HttpServletRequest request, ModelMap model) {
        List<Meta> categories = metaService.getMetas(Types.CATEGORY);
        model.put("categories", categories);
        model.put(Types.ATTACH_URL, Commons.site_option(Types.ATTACH_URL, Commons.site_url()));
        return "admin/content/add";
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
        Optional<Content> content = Optional.ofNullable(contentService.selectById(cid));
        if (!content.isPresent()) {
            return render_404();
        }
        model.put("content", content.get());
        List<Meta> categories = metaService.getMetas(Types.CATEGORY);
        model.put("categories", categories);
        model.put("active", "article");
        model.put(Types.ATTACH_URL, Commons.site_option(Types.ATTACH_URL, Commons.site_url()));
        return "admin/content/edit";
    }

    /**
     * 发布文章操作
     *
     * @return
     */
    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ResponseBody
//    public RestResponse publishArticle(@Valid Contents contents) {
    public RestResponse publishArticle(Content content) {
//        Users users = this.user();
//        contents.setType(Types.ARTICLE);
//        contents.setAuthorId(users.getUid());
//        if (StringKit.isBlank(contents.getCategories())) {
//            contents.setCategories("默认分类");
//        }

        try {
            boolean flag = contentService.insert(content);
//            Integer cid = contentService.publish(contents);
//            siteService.cleanCache(Types.C_STATISTICS);
//            return RestResponse.ok(cid);
            return RestResponse.ok();
        } catch (Exception e) {
            String msg = "文章发布失败";
//            if (e instanceof TipException) {
//                msg = e.getMessage();
//            } else {
                log.error(msg, e);
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
                log.error(msg, e);
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
        try {
        contentService.deleteById(cid);
//            contentsService.delete(cid);
//            siteService.cleanCache(Types.C_STATISTICS);
//            new Logs(LogActions.DEL_ARTICLE, cid + "", request.address(), this.getUid()).save();
        } catch (Exception e) {
            String msg = "文章删除失败";
//            if (e instanceof TipException) {
//                msg = e.getMessage();
//            } else {
                log.error(msg, e);
//            }
            return RestResponse.fail(msg);
        }
        return RestResponse.ok();
    }
}
