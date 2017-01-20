package hemiy.qinghui.com.mytestdemo.retrofitpractice.progress;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hemiy on 16/11/19 21:18.
 */

public class Order implements Serializable {

//使用GsonFormat插件时,吧[]里面的内容都复制进来,包括[]这2个符号

    /**
     * createTime : 2016-06-21 16:31:12.0
     * consigneeName : 21
     * phone : 13631776615
     * orderCode : PO1606211631000001
     * status : 7
     * timeNote : null
     * payTime : null
     * id : 4d482fdd-b9b7-4e46-8746-1edd8cc1a222
     * deliveryTime : null
     * items : [{"amount":1,"subTitle":"自然好奶，只为点滴幸福","price":1.8,"merchandiseName":"蒙牛 蓝莓味酸酸乳 250ml","merchandiseId":"fe933e67-13a9-40cc-947b-a75958da76e1","storeId":"339bcd01-74ad-4582-bc6f-7cd35de3f077","orderId":"4d482fdd-b9b7-4e46-8746-1edd8cc1a222"}]
     * address : 12
     * totalAmount : 1
     * iconPhoto : /upload/merchandise/0028/1.jpg
     * delivery : null
     * totalPrice : 1.8
     */

    private String createTime;
    private String consigneeName;
    private String phone;
    private String orderCode;
    private int status;
    private Object timeNote;
    private Object payTime;
    private String id;
    private Object deliveryTime;
    private String address;
    private int totalAmount;
    private String iconPhoto;
    private Object delivery;
    private double totalPrice;
    /**
     * amount : 1
     * subTitle : 自然好奶，只为点滴幸福
     * price : 1.8
     * merchandiseName : 蒙牛 蓝莓味酸酸乳 250ml
     * merchandiseId : fe933e67-13a9-40cc-947b-a75958da76e1
     * storeId : 339bcd01-74ad-4582-bc6f-7cd35de3f077
     * orderId : 4d482fdd-b9b7-4e46-8746-1edd8cc1a222
     */

    private List<ItemsBean> items;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getTimeNote() {
        return timeNote;
    }

    public void setTimeNote(Object timeNote) {
        this.timeNote = timeNote;
    }

    public Object getPayTime() {
        return payTime;
    }

    public void setPayTime(Object payTime) {
        this.payTime = payTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Object deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getIconPhoto() {
        return iconPhoto;
    }

    public void setIconPhoto(String iconPhoto) {
        this.iconPhoto = iconPhoto;
    }

    public Object getDelivery() {
        return delivery;
    }

    public void setDelivery(Object delivery) {
        this.delivery = delivery;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        private int amount;
        private String subTitle;
        private double price;
        private String merchandiseName;
        private String merchandiseId;
        private String storeId;
        private String orderId;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getMerchandiseName() {
            return merchandiseName;
        }

        public void setMerchandiseName(String merchandiseName) {
            this.merchandiseName = merchandiseName;
        }

        public String getMerchandiseId() {
            return merchandiseId;
        }

        public void setMerchandiseId(String merchandiseId) {
            this.merchandiseId = merchandiseId;
        }

        public String getStoreId() {
            return storeId;
        }

        public void setStoreId(String storeId) {
            this.storeId = storeId;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        @Override
        public String toString() {
            return "ItemsBean{" +
                    "amount=" + amount +
                    ", subTitle='" + subTitle + '\'' +
                    ", price=" + price +
                    ", merchandiseName='" + merchandiseName + '\'' +
                    ", merchandiseId='" + merchandiseId + '\'' +
                    ", storeId='" + storeId + '\'' +
                    ", orderId='" + orderId + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "createTime='" + createTime + '\'' +
                ", consigneeName='" + consigneeName + '\'' +
                ", phone='" + phone + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", status=" + status +
                ", timeNote=" + timeNote +
                ", payTime=" + payTime +
                ", id='" + id + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", address='" + address + '\'' +
                ", totalAmount=" + totalAmount +
                ", iconPhoto='" + iconPhoto + '\'' +
                ", delivery=" + delivery +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }
}
