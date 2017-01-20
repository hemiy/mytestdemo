package hemiy.qinghui.com.mytestdemo.retrofitpractice;

/**
 * http://gank.io/post/56e80c2c677659311bed9841
 *
 * Created by hemiy on 16/11/19 16:03.
 *
 * 因为服务器的数据是统一的,只有result的内容是变化的,使用了一个泛型来到代替。
 * 使用retrofit框架会把服务端返回的数据都变成这个下面的这个实体
 *
 */

public class HttpResult<T> {
    private String desc;
    private String code;
    private T result;

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "desc='" + desc + '\'' +
                ", code='" + code + '\'' +
                ", result=" + result +
                '}';
    }

    //注意 返回的的格式
    // 如果result是一个User对象的话,即jsonObject对象。那么在定义Service方法的返回值就可以写为
    // Observable<HttpResult<User>>

    //如果是一个数组,即jsonArray对象
    //Observable<HttpResult<List<User>>>
}
