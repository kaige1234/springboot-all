package cn.com.sk.rocketmq.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author astupidcoder
 * @since 2021-09-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SecStaff extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 员工ID（PK）
     */
    @TableId(value = "STAFF_ID", type = IdType.AUTO)
    private Long staffId;

    /**
     * CRM统一员工编码
     */
    @TableField("CRM_STAFF_CODE")
    private String crmStaffCode;

    /**
     * ERP员工编码
     */
    @TableField("STAFF_CODE")
    private String staffCode;

    /**
     * 员工姓名
     */
    @TableField("STAFF_NAME")
    private String staffName;

    /**
     * 所属组织
     */
    @TableField("ORGANIZE_CODE")
    private String organizeCode;

    /**
     * 证件类型
     */
    @TableField("CARD_TYPE_ID")
    private String cardTypeId;

    /**
     * 证件号码
     */
    @TableField("CARD_NO")
    private String cardNo;

    /**
     * 性别
     */
    @TableField("GENDER")
    private String gender;

    /**
     * 学历
     */
    @TableField("EDUCATION_LEVEL")
    private String educationLevel;

    /**
     * 手机号码
     */
    @TableField("MOBILE_NO")
    private String mobileNo;

    /**
     * EMAIL地址
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 联系地址
     */
    @TableField("CONTACT_ADDRESS")
    private String contactAddress;

    /**
     * 员工类别
     */
    @TableField("STAFF_TYPE")
    private String staffType;

    /**
     * 业务线
     */
    @TableField("BUSINESS_LINE")
    private String businessLine;

    /**
     * ERP专业信息
     */
    @TableField("PROFESSION_ERP")
    private String professionErp;

    /**
     * 用工类型；1-正式；2-临时
     */
    @TableField("EMPLOY_TYPE")
    private String employType;

    /**
     * 用工性质：合同用工A类、合同用工B类、劳务用工、其他
     */
    @TableField("EMPLOYMENT_NATURE")
    private String employmentNature;

    /**
     * 是否销售人员；1-是；2-否
     */
    @TableField("SALE_EMP_SIGN")
    private String saleEmpSign;

    /**
     * 岗位级别：客户经理1-11级以及兼职营销人员一共12个选项
     */
    @TableField("STATION_LEVEL")
    private String stationLevel;

    /**
     * 员工职位（ERP）
     */
    @TableField("EMP_POST")
    private String empPost;

    /**
     * 职业类型;1-专职人员；2-兼职人员
     */
    @TableField("CAREER_TYPE")
    private String careerType;

    /**
     * 从事营销工作时间：在下拉菜单中选取年份及月份
     */
    @TableField("MARKETING_WORK_DATE")
    private Date marketingWorkDate;

    /**
     * 参加工作时间：在下拉菜单中选取年份及月份
     */
    @TableField("BEGIN_WORK_DATE")
    private Date beginWorkDate;

    /**
     * 账号有效期
     */
    @TableField("ACCOUNT_VALID_DATE")
    private Date accountValidDate;

    /**
     * 员工在职状态ERP
     */
    @TableField("WORK_STATUS")
    private String workStatus;

    /**
     * 员工状态ERP;01-生效;02-失效
     */
    @TableField("STATUS_ERP")
    private String statusErp;

    /**
     * CRM员工状态1-生效；0-失效
     */
    @TableField("STATUS")
    private String status;

    /**
     * 限制授权;1-是；0-否
     */
    @TableField("AUTH_RESTRICT")
    private String authRestrict;

    /**
     * 创建时间
     */
    @TableField("CREATED_TIME")
    private Date createdTime;

    /**
     * 创建人员工编号
     */
    @TableField("CREATED_BY_USER_C_CODE")
    private String createdByUserCCode;

    /**
     * 创建人员工姓名
     */
    @TableField("CREATED_BY_USER_C_NAME")
    private String createdByUserCName;

    /**
     * 创建人机构编码
     */
    @TableField("CREATED_BY_ORG_CODE")
    private String createdByOrgCode;

    /**
     * 创建人机构名称
     */
    @TableField("CREATED_BY_ORG_NAME")
    private String createdByOrgName;

    /**
     * 修改时间
     */
    @TableField("UPDATED_TIME")
    private Date updatedTime;

    /**
     * 修改人员工编号
     */
    @TableField("UPDATED_BY_USER_C_CODE")
    private String updatedByUserCCode;

    /**
     * 修改人员工姓名
     */
    @TableField("UPDATED_BY_USER_C_NAME")
    private String updatedByUserCName;

    /**
     * 修改人机构编码
     */
    @TableField("UPDATED_BY_ORG_CODE")
    private String updatedByOrgCode;

    /**
     * 修改人机构名称
     */
    @TableField("UPDATED_BY_ORG_NAME")
    private String updatedByOrgName;

    /**
     * 失效时间
     */
    @TableField("EXPIRE_DATE")
    private Date expireDate;

    /**
     * 数据来源;1-CRM新增;2-CRM批量导入;3-ERP系统;
     */
    @TableField("DATA_SOURCE")
    private String dataSource;

    /**
     * 岗位标签
     */
    @TableField("STATION_LABLE")
    private String stationLable;

    /**
     * 员工标签
     */
    @TableField("STAFF_LABLE")
    private String staffLable;

    /**
     * 营销岗位；1=销售（现职）、2=销售（非现职）、3=设计和策划（现职）、4=设计和策划（非现职）。
     */
    @TableField("MARKET_STATION")
    private String marketStation;


}
