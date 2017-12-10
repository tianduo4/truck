package com.td.truck.admin.controller;

//import com.blade.Blade;
//import com.blade.Environment;
//import com.blade.ioc.annotation.Inject;
//import com.blade.kit.JsonKit;
//import com.blade.kit.StringKit;
//import com.blade.mvc.http.Request;
//import com.blade.mvc.ui.RestResponse;
//import com.tale.exception.TipException;
//import com.tale.extension.Commons;
//import com.tale.init.TaleConst;
//import com.tale.init.TaleLoader;
//import com.tale.model.dto.LogActions;
//import com.tale.model.dto.ThemeDto;
//import com.tale.model.entity.Logs;
//import com.tale.service.OptionsService;

import com.td.truck.http.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 主题控制器
 */
@Slf4j
@Controller
@RequestMapping("admin/themes")
public class ThemeController extends BaseController {

//    @Inject
//    private OptionsService optionsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
//        // 读取主题
//        String         themesDir  = AttachController.CLASSPATH + "templates/themes";
//        File[]         themesFile = new File(themesDir).listFiles();
//        List<ThemeDto> themes     = new ArrayList<>(themesFile.length);
//        for (File f : themesFile) {
//            if (f.isDirectory()) {
//                ThemeDto themeDto = new ThemeDto(f.getName());
//                if (Files.exists(Paths.get(f.getPath() + "/setting.html"))) {
//                    themeDto.setHasSetting(true);
//                }
//                themes.add(themeDto);
//                try {
//                    Blade.me().addStatics("/templates/themes/" + f.getName() + "/screenshot.png");
//                } catch (Exception e) {
//                }
//            }
//        }
//        request.attribute("current_theme", Commons.site_theme());
//        request.attribute("themes", themes);
        return "admin/themes";
    }

    /**
     * 主题设置页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "setting", method = RequestMethod.GET)
    public String setting(HttpServletRequest request) {
//        String currentTheme = Commons.site_theme();
//        String key          = "theme_" + currentTheme + "_options";
//
//        String              option = optionsService.getOption(key);
//        Map<String, Object> map    = new HashMap<>();
//        try {
//            if (StringKit.isNotBlank(option)) {
//                map = JsonKit.toAson(option);
//            }
//            request.attribute("theme_options", map);
//        } catch (Exception e) {
//            log.error("解析主题设置出现异常", e);
//        }
//        request.attribute("theme_options", map);
        return this.render("setting");
    }

    /**
     * 保存主题配置项
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "setting", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse saveSetting(HttpServletRequest request) {
//        try {
//            Map<String, List<String>> query = request.parameters();
//
//            // theme_milk_options => {  }
//            String currentTheme = Commons.site_theme();
//            String key          = "theme_" + currentTheme + "_options";
//
//            Map<String, String> options = new HashMap<>();
//            query.forEach((k, v) -> options.put(k, v.get(0)));
//
//            optionsService.saveOption(key, JsonKit.toString(options));
//
//            TaleConst.OPTIONS = Environment.of(optionsService.getOptions());
//            new Logs(LogActions.THEME_SETTING, JsonKit.toString(query), request.address(), this.getUid()).save();
//            return RestResponse.ok();
//        } catch (Exception e) {
            String msg = "主题设置失败";
//            if (e instanceof TipException) {
//                msg = e.getMessage();
//            } else {
//                log.error(msg, e);
//            }
            return RestResponse.fail(msg);
//        }
    }

    /**
     * 激活主题
     *
     * @param request
     * @param site_theme
     * @return
     */
    @RequestMapping(value = "active", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse activeTheme(HttpServletRequest request, @RequestParam String site_theme) {
//        try {
//            optionsService.saveOption("site_theme", site_theme);
//            optionsService.deleteOption("theme_option_");
//
//            TaleConst.OPTIONS.set("site_theme", site_theme);
//            BaseController.THEME = "themes/" + site_theme;
//
//            String themePath = "/templates/themes/" + site_theme;
//            try {
//                TaleLoader.loadTheme(themePath);
//            } catch (Exception e) {
//            }
//            new Logs(LogActions.THEME_SETTING, site_theme, request.address(), this.getUid()).save();
//            return RestResponse.ok();
//        } catch (Exception e) {
            String msg = "主题启用失败";
//            if (e instanceof TipException) {
//                msg = e.getMessage();
//            } else {
//                log.error(msg, e);
//            }
            return RestResponse.fail(msg);
//        }
    }

}
