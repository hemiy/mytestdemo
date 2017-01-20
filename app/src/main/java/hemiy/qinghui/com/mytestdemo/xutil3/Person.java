package hemiy.qinghui.com.mytestdemo.xutil3;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 *
 * http://blog.csdn.net/a1002450926/article/details/50364196
 * Created by hemiy on 16/6/26.
 */
@Table(name="person")
public class Person {


//    1.在类名上面加入@Table标签，标签里面的属性name的值就是以后生成的数据库的表的名字
//    2.实体bean里面的属性需要加上@Column标签，这样这个标签的name属性的值会对应数据库里面的表的字段。
//    3.实体bean里面的普通属性，如果没有加上@Column标签就不会在生成表的时候在表里面加入字段。
//    4.实体bean中必须有一个主键，如果没有主键，表以后不会创建成功，@Column(name=”id”,isId=true,autoGen=true)这个属性name的值代表的是表的主键的标识，isId这个属性代表的是该属性是不是表的主键，autoGen代表的是主键是否是自增长，如果不写autoGen这个属性，默认是自增长的属性。
//



    @Column(name="id",isId=true,autoGen=true)
    private int id;
    //姓名
    @Column(name="name")
    private String name;

    //年龄
    @Column(name="age")
    private int age;

    //性别
    @Column(name="sex")
    private String sex;

    //工资
    @Column(name="salary")
    private String salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PersonTable [id=" + id + ", name=" + name + ", age=" + age
                + ", sex=" + sex + ", salary=" + salary + "]";
    }
}