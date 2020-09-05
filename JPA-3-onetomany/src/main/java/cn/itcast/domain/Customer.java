package cn.itcast.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 1.实体类和表的映射关系
 *      @Entity
 *      @Table
 * 2.类中属性和表中字段的映射关系
 *      @Id
 *      @GeneratedValue
 *      @Column
 */
@Entity
@Table(name = "cst_customer")
public class Customer {

    @Id//声明当前私有属性为主键
    @GeneratedValue(strategy= GenerationType.IDENTITY) //配置主键的生成策略
    @Column(name="cust_id") //指定和表中cust_id字段的映射关系
    private Long custId;

    @Column(name="cust_name") //指定和表中cust_name字段的映射关系
    private String custName;

    @Column(name="cust_source")//指定和表中cust_source字段的映射关系
    private String custSource;

    @Column(name="cust_industry")//指定和表中cust_industry字段的映射关系
    private String custIndustry;

    @Column(name="cust_level")//指定和表中cust_level字段的映射关系
    private String custLevel;

    @Column(name="cust_address")//指定和表中cust_address字段的映射关系
    private String custAddress;

    @Column(name="cust_phone")//指定和表中cust_phone字段的映射关系
    private String custPhone;

    //配置客户和联系人之间的关系（一对多关系）
    /**
     * 使用注解的形式配置多表关系
     *      1.声明关系
     *          @OneToMany : 配置一对多关系
     *              targetEntity ：对方对象的字节码对象
     *      2.配置外键（中间表）
     *              @JoinColumn : 配置外键
     *                  name：外键字段名称
     *                  referencedColumnName：参照的主表的主键字段名称
     * 在客户实体类上（一的一方）添加了外键了配置，所以对于客户而言，也具备了维护外键的作用
     */

//    @OneToMany(targetEntity = LinkMan.class)
//    @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")
    /**
     * 放弃外键维护权
     *      mappedBy：对方配置关系的属性名称\
     * cascade : 配置级联（可以配置到设置多表的映射关系的注解上）
     *      CascadeType.all         : 所有
     *                  MERGE       ：更新
     *                  PERSIST     ：保存
     *                  REMOVE      ：删除
     *
     * fetch : 配置关联对象的加载方式
     *          EAGER   ：立即加载
     *          LAZY    ：延迟加载
     */
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<LinkMan> linkMans = new HashSet<>();

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

    public Set<LinkMan> getLinkMans() {
        return linkMans;
    }

    public void setLinkMans(Set<LinkMan> linkMans) {
        this.linkMans = linkMans;
    }
}
