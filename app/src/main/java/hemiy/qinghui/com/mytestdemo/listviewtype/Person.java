package hemiy.qinghui.com.mytestdemo.listviewtype;

/**
 * Created by hemiy on 16/10/19 10:06.
 */

public class Person {
    private String name;

    private int type; //根据type值设置头部 注意是省人大的项目用到了

    public Person() {
    }

    public Person(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
