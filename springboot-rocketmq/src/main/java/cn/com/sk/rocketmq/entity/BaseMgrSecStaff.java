package cn.com.sk.rocketmq.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "sec_staff")
public class BaseMgrSecStaff {
    /**
     * 员工ID（PK）
     */
    @Id
    @Column(name = "STAFF_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;

    /**
     * CRM统一员工编码
     */
    @Column(name = "CRM_STAFF_CODE")
    private String crmStaffCode;

    /**
     * ERP员工编码
     */
    @Column(name = "STAFF_CODE")
    private String staffCode;

    /**
     * 员工姓名
     */
    @Column(name = "STAFF_NAME")
    private String staffName;

    /**
     * 所属组织
     */
    @Column(name = "ORGANIZE_CODE")
    private String organizeCode;

    /**
     * 证件类型
     */
    @Column(name = "CARD_TYPE_ID")
    private String cardTypeId;

    /**
     * 证件号码
     */
    @Column(name = "CARD_NO")
    private String cardNo;

    /**
     * 性别
     */
    @Column(name = "GENDER")
    private String gender;

    /**
     * 学历
     */
    @Column(name = "EDUCATION_LEVEL")
    private String educationLevel;

    /**
     * 手机号码
     */
    @Column(name = "MOBILE_NO")
    private String mobileNo;

    /**
     * EMAIL地址
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 联系地址
     */
    @Column(name = "CONTACT_ADDRESS")
    private String contactAddress;

    /**
     * 员工类别
     */
    @Column(name = "STAFF_TYPE")
    private String staffType;

    /**
     * 业务线
     */
    @Column(name = "BUSINESS_LINE")
    private String businessLine;

    /**
     * ERP专业信息
     */
    @Column(name = "PROFESSION_ERP")
    private String professionErp;

    /**
     * 用工类型；1-正式；2-临时
     */
    @Column(name = "EMPLOY_TYPE")
    private String employType;

    /**
     * 用工性质：合同用工A类、合同用工B类、劳务用工、其他
     */
    @Column(name = "EMPLOYMENT_NATURE")
    private String employmentNature;

    /**
     * 是否销售人员；1-是；2-否
     */
    @Column(name = "SALE_EMP_SIGN")
    private String saleEmpSign;

    /**
     * 岗位级别：客户经理1-10级以及兼职营销人员一共11个选项
     */
    @Column(name = "STATION_LEVEL")
    private String stationLevel;

    /**
     * 员工职位（ERP）
     */
    @Column(name = "EMP_POST")
    private String empPost;

    /**
     * 职业类型;1-专职人员；2-兼职人员
     */
    @Column(name = "CAREER_TYPE")
    private String careerType;

    /**
     * 从事营销工作时间：在下拉菜单中选取年份及月份
     */
    @Column(name = "MARKETING_WORK_DATE")
    private Date marketingWorkDate;

    /**
     * 参加工作时间：在下拉菜单中选取年份及月份
     */
    @Column(name = "BEGIN_WORK_DATE")
    private Date beginWorkDate;

    /**
     * 员工在职状态ERP
     */
    @Column(name = "WORK_STATUS")
    private String workStatus;

    /**
     * 员工状态ERP;01-生效;02-失效
     */
    @Column(name = "STATUS_ERP")
    private String statusErp;

    /**
     * CRM员工状态1-生效；0-失效
     */
    @Column(name = "STATUS")
    private String status;
    /**
     * 限制授权;1-是；0-否
     */
    @Column(name = "AUTH_RESTRICT")
    private String authRestrict;
    /**
     * 创建时间
     */
    @Column(name = "CREATED_TIME")
    private Date createdTime;

    /**
     * 创建人员工编号
     */
    @Column(name = "CREATED_BY_USER_C_CODE")
    private String createdByUserCCode;

    /**
     * 创建人员工姓名
     */
    @Column(name = "CREATED_BY_USER_C_NAME")
    private String createdByUserCName;

    /**
     * 创建人机构编码
     */
    @Column(name = "CREATED_BY_ORG_CODE")
    private String createdByOrgCode;

    /**
     * 创建人机构名称
     */
    @Column(name = "CREATED_BY_ORG_NAME")
    private String createdByOrgName;

    /**
     * 修改时间
     */
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;

    /**
     * 修改人员工编号
     */
    @Column(name = "UPDATED_BY_USER_C_CODE")
    private String updatedByUserCCode;

    /**
     * 修改人员工姓名
     */
    @Column(name = "UPDATED_BY_USER_C_NAME")
    private String updatedByUserCName;

    /**
     * 修改人机构编码
     */
    @Column(name = "UPDATED_BY_ORG_CODE")
    private String updatedByOrgCode;

    /**
     * 修改人机构名称
     */
    @Column(name = "UPDATED_BY_ORG_NAME")
    private String updatedByOrgName;

    /**
     * 失效时间
     */
    @Column(name = "EXPIRE_DATE")
    private Date expireDate;

    /**
     * 数据来源;1-CRM新增;2-CRM批量导入;3-ERP系统;
     */
    @Column(name = "DATA_SOURCE")
    private String dataSource;

    /**
     * 账号有效期
     */
    @Column(name = "ACCOUNT_VALID_DATE")
    private Date accountValidDate;
    /**
     * 岗位标签
     */
    @Column(name = "STATION_LABLE")
    private String stationLable;
    /**
     * 员工标签
     */
    @Column(name = "STAFF_LABLE")
    private String staffLable;

    /**
     * 营销岗位
     */
    @Column(name = "MARKET_STATION")
    private String marketStation;
}