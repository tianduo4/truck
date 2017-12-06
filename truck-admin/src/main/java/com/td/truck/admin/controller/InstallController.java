package com.td.truck.admin.controller;

import com.td.truck.http.RestResponse;
import com.td.truck.kit.StringKit;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//package com.td.truck.admin.controller;
//
//
//import com.blade.Environment;
//import com.blade.ioc.annotation.Inject;
//import com.blade.kit.StringKit;
//import com.blade.mvc.annotation.JSON;
//import com.blade.mvc.annotation.Param;
//import com.blade.mvc.annotation.Path;
//import com.blade.mvc.annotation.Route;
//import com.blade.mvc.http.HttpMethod;
//import com.blade.mvc.http.Request;
//import com.blade.mvc.ui.RestResponse;
//import com.tale.controller.admin.AttachController;
//import com.tale.exception.TipException;
//import com.tale.init.TaleConst;
//import com.tale.model.entity.Users;
//import com.tale.service.OptionsService;
//import com.tale.service.SiteService;
//import com.tale.utils.TaleUtils;
//import lombok.extern.slf4j.Slf4j;
//
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
@Slf4j
@Controller
public class InstallController extends BaseController {
//
//    @Inject
//    private SiteService siteService;
//
//    @Inject
//    private OptionsService optionsService;
//
    /**
     * 安装页
     *
     * @return
     */
    @RequestMapping(value = "install", method = RequestMethod.GET)
    public String index(HttpServletRequest request,ModelMap model) {
//        boolean existInstall = Files.exists(Paths.get(AttachController.CLASSPATH + "install.lock"));
//        int allow_reinstall = TaleConst.OPTIONS.getInt("allow_install", 0);
          boolean existInstall=false;
          int allow_reinstall = 0;
        if (allow_reinstall == 1) {
             model.put("is_install",false);
        } else {
             model.put("is_install",false);
        }
        return "install";
    }

    @RequestMapping(value = "install", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse doInstall(String site_title,
                                  String site_url,
                                  String admin_user,
                                  String admin_email,
                                  String admin_pwd) {
//        if (Files.exists(Paths.get(AttachController.CLASSPATH + "install.lock"))
//                && TaleConst.OPTIONS.getInt("allow_install", 0) != 1) {
//            return RestResponse.fail("请勿重复安装");
//        }
        try {
            if (StringKit.isBlank(site_title) ||
                    StringKit.isBlank(site_url) ||
                    StringKit.isBlank(admin_user) ||
                    StringKit.isBlank(admin_pwd)) {
                return RestResponse.fail("请确认网站信息输入完整");
            }

            if (admin_pwd.length() < 6 || admin_pwd.length() > 14) {
                return RestResponse.fail("请输入6-14位密码");
            }

            if (StringKit.isNotBlank(admin_email)
//                    && !TaleUtils.isEmail(admin_email)
                    ) {
                return RestResponse.fail("邮箱格式不正确");
            }

//            Users temp = new Users();
//            temp.setUsername(admin_user);
//            temp.setPassword(admin_pwd);
//            temp.setEmail(admin_email);
//
//            siteService.initSite(temp);

            if (site_url.endsWith("/")) {
                site_url = site_url.substring(0, site_url.length() - 1);
            }
            if (!site_url.startsWith("http")) {
                site_url = "http://".concat(site_url);
            }
//            optionsService.saveOption("site_title", site_title);
//            optionsService.saveOption("site_url", site_url);
//
//            TaleConst.OPTIONS = Environment.of(optionsService.getOptions());
        } catch (Exception e) {
            String msg = "安装失败";
//            if (e instanceof TipException) {
//                msg = e.getMessage();
//            } else {
//                log.error(msg, e);
//            }
            return RestResponse.fail(msg);
        }
        return RestResponse.ok();
    }

}
