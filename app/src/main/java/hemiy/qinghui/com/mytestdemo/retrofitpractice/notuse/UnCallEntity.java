package hemiy.qinghui.com.mytestdemo.retrofitpractice.notuse;

import java.io.Serializable;

/**
 * Created by hemiy on 16/11/22 15:30.
 */

public class UnCallEntity implements Serializable {


    /**
     * id : 824290c4-e781-4e20-b08b-91c1976c2601
     * personName : 张三
     * username : zhangsan
     * headPic : headPic
     * address : 员村
     * longitude : 32.42
     * latitude : 231.22
     * createTime : 2016-11-15 12:12:12
     * collTime : 60
     * reasonDesc : 无人接听
     */

    private String id;
    private String personName;
    private String username;
    private String headPic;
    private String address;
    private String longitude;
    private String latitude;
    private String createTime;
    private String collTime;
    private String reasonDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCollTime() {
        return collTime;
    }

    public void setCollTime(String collTime) {
        this.collTime = collTime;
    }

    public String getReasonDesc() {
        return reasonDesc;
    }

    public void setReasonDesc(String reasonDesc) {
        this.reasonDesc = reasonDesc;
    }


}

