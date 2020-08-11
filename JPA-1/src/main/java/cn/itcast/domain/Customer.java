package cn.itcast.domain;

import javax.persistence.*;
/**
 * 客户的实体类
 *      配置映射关系
 *      所有的注解都是使用JPA的规范提供的注解，
 *      所以在导入注解包的时候，一定要导入javax.persistence下的
 *      1.实体类和表的映射关系
 *          @Entity:声明实体类
 *          @Table:配置实体类和表的映射关系
 *              name:配置数据库表的名称
 *      2.实体类中属性和表中字段的映射关系
 * @Entity
 *     作用：指定当前类是实体类。
 * @Table
 *     作用：指定实体类和表之间的对应关系。
 *     属性：
 *     name：指定数据库表的名称
 * @Id
 *     作用：指定当前字段是主键。
 * @GeneratedValue
 *     作用：指定主键的生成方式。。
 *     属性：
 *     strategy ：指定主键生成策略。
 * @Column
 *     作用：指定实体类属性和数据库表之间的对应关系
 *     属性：
 *     name：指定数据库表的列名称。
 *     unique：是否唯一
 *     nullable：是否可以为空
 *     inserttable：是否可以插入
 *     updateable：是否可以更新
 *     columnDefinition: 定义建表时创建此列的DDL
 *     secondaryTable: 从表名。如果此列不建在主表上（默认建在主表），该属性定义该列所在从表的名字搭建开发环境[重点]
 */
@Entity
@Table(name = "cst_customer")
public class Customer {
    /**
     * @Id：声明主键位置
     * @GeneratedValue: 配置主键的生成策略
     *      strategy
     *          GenerationType.IDENTITY：自增 mysql
     *              *底层数据库必须支持自动增长(底层数据库支持的自动增长方式，对id自增)
     *          GenerationType.SEQUENCE：序列，oracle
     *              *底层数据库必须支持序列
     *          GenerationType.TABLE：JPA提供的一种机制，通过一张数据库表的形式帮助我们完成主键自增
     *          GenerationType.AUTO：由程序自动的帮助我们选择主键生成策略
     * @Column:配置属性和字段的映射关系
     *      name：数据库表中字段的名称
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;//客户的主键

    @Column(name="cust_name")
    private String custName;//客户名称

    @Column(name="cust_source")
    private String custSource;//客户来源

    @Column(name="cust_industry")
    private String custIndustry;//客户所属行业

    @Column(name="cust_level")
    private String custLevel;//客户级别

    @Column(name="cust_address")
    private String custAddress;//客户地址

    @Column(name="cust_phone")
    private String custPhone;//客户的联系方式

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }
}
