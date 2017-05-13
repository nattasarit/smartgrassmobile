package bsd.chula.smartgrass.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Role{

	@SerializedName("FunctionID")
	private String functionID;

	@SerializedName("RoleName")
	private String roleName;

	@SerializedName("RoleId")
	private String roleId;

	@SerializedName("FuncionName")
	private String funcionName;

	public void setFunctionID(String functionID){
		this.functionID = functionID;
	}

	public String getFunctionID(){
		return functionID;
	}

	public void setRoleName(String roleName){
		this.roleName = roleName;
	}

	public String getRoleName(){
		return roleName;
	}

	public void setRoleId(String roleId){
		this.roleId = roleId;
	}

	public String getRoleId(){
		return roleId;
	}

	public void setFuncionName(String funcionName){
		this.funcionName = funcionName;
	}

	public String getFuncionName(){
		return funcionName;
	}

	@Override
 	public String toString(){
		return 
			"Role{" + 
			"functionID = '" + functionID + '\'' + 
			",roleName = '" + roleName + '\'' + 
			",roleId = '" + roleId + '\'' + 
			",funcionName = '" + funcionName + '\'' + 
			"}";
		}
}