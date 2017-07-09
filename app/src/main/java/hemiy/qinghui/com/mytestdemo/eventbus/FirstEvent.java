package hemiy.qinghui.com.mytestdemo.eventbus;

public class FirstEvent {

    //
    private String mMsg;//消息内容
//
    private String tag; //消息类型

    public FirstEvent(String mMsg, String tag) {
        super();

        this.mMsg = mMsg;
        this.tag = tag;
    }

    public String getTag()


    {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public FirstEvent(String msg) {
        //构造函数
        mMsg = msg;
    }

    public String getMsg() {
        return mMsg;
    }
}
