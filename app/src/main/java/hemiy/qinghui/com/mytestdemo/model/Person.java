package hemiy.qinghui.com.mytestdemo.model;

import java.io.Serializable;

/**
 * 使用GsonFormat来快速生成一个实体类
 * Created by hemiy on 16/6/10.
 */
public class Person implements Serializable {

    /**
     * createTime : 2016-05-25 13:52:34.0
     * phone : 13631776615
     * communityCity : 广州市
     * avatarId : 34507a44-b0f9-47f2-bdea-6cfbe236d6d2
     * communityPhone1 : 89662899
     * communityPhone2 :
     * type : 2
     * password : e10adc3949ba59abbe56e057f20f883e
     * tenementName : 保利物业
     * id : d5ddfb76-4e69-4fc9-b415-ce73e77e07e6
     * switchCommunityTime : 2016-06-07 09:57:27.0
     * nickName : 21742
     * userId : d5ddfb76-4e69-4fc9-b415-ce73e77e07e6
     * userName :
     * gender : 1
     * profilePhoto : /upload/user/default.png
     * robie : 10
     * iconPhoto :
     * lastestLoginTime : 2016-05-25 13:52:34.0
     * signature :
     * locationPhoto : /upload/null/201604/d8f9f3d9-7c01-41a6-93f8-4d4db3105b8f.png
     * cardinalNum : 102
     * email :
     * mainPhoto : /upload/null/201604/e0aff350-53e1-4fb5-a5ff-b709e90bf439.jpg
     * communityName : 琶洲新村
     * communityAddress : 广州市海珠区新港东路
     * communityId : 51f1c275-b11e-400d-b6c7-e42a474ecac5
     */

    private String createTime;
    private String phone;
    private String communityCity;
    private String avatarId;
    private String communityPhone1;
    private String communityPhone2;
    private String type;
    private String password;
    private String tenementName;
    private String id;
    private String switchCommunityTime;
    private String nickName;
    private String userId;
    private String userName;
    private String gender;
    private String profilePhoto;
    private String robie;
    private String iconPhoto;
    private String lastestLoginTime;
    private String signature;
    private String locationPhoto;
    private String cardinalNum;
    private String email;
    private String mainPhoto;
    private String communityName;
    private String communityAddress;
    private String communityId;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCommunityCity() {
        return communityCity;
    }

    public void setCommunityCity(String communityCity) {
        this.communityCity = communityCity;
    }

    public String getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(String avatarId) {
        this.avatarId = avatarId;
    }

    public String getCommunityPhone1() {
        return communityPhone1;
    }

    public void setCommunityPhone1(String communityPhone1) {
        this.communityPhone1 = communityPhone1;
    }

    public String getCommunityPhone2() {
        return communityPhone2;
    }

    public void setCommunityPhone2(String communityPhone2) {
        this.communityPhone2 = communityPhone2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTenementName() {
        return tenementName;
    }

    public void setTenementName(String tenementName) {
        this.tenementName = tenementName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSwitchCommunityTime() {
        return switchCommunityTime;
    }

    public void setSwitchCommunityTime(String switchCommunityTime) {
        this.switchCommunityTime = switchCommunityTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getRobie() {
        return robie;
    }

    public void setRobie(String robie) {
        this.robie = robie;
    }

    public String getIconPhoto() {
        return iconPhoto;
    }

    public void setIconPhoto(String iconPhoto) {
        this.iconPhoto = iconPhoto;
    }

    public String getLastestLoginTime() {
        return lastestLoginTime;
    }

    public void setLastestLoginTime(String lastestLoginTime) {
        this.lastestLoginTime = lastestLoginTime;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getLocationPhoto() {
        return locationPhoto;
    }

    public void setLocationPhoto(String locationPhoto) {
        this.locationPhoto = locationPhoto;
    }

    public String getCardinalNum() {
        return cardinalNum;
    }

    public void setCardinalNum(String cardinalNum) {
        this.cardinalNum = cardinalNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityAddress() {
        return communityAddress;
    }

    public void setCommunityAddress(String communityAddress) {
        this.communityAddress = communityAddress;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    //自定义创建实体
    public Person() {
    }

    //带3个参数的实体
    public Person(String createTime, String phone, String communityCity) {
        this.createTime = createTime;
        this.phone = phone;
        this.communityCity = communityCity;
    }
}
