package bsd.chula.smartgrass.api.model;

import com.google.gson.annotations.SerializedName;

public class Material{

	@SerializedName("StartDate")
	private String startDate;

	@SerializedName("Price")
	private String price;

	@SerializedName("MaterialD")
	private String materialD;

	@SerializedName("EditDate")
	private String editDate;

	@SerializedName("MaterialSize")
	private String materialSize;

	@SerializedName("MaterialName")
	private String materialName;

	@SerializedName("Unit")
	private String unit;

	@SerializedName("EndDate")
	private String endDate;

	@SerializedName("MaterialPriceID")
	private String materialPriceID;

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public String getStartDate(){
		return startDate;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setMaterialD(String materialD){
		this.materialD = materialD;
	}

	public String getMaterialD(){
		return materialD;
	}

	public void setEditDate(String editDate){
		this.editDate = editDate;
	}

	public String getEditDate(){
		return editDate;
	}

	public void setMaterialSize(String materialSize){
		this.materialSize = materialSize;
	}

	public String getMaterialSize(){
		return materialSize;
	}

	public void setMaterialName(String materialName){
		this.materialName = materialName;
	}

	public String getMaterialName(){
		return materialName;
	}

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setMaterialPriceID(String materialPriceID){
		this.materialPriceID = materialPriceID;
	}

	public String getMaterialPriceID(){
		return materialPriceID;
	}
}