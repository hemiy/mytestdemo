package hemiy.qinghui.com.mytestdemo.rxbus;

/**
 * Created by hemiy on 16/9/30 15:43.
 */

public class UserEvent {
    long id;
    String name;
    public UserEvent(long id,String name) {
        this.id= id;
        this.name= name;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
