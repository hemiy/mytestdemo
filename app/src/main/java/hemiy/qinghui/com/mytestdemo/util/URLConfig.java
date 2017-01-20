package hemiy.qinghui.com.mytestdemo.util;

/**
 * 网络接口地址配置
 */
public interface URLConfig {
    /**
     * 公司部署测试服务器地址
     */
    String SERVER_HOST = "http://rbl.52rbl.com:8080/poli/";   //如果是使用了retrofit必须要在网址最后添加一个/作为结束标记
                                                            //否则会报错
    /**
     * 密码登录
     */
    String ACTION_LOGIN_NORMAL = "/mobile/user/loginForPassword.remote";
    /**
     * 上传头像
     */
    String ACTION_UPLOAD_IMG = "/mobile/user/uploadImg.remote";
    /**
     * 分页查询所有帖子列表
     */
    String ACTION_QUERY_ALL_POST = "/mobile/square/queryAllPost.remote";


    //登录接口 返回一个实体
    String ACTION_LOGIN_POST = "mobile/user/loginForPassword.remote";


    //订单列表 返回的是一个对象
    String ACTION_ORDER_LIST = "mobile/order/queryOrder.remote";




}
