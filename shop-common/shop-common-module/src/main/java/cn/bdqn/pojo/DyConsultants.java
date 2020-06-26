package cn.dy.pojo;
import java.io.Serializable;
import java.util.Date;
/***
*   
*/
public class DyConsultants implements Serializable {
    //
    private Long id;
    //注册手机号
    private String phone;
    //咨询师密码
    private String password;
    //培训师真实姓名
    private String realName;
    //
    private Date birthday;
    //年龄
    private Integer age;
    //联系电话
    private String linkdPhone;
    //常用邮箱
    private String email;
    //身份证号
    private String idCard;
    //身份证正面照
    private String idCardPositiveUrl;
    //身份证背面照
    private String idCardBackUrl;
    //银行卡号
    private String bankCard;
    //用户头像
    private String avatarUrl;
    //经历
    private String experience;
    //擅长领域
    private String expertise;
    //背景图片地址
    private String backgroundUrl;
    //省份编号
    private String provinceNo;
    //城市编号
    private String cityNo;
    //常用地址
    private String address;
    //心理咨询师级别
    private Long levelId;
    //荣誉
    private String honor;
    //粉丝数
    private Integer fansCounts;
    //openId
    private String wxid;
    //第三方登录QQId
    private String qqId;
    //是否已经完善信息;radio;(0:未完善,1:已完善)
    private Integer isPerfectInformation;
    //审核状态;radio;(0:审核失败,1:审核成功)
    private Integer status;
    //创建时间
    private Date createdTime;
    //更新时间
    private Date updatedTime;
    //get set 方法
    public void setId (Long  id){
        this.id=id;
    }
    public  Long getId(){
        return this.id;
    }
    public void setPhone (String  phone){
        this.phone=phone;
    }
    public  String getPhone(){
        return this.phone;
    }
    public void setPassword (String  password){
        this.password=password;
    }
    public  String getPassword(){
        return this.password;
    }
    public void setRealName (String  realName){
        this.realName=realName;
    }
    public  String getRealName(){
        return this.realName;
    }
    public void setBirthday (Date  birthday){
        this.birthday=birthday;
    }
    public  Date getBirthday(){
        return this.birthday;
    }
    public void setAge (Integer  age){
        this.age=age;
    }
    public  Integer getAge(){
        return this.age;
    }
    public void setLinkdPhone (String  linkdPhone){
        this.linkdPhone=linkdPhone;
    }
    public  String getLinkdPhone(){
        return this.linkdPhone;
    }
    public void setEmail (String  email){
        this.email=email;
    }
    public  String getEmail(){
        return this.email;
    }
    public void setIdCard (String  idCard){
        this.idCard=idCard;
    }
    public  String getIdCard(){
        return this.idCard;
    }
    public void setIdCardPositiveUrl (String  idCardPositiveUrl){
        this.idCardPositiveUrl=idCardPositiveUrl;
    }
    public  String getIdCardPositiveUrl(){
        return this.idCardPositiveUrl;
    }
    public void setIdCardBackUrl (String  idCardBackUrl){
        this.idCardBackUrl=idCardBackUrl;
    }
    public  String getIdCardBackUrl(){
        return this.idCardBackUrl;
    }
    public void setBankCard (String  bankCard){
        this.bankCard=bankCard;
    }
    public  String getBankCard(){
        return this.bankCard;
    }
    public void setAvatarUrl (String  avatarUrl){
        this.avatarUrl=avatarUrl;
    }
    public  String getAvatarUrl(){
        return this.avatarUrl;
    }
    public void setExperience (String  experience){
        this.experience=experience;
    }
    public  String getExperience(){
        return this.experience;
    }
    public void setExpertise (String  expertise){
        this.expertise=expertise;
    }
    public  String getExpertise(){
        return this.expertise;
    }
    public void setBackgroundUrl (String  backgroundUrl){
        this.backgroundUrl=backgroundUrl;
    }
    public  String getBackgroundUrl(){
        return this.backgroundUrl;
    }
    public void setProvinceNo (String  provinceNo){
        this.provinceNo=provinceNo;
    }
    public  String getProvinceNo(){
        return this.provinceNo;
    }
    public void setCityNo (String  cityNo){
        this.cityNo=cityNo;
    }
    public  String getCityNo(){
        return this.cityNo;
    }
    public void setAddress (String  address){
        this.address=address;
    }
    public  String getAddress(){
        return this.address;
    }
    public void setLevelId (Long  levelId){
        this.levelId=levelId;
    }
    public  Long getLevelId(){
        return this.levelId;
    }
    public void setHonor (String  honor){
        this.honor=honor;
    }
    public  String getHonor(){
        return this.honor;
    }
    public void setFansCounts (Integer  fansCounts){
        this.fansCounts=fansCounts;
    }
    public  Integer getFansCounts(){
        return this.fansCounts;
    }
    public void setWxid (String  wxid){
        this.wxid=wxid;
    }
    public  String getWxid(){
        return this.wxid;
    }
    public void setQqId (String  qqId){
        this.qqId=qqId;
    }
    public  String getQqId(){
        return this.qqId;
    }
    public void setIsPerfectInformation (Integer  isPerfectInformation){
        this.isPerfectInformation=isPerfectInformation;
    }
    public  Integer getIsPerfectInformation(){
        return this.isPerfectInformation;
    }
    public void setStatus (Integer  status){
        this.status=status;
    }
    public  Integer getStatus(){
        return this.status;
    }
    public void setCreatedTime (Date  createdTime){
        this.createdTime=createdTime;
    }
    public  Date getCreatedTime(){
        return this.createdTime;
    }
    public void setUpdatedTime (Date  updatedTime){
        this.updatedTime=updatedTime;
    }
    public  Date getUpdatedTime(){
        return this.updatedTime;
    }
}
