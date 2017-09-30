package com.lanou.controller;

import com.lanou.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by dllo on 17/9/29.
 */
@Controller
public class MainController {
//    输入页面 ->
    // /index -> home.jsp

    @RequestMapping(value = "/index")
    public String frontPage(){

        return "home";
    }
    @RequestMapping(value = "/one")
    public String first(){
        return "practice";
    }



    @RequestMapping(value = "/add")
    public String add(){
        return "/user/add";
    }
// /infopage/222/33/444
    //nicname
    //  /infopage/用户名/昵称
    @RequestMapping(value = "/infopage/{username}/{nickname}")
    public String del(@PathVariable("username")String name,@PathVariable("nickname") String nickname){
        System.out.println(name);
        System.out.println(nickname);
        return "del";
    }


//  /infopage?username=222
    //1.  /params?username=222&password=33
    @RequestMapping(value = "/params")
    public String save(@RequestParam("username") String name,
                       @RequestParam("password") String pwd){
        System.out.println(name);
        System.out.println(pwd);
        return "params";
    }

    //2.
    @RequestMapping(value = "/save")
    public String save(@RequestParam Map<String ,String> params){
        System.out.println(params);
        return "save";
    }


    //怎样才能兼容post get请求??????????????????????????????????????
    @RequestMapping(value = "/stu",method = RequestMethod.GET)
    public String studentPage(Student student){
        System.out.println(student);
        return "save";
    }
    //  get/post

    //  json/xml

    //1.返回json数据
    @ResponseBody
    @RequestMapping(value = "/student")
    public Student studentInfo(Student student){
//        Student student = new Student();
//        student.setPassword("111");
//        student.setUsername("zs");
//        student.setHobby("打豆豆");
        return student;
    }

    //怎么样使用springMVC返回json/xml数据
    //springMVC需要jackson库才能进行json数据解析和构成

    // jackson-databind
    // jackson-core

    // annotation


    // Restful 国际标准

    // 1.返回的格式必须是map/实体类: key-value
    // 2.必须有反馈信息:errorCode(错误代码), msg(具体的错误信息)
    // 3.必须要精简,不要把没有意义,将来也不会用到的字段放到json中
    // 4.文档(数据接口文档)必须要详细  前端页面流程文档
}

    /*
    SpringMVC的原理
    1.用户发送请求给服务器. URI:/index
    2.请求会发送给DispatcherServlet,因为只web.xml里配置了,
    所有的请求都会交给dispatcherServlet处理
    3.在dispatcherServlet内部,通过HandlerMapping检查是否有方法和URI对应
    4.如果有,就调用该方法,获得jsp文件名
    5.viewResovler根据文件名获取相应的jsp文件,转化为视图对象
    6.dispatcherServlet将视图对象发送给服务器,由服务器最终发送给用户浏览器
     */




    //利用Ajax和springMVC写一个留言板