package hemiy.qinghui.com.mytestdemo.liteorm;

import java.io.Serializable;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.Default;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * @author hemiy 2016-9-26上午9:48:59
 */
@Table("Person")
public class Person implements Serializable {

	@PrimaryKey(AssignType.AUTO_INCREMENT)
	private int id;

	@Column("name")
	private String name;

	// 实际证明，这个默认字段不起作用，Stirng 字符串默认为null
	@Default("男")
	@Column("gender")
	private String gender;

	// 添加float 没有问题
	@Column("price")
	private float price;

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", price=" + price + "]";
	}

}
