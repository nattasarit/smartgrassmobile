package bsd.chula.smartgrass.data.model;

import com.google.gson.annotations.SerializedName;

public class Work{

	@SerializedName("Email")
	private String email;

	@SerializedName("ArtificialGrassCatagoryName")
	private String artificialGrassCatagoryName;

	@SerializedName("WorkStatusID")
	private String workStatusID;

	@SerializedName("latitude")
	private String latitude;

	@SerializedName("WorkStatusName")
	private String workStatusName;

	@SerializedName("ArtificialGrassCatagoryID")
	private String artificialGrassCatagoryID;

	@SerializedName("Tel")
	private String tel;

	@SerializedName("WorkID")
	private String workID;

	@SerializedName("CustomerID")
	private String customerID;

	@SerializedName("CustomerName")
	private String customerName;

	@SerializedName("longitude")
	private String longitude;

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setArtificialGrassCatagoryName(String artificialGrassCatagoryName){
		this.artificialGrassCatagoryName = artificialGrassCatagoryName;
	}

	public String getArtificialGrassCatagoryName(){
		return artificialGrassCatagoryName;
	}

	public void setWorkStatusID(String workStatusID){
		this.workStatusID = workStatusID;
	}

	public String getWorkStatusID(){
		return workStatusID;
	}

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setWorkStatusName(String workStatusName){
		this.workStatusName = workStatusName;
	}

	public String getWorkStatusName(){
		return workStatusName;
	}

	public void setArtificialGrassCatagoryID(String artificialGrassCatagoryID){
		this.artificialGrassCatagoryID = artificialGrassCatagoryID;
	}

	public String getArtificialGrassCatagoryID(){
		return artificialGrassCatagoryID;
	}

	public void setTel(String tel){
		this.tel = tel;
	}

	public String getTel(){
		return tel;
	}

	public void setWorkID(String workID){
		this.workID = workID;
	}

	public String getWorkID(){
		return workID;
	}

	public void setCustomerID(String customerID){
		this.customerID = customerID;
	}

	public String getCustomerID(){
		return customerID;
	}

	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}

	public String getCustomerName(){
		return customerName;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"Work{" + 
			"email = '" + email + '\'' + 
			",artificialGrassCatagoryName = '" + artificialGrassCatagoryName + '\'' + 
			",workStatusID = '" + workStatusID + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",workStatusName = '" + workStatusName + '\'' + 
			",artificialGrassCatagoryID = '" + artificialGrassCatagoryID + '\'' + 
			",tel = '" + tel + '\'' + 
			",workID = '" + workID + '\'' + 
			",customerID = '" + customerID + '\'' + 
			",customerName = '" + customerName + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}