package com.kuanquan.demo.controller;

import com.alibaba.fastjson.JSON;
import com.kuanquan.demo.entity.Person;
import com.kuanquan.demo.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * mac下Tomcat的玩法：https://blog.csdn.net/yxys01/article/details/77715330
 */

@Controller
@RequestMapping("/person")
public class PersonController {

    private Log log = LogFactory.getLog(PersonController.class);

    @Autowired
    private PersonService personService;

    /**
     * 根据用户id查询对应的记录
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/selectPerson",method = RequestMethod.GET)
    public void selectPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        long personId = Long.parseLong(request.getParameter("id"));
        Person person = personService.findPersonById(personId);

        String s = JSON.toJSONString(person);
        log.error("打印数据 = " + s);
        System.out.println(s);
        ObjectMapper mapper = new ObjectMapper();

//        response.getWriter().write(mapper.writeValueAsString(person));
        response.getWriter().write(s);
        response.getWriter().close();
    }


    /**
     * 根据用户id查询用户名称
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/selectPersonName",method = RequestMethod.GET)
    public void selectPersonName(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        long personId = Long.parseLong(request.getParameter("id"));
        String person = personService.findPersonName(personId);

//        String s = JSON.toJSONString(person);
//        System.out.println(s);
//        ObjectMapper mapper = new ObjectMapper();

//        response.getWriter().write(mapper.writeValueAsString(person));
        response.getWriter().write(person);
        response.getWriter().close();
    }

    /**
     * 删除一条记录
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/deletePerson",method = RequestMethod.GET)
    public void deletePerson(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        long personId = Long.parseLong(request.getParameter("id"));
        personService.deletePerson(personId);

        response.getWriter().write("成功删除了");
        response.getWriter().close();
    }

    /**
     * 更新一条记录
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/updataPerson",method = RequestMethod.GET)
    public void updataPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        long personId = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        System.out.println("名称 = "+ name);
        Person person = new Person();
        person.setUser_id(personId);
        person.setName(name);
//        person.setName("北京");
        personService.updataPerson(person);

        response.getWriter().write("成功更新了");
        response.getWriter().close();
    }

    /**
     * 新增一条记录
     * @param request
     * @param response
     * INSERT INTO user VALUES (user_id,name,age,sex,create_time,_timestamp)
     * @throws IOException
     */
    @RequestMapping(value = "/insertPerson",method = RequestMethod.GET)
    public void insertPerson(HttpServletRequest request, HttpServletResponse response) throws IOException{

        request.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        long personId = Long.parseLong(request.getParameter("id"));

        Person person = new Person();
        person.setUser_id(personId);
        person.setName("北京");
        person.set_timestamp("2018-08-24 14:44:14");
        person.setCreate_time("2014-05-27 18:12:59");
        person.setAge(101);
        person.setSex(0);
        personService.insertPerson(person);

        response.getWriter().write("成功增加了");
        response.getWriter().close();
    }
}
