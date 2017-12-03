package com.td.truck.admin.controller.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/pages/")
public  class PagesController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(PagesController.class);

    private final static Integer SIZE = 12;

    private static final String[] ICONS = {"bg-ico-book", "bg-ico-game", "bg-ico-note", "bg-ico-chat", "bg-ico-code", "bg-ico-image", "bg-ico-web", "bg-ico-link", "bg-ico-design", "bg-ico-lock"};

//    @Autowired
//    private ContentRepository contentRepository;

//    @Autowired
//    private MetasRepository metasRepository;
//
//    @Autowired
//    private SiteService siteService;


    @RequestMapping("index")
    public String index(ModelMap map, HttpServletRequest req){

        Integer page = req.getParameter("page")==null?0:(Integer.parseInt(req.getParameter("page"))-1);
        Integer size = SIZE;
//        Pageable pages = new PageRequest(page==null?0:page,size,new Sort(Sort.Direction.DESC,"id"));
//
//        Page<Content> linksPage = contentRepository.findAll(pages);
//        List<Content> contents = linksPage.getContent();
//        List<Metas> cs = getCategoryMetas();
//
//        String basepath = req.getContextPath();
//        for (Content c :contents){
//            log.info("转换后的分类字符串------"+show_categories(req,c.getCategories()));
//            c.setCategories(show_categories(req,c.getCategories()));
//            c.setThumb_img(gen_thumb(c));
//        }
//
//        map.put("totals",linksPage.getTotalPages());
//        map.put("page",page+1);
//        map.put("articles",contents);
//        map.put("icons",ICONS);
//        map.put("footas",getRecentArticles());


        return this.render("index");
    }

