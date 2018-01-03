package cn.com.pers.model;

/**
 * @author wxp
 * @date 2017年12月8日 下午1:27:32
 * @Description: TODO(mode)
 */
public class Login {
	//自动映射时，需要和数据库字段名相同
	private String user_name;
	private String password;

	public String getUsername() {
		return user_name;
	}

	public void setUsername(String username) {
		this.user_name = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [user_name=" + user_name + ", password=" + password + "]";
	}
}
