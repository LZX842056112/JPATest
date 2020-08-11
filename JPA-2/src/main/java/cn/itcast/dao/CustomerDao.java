package cn.itcast.dao;

import cn.itcast.domain.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 符合SpringDataJpa的dao接口规范
 *      JpaRepository<操作实体类类型，实体类中主键属性的类型>
 *          *封装了基本的CRUD操作
 *      JpaSpecificationExecutor<操作实体类类型>
 *          *封装了复杂查询(分页)
 */
public interface CustomerDao extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {
    /**
     * 案例：根据客户名查询客户，使用jpql的形式查询
     * jpql：from Customer where custName = ?1
     * 配置jpql语句，使用的@Query注解
     */
    @Query(value="from Customer where custName = ?1")
    public Customer findJpql(String custName);

    /**
     * 案例：根据客户名称和客户id查询客户
     *      jpql:from Customer where custName = ?1 and custId = ?1
     * 对于多个占位符参数
     *      赋值的时候，默认情况下，占位符的位置需要和方法参数中的位置保持一致
     * 可以指定占位符参数的位置
     *      ? 索引的方式：指定此占位符的取值来源
     */
    @Query(value = "from Customer where custName = ?2 and custId =?1")
    //public Customer findCustNameAndId(String name,Long id);
    public Customer findCustNameAndId(Long id,String name);

    /**
     * 使用jpql完成更新操作
     *      案例：根据id更新，客户的名称
     * sql: update cst_customer set cust_name = ? where cust_id = ?
     * jpql: update Customer set custName = ?2 where custId = ?1
     *
     * @Query：代表的是进行查询
     *      *声明此方法是用来进行更新操作
     * @Modifying
     *      *当前执行的是一个更新操作
     */
    @Query(value = "update Customer set custName = ?2 where custId = ?1")
    @Modifying
    public void updateCustomer(Long custId,String custName);

    /**
     * 使用sql的形式查询：
     *      查询全部的客户
     *  sql：select * from cst_customer
     *  Query：配置sql查询
     *      value：sql语句
     *      nativeQuery：查询方式
     *          true：sql查询
     *          false：jpql查询
     */
    //@Query(value = "select * from cst_customer",nativeQuery = true)
    @Query(value = "select * from cst_customer where cust_name like ?1",nativeQuery = true)
    public List<Object[]> findSql(String name);
}