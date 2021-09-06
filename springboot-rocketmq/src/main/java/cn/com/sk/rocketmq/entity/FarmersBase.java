package cn.com.sk.rocketmq.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 农户(家庭农场)基础信息
 * </p>
 *
 * @author astupidcoder
 * @since 2021-09-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("FARMERS_BASE")
public class FarmersBase extends Model {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private Long id;

    /**
     * 客户类别，普通农户、登记家庭农场
     */
    @TableField("CUSTOMER_TYPE")
    private String customerType;

    /**
     * 农户(家庭农场主)
     */
    @TableField("FARMER")
    private String farmer;

    /**
     * 年龄
     */
    @TableField("AGE")
    private Integer age;

    /**
     * 生日
     */
    @TableField("BIRTHDAY")
    private String birthday;

    /**
     * 性别，M：男，F：女
     */
    @TableField("SEX")
    private String sex;

    /**
     * 农户（家庭农场主）身份证号码
     */
    @TableField("IDENTITY_NUMBER")
    private String identityNumber;

    private String mobile;

    /**
     * 省行政区划
     */
    @TableField("PROVINCE_CODE")
    private String provinceCode;

    /**
     * 省份
     */
    @TableField("PROVINCE")
    private String province;

    /**
     * 市行政区划
     */
    @TableField("CITY_CODE")
    private String cityCode;

    /**
     * 市
     */
    @TableField("CITY")
    private String city;

    /**
     * 区县行政区划
     */
    @TableField("COUNTY_CODE")
    private String countyCode;

    /**
     * 区县
     */
    @TableField("COUNTY")
    private String county;

    /**
     * 详细地址
     */
    @TableField("ADDRESS")
    private String address;

    /**
     * 是否属于建档贫苦户
     */
    @TableField("IS_ARCHIVE_POOR")
    private Boolean isArchivePoor;

    /**
     * 是否属于农民合作社或合作社联合社社员
     */
    @TableField("IS_COOPERATIVE_MEMBER")
    private Boolean isCooperativeMember;

    /**
     * 证件类型：统一社会信用代码
     */
    @TableField("IDENTITY_TYPE")
    private String identityType;

    /**
     * 统一社会信用代码
     */
    @TableField("IDENTITY_NO")
    private String identityNo;

    /**
     * 家庭农场级别
     */
    @TableField("FAMILY_FARM_LEVEL")
    private String familyFarmLevel;

    /**
     * 其它家庭农场级别
     */
    @TableField("OTHER_FAMILY_FARM_LEVEL")
    private String otherFamilyFarmLevel;

    /**
     * 客户评价
     */
    @TableField("EVALUATION")
    private String evaluation;

    /**
     * 潜在需求
     */
    @TableField("POTENTIAL_DEMAND")
    private String potentialDemand;

    /**
     * 其它备注信息
     */
    @TableField("REMARKS")
    private String remarks;

    /**
     * 联系电话
     */
    @TableField("CREATOR_CONTACTS_TEL")
    private String creatorContactsTel;

    /**
     * 走访信贷员
     */
    @TableField("LOAN_OFFICER")
    private String loanOfficer;

    /**
     * 走访信贷员工号
     */
    @TableField("LOAN_OFFICER_JOB_NUMBER")
    private String loanOfficerJobNumber;

    /**
     * 走访信贷员联系方式
     */
    @TableField("LOAN_OFFICER_CONTACTS_TEL")
    private String loanOfficerContactsTel;

    /**
     * 走访日期
     */
    @TableField("VISITED_DATE")
    private LocalDate visitedDate;

    /**
     * 是否crm会员
     */
    @TableField("IS_CRM_MEMBER")
    private Boolean isCrmMember;

    /**
     * crm会员主键
     */
    @TableField("CRM_MEMBER_ID")
    private Long crmMemberId;

    /**
     * 采集完整度
     */
    @TableField("INTEGRITY")
    private Integer integrity;

    /**
     * 必填项采集完整度
     */
    @TableField("REQUIRED_FIELD_INTEGRITY")
    private Integer requiredFieldIntegrity;

    /**
     * 所属机构编码
     */
    @TableField("ORGANIZE_CODE")
    private String organizeCode;

