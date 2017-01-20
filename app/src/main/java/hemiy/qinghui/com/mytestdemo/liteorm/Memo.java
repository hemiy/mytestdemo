package hemiy.qinghui.com.mytestdemo.liteorm;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.Default;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

import java.io.Serializable;


/**
 * https://github.com/litesuits/android-lite-orm
 * http://www.cnblogs.com/zhaoyanjun/p/5640788.html
 * 记事本实体
 * @author hemiy
 * 2016-8-26上午10:42:02
 */

@Table("Memo")
public class Memo implements Serializable{

	 @PrimaryKey(AssignType.AUTO_INCREMENT)
	private int id; //必须有 且为int类型
	
	 @Column("content")
	private String content;  //内容
	 
	 @Column("createtime")
	private long createtime; //创建时间
	
	 @Column("name")
	 private String name; //名字
	 
	 
	 //以下3个位新增字段
	 // 默认为true，指定列名
	 //App升级或者Model改变，新加了属性字段，该字段将被探测到并加入数据库中，因此无需担心新字段不被存储。
	 //测试发现默认的字段没有成功，布尔默认为false 字符串默认为null 整型默认为0 price为0.0
	    @Default("true")
	    @Column("isLogin")
	    private Boolean isLogin;
	    
	    @Default("man")
	    @Column("gender")
	    private String gender;
	    
	    @Default("1")
	    @Column("age")
	    private int age;
	    
	    
	    //不写默认default,直接新添加了新字段，long默认为0
	    //总结 默认的字段可以不用写了
	    @Default("234342")
	    @Column("salary")
	    private long salary;
	    
	    
	    
	    
	public long getSalary() {
			return salary;
		}



		public void setSalary(long salary) {
			this.salary = salary;
		}



	public int getId() {
		return id;
	}

	
	
	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public Boolean getIsLogin() {
		return isLogin;
	}



	public void setIsLogin(Boolean isLogin) {
		this.isLogin = isLogin;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getCreatetime() {
		return createtime;
	}

	public void setCreatetime(long createtime) {
		this.createtime = createtime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Memo [id=" + id + ", content=" + content + ", createtime="
				+ createtime + ", name=" + name + ", isLogin=" + isLogin
				+ ", gender=" + gender + ", age=" + age + ", salary=" + salary
				+ "]";
	}






	

	
  

	 
	 
	
}
