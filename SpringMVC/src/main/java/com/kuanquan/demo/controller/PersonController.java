package com.kuanquan.demo.controller;

import com.alibaba.fastjson.JSON;
import com.kuanquan.demo.entity.Person;
import com.kuanquan.demo.service.PersonService;
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

    @Autowired
    private PersonService personService;
    @RequestMapping(value = "/selectPerson",method = RequestMethod.GET)
    public void selectPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        long personId = Long.parseLong(request.getParameter("id"));
        Person person = personService.findPersonById(personId);

        String s = JSON.toJSONString(person);
        System.out.println(s);
        ObjectMapper mapper = new ObjectMapper();

//        response.getWriter().write(mapper.writeValueAsString(person));
        response.getWriter().write(s);
        response.getWriter().close();
    }
}