    /**
     * 所属机构名称
     */
    @TableField("ORGANIZE_NAME")
    private String organizeName;

    /**
     * 数据状态,0:删除,1:正常
     */
    @TableField("DATA_STATUS")
    private Boolean dataStatus;

    /**
     * 创建人
     */
    @TableField("CREATOR")
    private String creator;

    /**
     * 创建人姓名
     */
    @TableField("CREATOR_NAME")
    private String creatorName;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    @TableField("MODIFIER")
    private String modifier;

    /**
     * 修改人姓名
     */
    @TableField("MODIFIER_NAME")
    private String modifierName;

    /**
     * 修改时间
     */
    @TableField("MODIFY_TIME")
    private LocalDateTime modifyTime;

    /**
     * 是否获取客户信息使用授权
     */
    @TableField("OBTAINED_USE_AUTHORIZATION")
    private Boolean obtainedUseAuthorization;

    /**
     * 走访信贷员所属机构号
     */
    @TableField("LOAN_OFFICER_ORGANIZE_CODE")
    private String loanOfficerOrganizeCode;

    /**
     * 走访信贷员所属机构名称
     */
    @TableField("LOAN_OFFICER_ORGANIZE_NAME")
    private String loanOfficerOrganizeName;

    /**
     * 商户类别
     */
    @TableField("MERCHANT_TYPE")
    private String merchantType;

    /**
     * 经营实体名称
     */
    @TableField("OPERATING_ENTITY_NAME")
    private String operatingEntityName;

    /**
     * 经营场地性质
     */
    @TableField("NATURE_BUSINESS_SITE")
    private String natureBusinessSite;

    /**
     * 推荐所属协同项目
     */
    @TableField("COLLABORATIVE_PROJECT")
    private String collaborativeProject;

    /**
     * 乡镇区划
     */
    @TableField("TOWN_CODE")
    private String townCode;

    /**
     * 乡镇
     */
    @TableField("TOWN")
    private String town;

    /**
     * 村区划
     */
    @TableField("VILLAGE_CODE")
    private String villageCode;

    /**
     * 村
     */
    @TableField("VILLAGE")
    private String village;

    /**
     * 采集完整度基数
     */
    @TableField("INTEGRITY_CARDINAL")
    private Integer integrityCardinal;

    /**
     * 经营地址是否在本市
     */
    @TableField("BUSINESS_ADDRESS_IS_LOCAL")
    private Boolean businessAddressIsLocal;

    /**
     * 居住地址是否在本市
     */
    @TableField("RESIDENTIAL_ADDRESS_IS_LOCAL")
    private Boolean residentialAddressIsLocal;

    /**
     * 经营地址省区划
     */
    @TableField("OPERATE_PROVINCE_CODE")
    private String operateProvinceCode;

    /**
     * 经营地址省名称
     */
    @TableField("OPERATE_PROVINCE")
    private String operateProvince;

    /**
     * 经营地址市区划
     */
    @TableField("OPERATE_CITY_CODE")
    private String operateCityCode;

    /**
     * 经营地址市名称
     */
    @TableField("OPERATE_CITY")
    private String operateCity;

    /**
     * 经营地址县区划
     */
    @TableField("OPERATE_COUNTY_CODE")
    private String operateCountyCode;

    /**
     * 经营地址县名称
     */
    @TableField("OPERATE_COUNTY")
    private String operateCounty;

    /**
     * 经营地址乡镇区划
     */
    @TableField("OPERATE_TOWN_CODE")
    private String operateTownCode;

    /**
     * 经营地址乡镇名称
     */
    @TableField("OPERATE_TOWN")
    private String operateTown;

    /**
     * 经营地址村区划
     */
    @TableField("OPERATE_VILLAGE_CODE")
    private String operateVillageCode;

    /**
     * 经营地址村名称
     */
    @TableField("OPERATE_VILLAGE")
    private String operateVillage;

    /**
     * 经营地址
     */
    @TableField("OPERATE_ADDRESS")
    private String operateAddress;

    @TableField("MANAGE_ORGANIZE_CODE")
    private String manageOrganizeCode;

    @TableField("MANAGE_ORGANIZE_NAME")
    private String manageOrganizeName;


}
