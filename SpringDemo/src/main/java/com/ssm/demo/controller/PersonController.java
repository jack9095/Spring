package com.ssm.demo.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.demo.entity.User;
import com.ssm.demo.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping
public class PersonController {

    private Log log = LogFactory.getLog(PersonController.class);

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/selectPerson",method = RequestMethod.GET)
    public void selectPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        long personId = Long.parseLong(request.getParameter("id"));
        User person = personService.findPersonById(personId);

        String s = JSON.toJSONString(person);
        log.error("打印数据 = " + s);
        System.out.println(s);
        ObjectMapper mapper = new ObjectMapper();

//        response.getWriter().write(mapper.writeValueAsString(person));
        response.getWriter().write(s);
        response.getWriter().close();
    }
}
