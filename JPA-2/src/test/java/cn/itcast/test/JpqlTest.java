package cn.itcast.test;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml") //指定spring容器的配置信息
public class JpqlTest {

    @Autowired(required = false)
    private CustomerDao customerDao;

    @Test
    public void testFindJPQL(){
        Customer customer = customerDao.findJpql("张三");
        System.out.println(customer);
    }

    @Test
    public void testFindCustNameAndId(){
        Customer customer = customerDao.findCustNameAndId(5l,"李四");
        System.out.println(customer);
    }

    /**
     * 测试jpql的更新操作
     *      *SpringDataJpa中使用jpql完成 更新/删除操作
     *          *需要手动添加事务的支持
     *          *默认会执行结束后，回滚事务
     *      @Rollback：设置是否自动回滚
     *              false | true
     */
    @Test
    @Transactional //添加事务的支持
    @Rollback(value = false)
    public void testUpdateCustomer(){
        customerDao.updateCustomer(4l,"王五");
    }

    //测试sql查询
    @Test
    public void testFindSql(){
        List<Object[]> list = customerDao.findSql("李%");
        for (Object[] obj : list) {
            System.out.println(Arrays.toString(obj));
        }
    }

    //测试方法命名规则的查询
    @Test
    public void testNaming(){
        Customer customer = customerDao.findByCustName("张三");
        System.out.println(customer);
    }

    //测试方法命名规则的查询
    @Test
    public void testFindByCustNameLike(){
        List<Customer> list = customerDao.findByCustNameLike("李%");
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    //测试方法命名规则的查询
    @Test
    public void testFindByCustNameLikeAndCustIndustry(){
        Customer customer = customerDao.findByCustNameLikeAndCustIndustry("李%", "嘿嘿");
        System.out.println(customer);
    }
}
