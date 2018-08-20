package com.kuanquan.demo.controller;

import com.kuanquan.demo.entity.Person;
import com.kuanquan.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 参考资料：https://www.cnblogs.com/gczmn/p/8671554.html
 *
 * mac下Tomcat的玩法：https://blog.csdn.net/yxys01/article/details/77715330
 */

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;
    @RequestMapping("/selectPerson")
    public void selectPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");

        long personId = Long.parseLong(request.getParameter("id"));
        Person person =personService.findPersonById(personId);

        ObjectMapper mapper = new ObjectMapper();

        response.getWriter().write(mapper.writeValueAsString(person));
        response.getWriter().close();
    }
}
