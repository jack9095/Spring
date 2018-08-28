package com.kuanquan;

import com.kuanquan.demo.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration(locations = { "classpath:resources/applicationContext.xml" })
public class DTest {

    @Autowired
    private PersonService personService; //Service

    /**
     * 添加分享
     */
    @Test
    public void addShare(){
//        Share share = new Share();
//        share.setId(UUIDUtil.generateKey());
//        share.setUserid(UUIDUtil.generateKey());
//        share.setShopid(UUIDUtil.generateKey());
//        share.setShareaddress("www.baidu.com");
//        try {
//            shareService.insertShare(share);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

}
