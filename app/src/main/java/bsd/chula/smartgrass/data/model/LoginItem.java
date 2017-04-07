package bsd.chula.smartgrass.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginItem{

	@SerializedName("Username")
	@Expose
	private String username;

	@SerializedName("Password")
	@Expose
	private String password;

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}
}