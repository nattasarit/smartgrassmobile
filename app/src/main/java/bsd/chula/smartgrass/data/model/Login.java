package bsd.chula.smartgrass.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login{

	@SerializedName("login")
	@Expose
	private List<LoginItem> login;

	public void setLogin(List<LoginItem> login){
		this.login = login;
	}

	public List<LoginItem> getLogin(){
		return login;
	}

	@Override
 	public String toString(){
		return 
			"Login{" + 
			"login = '" + login + '\'' + 
			"}";
		}
}