//    @RequestMapping(value = "article/{id}",method = RequestMethod. GET)
//    public String detail(@PathVariable Long id,ModelMap map){
//
//        Content content = contentRepository.findOne(id);
//        if(null == content){
//            return "403";
//        }
//
//        if("markdown".equals(content.getFmt_type())){
//            log.info("转换后的markdown语言----"+ SystemUtils.markdownToHtml(content.getContent()));
//            content.setContent(SystemUtils.markdownToHtml(content.getContent()));
//        }
//
//        List<Metas> cs = getCategoryMetas();
//
//        String categoryString = convertToString(content.getCategories(),cs);
//        content.setCategories(categoryString);
//        map.put("c",content);
//        //标签需要单独取出来进行迭代
//        List<String> tags = toTags(content.getTags());
//
//        map.put("tags",tags);
//
//
//        return this.render("detail");
//    }
//
//
//    /***
//     * 归档
//     * @param map
//     * @return
//     */
//    @RequestMapping(value = "archives",method = RequestMethod.GET)
//    public String archives(ModelMap map){
//
//        List<Archive> archives = siteService.getArchivesList();
//
//        map.put("archives",archives);
//
//        return this.render("archives");
//    }
//
//    /**
//     * 友情链接页面
//     * @param map
//     * @return
//     */
//    @RequestMapping(value = "links",method = RequestMethod.GET)
//    public String links(ModelMap map){
//
//        List<Links> linksList = siteService.getLinksList();
//
//        map.put("links",linksList);
//
//        return this.render("links");
//    }
//
//    /**
//     * 关于页面
//     * @param map
//     * @return
//     */
//
//    @RequestMapping(value = "about",method = RequestMethod.GET)
//    public String about(ModelMap map){
//        return this.render("about");
//    }
//    /**
//     * 搜索
//     * */
//    @RequestMapping(value = "search/{keywords}",method = RequestMethod.GET)
//    public String search(HttpServletRequest req, ModelMap map, @PathVariable String keywords) {
//
//        Integer page = req.getParameter("page")==null?0:(Integer.parseInt(req.getParameter("page"))-1);
//
//        SearchQo sq = new SearchQo();
//        sq.setTitle(keywords);
//
//        sq.setPage(page);
//        Page<Content> pagecontent = siteService.findContentByKeywords(sq);
//
//        map.put("keywords",keywords);
//        map.put("totals",pagecontent.getTotalPages());
//        map.put("page",page+1);
//        map.put("pageflag","search");
//        map.put("type","搜索");
//        map.put("icons",ICONS);
//        map.put("clists",pagecontent.getContent());
//
//        return this.render("page-category");
//    }
//
//
//    /**
//     * 点击标签进行搜索
//     * */
//    @RequestMapping(value = "tag/{keywords}",method = RequestMethod.GET)
//    public String tag(HttpServletRequest req, ModelMap map, @PathVariable String keywords) {
//
//
//        Integer page = req.getParameter("page")==null?0:(Integer.parseInt(req.getParameter("page"))-1);
//
//
//        if(StringUtils.isEmpty(keywords)) return "403";
//        Metas metas = metasRepository.findByNameAndType(keywords, MetaType.TAGS.getName());
//        if(metas == null) return "403";
//        SearchQo sq = new SearchQo();
//        sq.setTag(keywords);
//
//        sq.setPage(page);
//        Page<Content> pagecontent = siteService.findContentByTags(sq);
//
//        map.put("keywords",keywords);
//        map.put("totals",pagecontent.getTotalPages());
//        map.put("page",page+1);
//        map.put("type","标签");
//        map.put("pageflag","tag");
//        map.put("icons",ICONS);
//        map.put("clists",pagecontent.getContent());
//
//        return this.render("page-category");
//    }
//    /**
//     * 点击分类进行搜索
//     * */
//    @RequestMapping(value = "category/{keywords}",method = RequestMethod.GET)
//    public String category(HttpServletRequest req, ModelMap map, @PathVariable String keywords) {
//
//
//        Integer page = req.getParameter("page")==null?0:(Integer.parseInt(req.getParameter("page"))-1);
//
//
//        if(StringUtils.isEmpty(keywords)) return "403";
//        Metas metas = metasRepository.findOne(Long.valueOf(keywords));
//        if(metas == null) return "403";
//        SearchQo sq = new SearchQo();
//        sq.setCategory(keywords);
//
//        sq.setPage(page);
//        Page<Content> pagecontent = siteService.findContentByCategory(sq);
//
//        map.put("keywords",metas.getName());
//        map.put("categoryid",metas.getId());
//        map.put("totals",pagecontent.getTotalPages());
//        map.put("page",page+1);
//        map.put("type","分类");
//        map.put("pageflag","category");
//        map.put("icons",ICONS);
//        map.put("clists",pagecontent.getContent());
//
//        return this.render("page-category");
//    }
//
//    /**
//     * 底部最新文章
//     * @return
//     */
//
//    @RequestMapping(value = "re_articles",method = RequestMethod.GET)
//    @ResponseBody
//    public AjaxResult getRecentArticles(ModelMap map){
//
//         return new AjaxResult(getRecentArticles());
//
//    }
//
//    public List<Metas> getCategoryMetas(){
//
//        return metasRepository.findByType(MetaType.CATEGORY.getName());
//
//    }
//    public String convertToString(String categories,List<Metas> cs ){
//        if(StringUtils.isEmpty(categories) ) return "1";
//        String[] arry =  categories.split(",");
//        Map<String ,String > maps = new HashMap<String, String>();
//        for(Metas m :cs){
//            maps.put(String.valueOf(m.getId()),m.getName());
//        }
//
//        StringBuffer sb  = new StringBuffer();
//        for (String s:arry){
//            sb.append(",").append(maps.get(s));
//        }
//
//        return sb.toString().substring(1);
//    }
//    public List<String> toTags(String tags){
//        if(StringUtils.isEmpty(tags)) return null;
//        List<String> ts = new ArrayList<String>();
//        String[] arry = tags.split(",");
//
//        return Arrays.asList(arry);
//    }
//
//    //生成展示图片
//    public String gen_thumb(Content content){
//        String getfirst = SystemUtils.get_first_thumb(content.getContent());
//        if(StringUtils.isEmpty(getfirst)){
//            int cid = Integer.parseInt(String.valueOf(content.getId()));
//            int size = cid % 20;
//            size = size == 0 ? 1 : size;
//            return "/ui/pages/img/rand/" + size + ".jpg";
//        }else {
//            return getfirst;
//        }
//    }
//
//    /**
//     * 分类的转换显示
//     * @param categories
//     */
//    public  String show_categories(HttpServletRequest req,String categories) {
//        String basepath = req.getContextPath();
//        if (StringUtils.isNotBlank(categories)) {
//            String[] arr = categories.split(",");
//            StringBuffer sbuf = new StringBuffer();
//            for (String c : arr) {
//                Metas   m = metasRepository.findOne(Long.valueOf(c));
//                sbuf.append("<a href=\""+basepath+"/pages/category/" +c + "\">" + m.getName() + "</a>");
//            }
//            return sbuf.toString();
//        }
//        return show_categories(req,"1");
//    }
//
//    /**
//     * 获取最近的文章
//     */
//    public AjaxResult getRecentArticles(){
//
//        Set<Content> contents = new HashSet<Content>();
//
//        contents = siteService.getRecentArticles();
//
//        return new AjaxResult(contents);
//    }


}
