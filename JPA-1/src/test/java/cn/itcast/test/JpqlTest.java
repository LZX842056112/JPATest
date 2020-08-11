package cn.itcast.test;

import cn.itcast.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

//测试jpql查询
public class JpqlTest {
    /**
     * 查询全部
     *      jpql: from cn.itcast.domain.Customer
     *      sql: select * from cst_customer
     */
    @Test
    public void testFindAll(){
        //1.获取EntityManager对象
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.查询全部
        String jpql = "from Customer";
        Query query = em.createQuery(jpql);
        //发送查询，并解封结果集
        List list = query.getResultList();
        for (Object obj : list) {
            System.out.println(obj);
        }
        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }

    /**
     * 排序查询：倒序查询全部客户（根据id倒序）
     *      jpql: from Customer order by custId desc
     *      sql:select * from cst_customer order by cust_id desc
     * 进行jpql查询
     *      1.创建query查询对象
     *      2.对参数进行赋值
     *      3.查询，并得到返回结果
     */
    @Test
    public void testOrders(){
        //1.获取EntityManager对象
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.查询全部
        String jpql = "from Customer order by custId desc";
        Query query = em.createQuery(jpql);
        //发送查询，并解封结果集
        List list = query.getResultList();
        for (Object obj : list) {
            System.out.println(obj);
        }
        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }

    /**
     * 使用jpql查询：统计客户的总数
     *      jpql: select count(custId) from Customer
     *       sql: select count(cust_id) from cst_customer
     */
    @Test
    public void testCount(){
        //1.获取EntityManager对象
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.查询全部
        //根据jpql语句创建query查询对象
        String jpql = "select count(custId) from Customer";
        Query query = em.createQuery(jpql);
        //对参数赋值
        //发送查询，并解封结果集
        //getResultList：直接将查询结果封装为list集合
        //getSingleResult：得到唯一的结果集
        Object result = query.getSingleResult();
        System.out.println(result);
        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }

    /**
     * 分页查询
     *      jpql: from Customer
     *       sql: select * from cst_customer limit 0,2
     */
    @Test
    public void testPaged(){
        //1.获取EntityManager对象
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.查询全部
        //根据jpql语句创建query查询对象
        String jpql = "from Customer";
        Query query = em.createQuery(jpql);
        //对参数赋值 -- 分页参数
        //起始索引
        query.setFirstResult(0);
        //每页查询条数
        query.setMaxResults(2);
        //发送查询，并解封结果集
        //getResultList：直接将查询结果封装为list集合
        //getSingleResult：得到唯一的结果集
        List list = query.getResultList();
        for (Object obj : list) {
            System.out.println(obj);
        }
        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }

    /**
     * 条件查询：查询客户名称以'张'开头的客户
     *      jpql: from Customer where custName like '张%'
     *       sql: select * from cst_customer where cust_name like '张%'
     */
    @Test
    public void testCondition(){
        //1.获取EntityManager对象
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.查询全部
        //根据jpql语句创建query查询对象
        String jpql = "from Customer where custName like ? ";
        Query query = em.createQuery(jpql);
        //对参数赋值 -- 占位符参数
        //第一个参数，占位符的索引位置(从1开始)，第二个参数，取值
        query.setParameter(1,"张%");
        //发送查询，并解封结果集
        //getResultList：直接将查询结果封装为list集合
        //getSingleResult：得到唯一的结果集
        List list = query.getResultList();
        for (Object obj : list) {
            System.out.println(obj);
        }
        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }
}
