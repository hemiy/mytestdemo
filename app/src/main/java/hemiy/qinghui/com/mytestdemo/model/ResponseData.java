package hemiy.qinghui.com.mytestdemo.model;

import com.google.gson.JsonElement;

/**
 * 服务端返回数据 { "result": {}, "desc": "请求成功!", "code": "1" }
 */
public class ResponseData {

	private String desc;
	private String code;
	private JsonElement result;

	@Override
	public String toString() {
		return "ResponseData [desc=" + desc + ", code=" + code + ", result="
				+ result + "]";
	}

	public JsonElement getResult() {
		return result;
	}

	public void setResult(JsonElement result) {
		this.result = result;
	}

	public boolean check() {
		return "1".equals(code);
	}

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

	

	
}
