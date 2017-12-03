package com.td.truck.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static Logger log = LoggerFactory.getLogger(AdminController.class);

    private final static Integer SIZE = 10;
//    @Autowired
//    private MetasRepository metasRepository;
//
//    @Autowired
//    private AttachRepository attachRepository;
//
//    @Autowired
//    private LinksRepository linksRepository;
//
//    @Autowired
//    private ContentRepository contentRepository;
//
//    @Autowired
//    private RelationshipsRepository relationshipsRepository;
//
//    @Autowired
//    private SiteService siteService;
//
//    @Autowired
//    private UserRepository userRepository;



    @RequestMapping("/index")
    public String index(ModelMap map){


//        Long ccount = contentRepository.count();
//        Long lcount = linksRepository.count();
//        Long acount = attachRepository.count();

        Long ccount = 0L;
        Long lcount = 0L;
        Long acount = 0L;

        map.put("ccount",ccount);//文章数
        map.put("lcount",lcount);//友链数
        map.put("acount",acount);//附件数
//
//        //最新的随机文章
//        Set<Content> contents = new HashSet<Content>();
//        contents = siteService.getRecentArticles();
//
        Set contents= new HashSet();
        map.put("contents",contents);
        map.put("menu_code","mainindex");

        return "admin/index";
    }

//    @RequestMapping("/add")
//    public String add(ModelMap map){
//
//        List<Metas> categorys = metasRepository.findByType(MetaType.CATEGORY.getName());
//        map.put("menu_code","mainarticle");
//        map.put("categorys",categorys);
//
//        return "article/add";
//    }
//    @RequestMapping(value = "/save",method = RequestMethod.POST)
//    @ResponseBody
//    public String save(HttpServletRequest req){
//        Content content = new Content();
//
//        String id = req.getParameter("id");
//        String title = req.getParameter("title");
//        String content1 = req.getParameter("content");
//        String categories = req.getParameter("categories");
//        String tags = req.getParameter("tags");
//        String fmt_type = req.getParameter("fmt_type");
//        String thumb_img = req.getParameter("thumb_img");
//
//        if(StringUtils.isNotEmpty(id)) content.setId(Long.valueOf(id));
//        content.setTags(tags);
//        content.setTitle(title);
//        content.setContent(content1);
//        content.setCreatedate(new Date());
//        content.setHits(0);
//        content.setStatus("已发布");
//        content.setFmt_type(fmt_type);
//        content.setCategories(categories);
//        content.setThumb_img(thumb_img);
//
//        contentRepository.save(content);
//
//        //只要标签不为空就进行清空操作
//
//        //保存或者更新关联的标签分类
//        saveTagsMetas(content.getId(),tags);
//        saveCategoryAndContentRelationships(content.getId(),categories);
//
//        return "1";
//    }
//
//
//    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
//    @ResponseBody
//    public String delete(@PathVariable Long id){
//
//        contentRepository.delete(id);
//
//        relationshipsRepository.deleteByCid(id);
//
//        log.info("删除->id : "+id);
//
//        return "1";
//    }
//
//    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
//    public String edit(@PathVariable Long id,ModelMap map){
//
//        Content one = contentRepository.findOne(id);
//        log.info("edit->id : "+id);
//
//        List<Metas> categorys = metasRepository.findByType(MetaType.CATEGORY.getName());
//        map.put("c",one);
//        map.put("menu_code","mainarticle");
//        map.put("categorys",categorys);
//
//        String categories = one.getCategories();
//        if(StringUtils.isEmpty(categories)){
//            categories ="0";
//        }
//        String[] split = categories.split(",");
//
//        List<String> strings = Arrays.asList(split);
//        map.put("categories",strings);
//
//        return "article/edit";
//    }
//
//    @RequestMapping("/toUpdatePass")
//    public String toUpdatePass(){
//
//        return "admin/updatepass";
//    }
//
//    @RequestMapping(value = "/savepass",method = RequestMethod.POST)
//    @ResponseBody
//    public String savepass(HttpServletRequest req,Authentication authentication){
//
//        String password  = req.getParameter("password");
//        String repassword = req.getParameter("repassword");
//
//        if(!password.equals(repassword)){
//            throw new DataException(400,"密码不相同");
//        }
//        String name = authentication.getName();
//        User user = userRepository.findByUsername(name);
//        user.setPassword(new BCryptPasswordEncoder().encode(password));
//
//        userRepository.save(user);
//
//        return "1";
//    }
//
//
//    /**
//     * 保存标签到单独的表中
//     * @param cid  关联的文章ID
//     * @param tags 标签内容以"，"隔开
//     */
//    public void saveTagsMetas(long cid,String tags){
//
//        if(StringUtils.isEmpty(tags) || cid == 0) return;
//        String[] tagarry =  tags.split(",");
//        relationshipsRepository.deleteByCidAndType(cid,MetaType.TAGS.getName());
//
//        //保存时进行判断，如果不存在该标签再进行保存。
//        for (String s : tagarry){
//            Metas m = metasRepository.findByNameAndType(s.trim(),MetaType.TAGS.getName());
//            //保存完成之后和文章进行关联
//            if(null == m){
//                m = new Metas();
//                m.setType(MetaType.TAGS.getName());
//                m.setName(s.trim());
//                metasRepository.save(m);
//                relationshipsRepository.save(new Relationships(cid,m.getId(),MetaType.TAGS.getName()));
//            }else {
//                relationshipsRepository.save(new Relationships(cid,m.getId(),MetaType.TAGS.getName()));
//            }
//
//
//        }
//    }
//
//    /**
//     * 分类不用保存只能被选择
//     * @param cid
//     * @param categories
//     */
//    public void saveCategoryAndContentRelationships(long cid,String categories){
//
//        if(StringUtils.isEmpty(categories) || cid == 0) return;
//        String[] arry =  categories.split(",");
//
//        relationshipsRepository.deleteByCidAndType(cid,MetaType.CATEGORY.getName());
//
//        for (String s : arry){
//            Relationships r = new Relationships(cid,Long.valueOf(s),MetaType.CATEGORY.getName());
//            relationshipsRepository.save(r);
//
//        }
//    }
//
//    public List<Metas> getCategoryMetas(){
//
//        return metasRepository.findByType(MetaType.CATEGORY.getName());
//
//    }
//    public String convertToString(String categories,List<Metas> cs ){
//        if(StringUtils.isEmpty(categories) ) return "默认分类";
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
}
