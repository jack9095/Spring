package com.kuanquan.demo.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuanquan.demo.common.ResponseCode;
import com.kuanquan.demo.common.ServerResponse;
import com.kuanquan.demo.entity.Person;
import com.kuanquan.demo.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * mac下Tomcat的玩法：https://blog.csdn.net/yxys01/article/details/77715330
 *
 * 注解理解
 * https://www.cnblogs.com/xushuai0620/p/8908137.html
 * https://blog.csdn.net/caibaozi0521/article/details/79164161
 */

@Controller
@RequestMapping("/person")
public class PersonControllerNew {

    private Log log = LogFactory.getLog(PersonControllerNew.class);

    @Autowired
    private PersonService personService;

    /**
     * 根据用户id查询对应的记录
     * @throws IOException
     */
    @RequestMapping(value = "/selectPersonNew",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse selectPerson(@RequestParam(value = "id",defaultValue = "0") long id) {
        Person person = personService.findPersonById(id);

        String s = JSON.toJSONString(person);
        log.error("打印数据 = " + s);
        return ServerResponse.createBySuccess("成功获取到",person);
    }
}
