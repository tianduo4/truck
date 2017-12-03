package com.td.truck.admin.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.td.truck.model.User;
import com.td.truck.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//import org.springframework.data.domain.Page;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
    @Autowired
    private UserService userService;


    @RequestMapping("/index")
    public String index(ModelMap map,HttpServletRequest req) throws Exception{
        List<User> users = userService.selectList(new EntityWrapper<User>());
//        Integer page = req.getParameter("page")==null?0:(Integer.parseInt(req.getParameter("page"))-1);
//        UserQo uq = new UserQo();
//        uq.setPage(page);
//        Page<User> pages = userService.findPage(new UserQo());
//
//        map.put("totals",pages.getTotalPages());
//        map.put("page",page+1);
//        map.put("userlist",pages.getContent());
//        map.put("menu_code","mainuser");
        return "user/index";
    }

    @RequestMapping(value="/{id}")
    public String show(ModelMap model,@PathVariable Long id) {
//        User user = userService.findById(id);
//        model.addAttribute("user",user);
        return "user/show";
    }


//    @RequestMapping("/add")
//    public String create(ModelMap model,User user){
//
////        List<Role> roles = roleRepository.findAll();

//        model.addAttribute("roles", roles);
//
//        return "user/add";
//    }

//    @RequestMapping(value="/save", method = RequestMethod.POST)
//    @ResponseBody
//    public String save(User user) throws Exception{
//
//        user.setCreatedate(new Date());
//        BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
//        user.setPassword(bpe.encode(user.getPassword()));
//
//
//        userRepository.save(user);
//        logger.info("新增->ID="+user.getId());
//        return "1";
//    }
//
//    @RequestMapping(value="/edit/{id}")
//    public String update(ModelMap model,@PathVariable Long id){
//        User user = userService.findById(id);
//
//        List<Role> roles = roleRepository.findAll();
//
//        List<Long> rids = new ArrayList<Long>();
//        for(Role role : user.getRoles()){
//            rids.add(role.getId());
//        }
//
//        model.addAttribute("user",user);
//        model.addAttribute("roles", roles);
//        model.addAttribute("rids", rids);
//
//        return "user/edit";
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value="/update")
//    @ResponseBody
//    public String update(User user) throws Exception{
//        userRepository.save(user);
//        logger.info("修改->ID="+user.getId());
//        return "1";
//    }
//
//    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
//    @ResponseBody
//    public String delete(@PathVariable Long id) throws Exception{
//        userService.delete(id);
//        logger.info("删除->ID="+id);
//        return "1";
//    }
//
//    @RequestMapping(value="/test")
//    @ResponseBody
//    public String test() throws Exception{
//
//        userRepository.findOne(Long.valueOf(1));
//        logger.info("我只是测试");
//        return "1";
//    }

}
