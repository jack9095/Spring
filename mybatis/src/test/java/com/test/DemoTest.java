package com.test;

import com.kuanquan.QueryUserDaoInvoke;
import com.kuanquan.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试类
 */
public class DemoTest {
    @Test
    public void test() throws IOException {
//      QueryUserApi api = new QueryUserApi();
//      User user = api.findUserById(1);
//      System.out.println(user);

        //mybatis的配置文件
        String resource = "MyBatisConfig.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = DemoTest.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
//        String statement = "com.company.User.getUser";//映射sql的标识字符串

        QueryUserDaoInvoke userMapper = session.getMapper(QueryUserDaoInvoke.class);

        //执行查询返回一个唯一user对象的sql
        List<User> lists = userMapper.findUserById("Sam");
        System.out.println(lists.size());

        session.close();
    }
}
