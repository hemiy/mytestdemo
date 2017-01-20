package hemiy.qinghui.com.mytestdemo.model;

/**
 * Created by hemiy on 16/7/1.
 */
public class Person2 {


    /**
     * createTime : 2016-03-03 18:58:14.0
     * phone : 18617369765
     * locationPhoto : /upload/201602/eda41d92-6049-48e4-9e27-53f1e057b070.png
     * cardinalNum :
     * communityCity : 广州市
     * avatarId : 525c45f3-82d3-4120-824e-1f7507284644
     * type : 2
     * password : e10adc3949ba59abbe56e057f20f883e
     * id : 771f4973-4ba4-47d7-96b9-2b6836679c43
     * switchCommunityTime :
     * nickName : 如我
     * mainPhoto : 0
     * email :
     * userName :
     * gender : 1
     * communityName : 名称社区
     * profilePhoto :
     * robie : 0
     * iconPhoto :
     * lastestLoginTime : 2016-03-03 18:58:14.0
     * signature :
     * communityAddress : 就
     * communityId : c206c99a-dc38-11e5-ac22-00163e002c89
     */

    private ResultBean result;
    /**
     * result : {"createTime":"2016-03-03 18:58:14.0","phone":"18617369765","locationPhoto":"/upload/201602/eda41d92-6049-48e4-9e27-53f1e057b070.png","cardinalNum":"","communityCity":"广州市","avatarId":"525c45f3-82d3-4120-824e-1f7507284644","type":"2","password":"e10adc3949ba59abbe56e057f20f883e","id":"771f4973-4ba4-47d7-96b9-2b6836679c43","switchCommunityTime":"","nickName":"如我","mainPhoto":"0","email":"","userName":"","gender":"1","communityName":"名称社区","profilePhoto":"","robie":"0","iconPhoto":"","lastestLoginTime":"2016-03-03 18:58:14.0","signature":"","communityAddress":"就","communityId":"c206c99a-dc38-11e5-ac22-00163e002c89"}
     * desc : 请求成功!
     * code : 1
     */

    private String desc;
    private String code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class ResultBean {
        private String createTime;
        private String phone;
        private String locationPhoto;
        private String cardinalNum;
        private String communityCity;
        private String avatarId;
        private String type;
        private String password;
        private String id;
        private String switchCommunityTime;
        private String nickName;
        private String mainPhoto;
        private String email;
        private String userName;
        private String gender;
        private String communityName;
        private String profilePhoto;
        private String robie;
        private String iconPhoto;
        private String lastestLoginTime;
        private String signature;
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

        public String getMainPhoto() {
            return mainPhoto;
        }

        public void setMainPhoto(String mainPhoto) {
            this.mainPhoto = mainPhoto;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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

        public String getCommunityName() {
            return communityName;
        }

        public void setCommunityName(String communityName) {
            this.communityName = communityName;
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
    }

    @Override
    public String toString() {
        return "Person2{" +
                "result=" + result +
                ", desc='" + desc + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public Person2() {
    }

    public Person2(ResultBean result, String desc, String code) {
        this.result = result;
        this.desc = desc;
        this.code = code;
    }
}
