package com.td.truck.admin.controller;

import com.td.truck.utils.MapCache;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by King on 2017/12/5.
 */
public abstract class BaseController {
    public static String THEME = "themes/default";

    protected MapCache cache = MapCache.single();

    public String render(String viewName) {
        return THEME + "/" + viewName;
    }

    public BaseController title(HttpServletRequest request, String title) {
        request.setAttribute("title", title);
        return this;
    }

    public BaseController keywords(HttpServletRequest request, String keywords) {
        request.setAttribute("keywords", keywords);
        return this;
    }

//    public Users user() {
//        return TaleUtils.getLoginUser();
//    }
//
//    public Integer getUid() {
//        return this.user().getUid();
//    }

    public String render_404() {
        return "/comm/error_404";
    }

}
