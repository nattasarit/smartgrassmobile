package bsd.chula.smartgrass.api.model;

import com.google.gson.annotations.SerializedName;

public class Grass{

	@SerializedName("Path")
	private String path;

	@SerializedName("Color")
	private String color;

	@SerializedName("GrassPriceID")
	private String grassPriceID;

	@SerializedName("EditDate")
	private String editDate;

	@SerializedName("Unit")
	private String unit;

	@SerializedName("SitchRate")
	private String sitchRate;

	@SerializedName("EndDate")
	private String endDate;

	@SerializedName("ArtificialGrassName")
	private String artificialGrassName;

	@SerializedName("ArtificialGrassID")
	private String artificialGrassID;

	@SerializedName("PileHeight")
	private String pileHeight;

	@SerializedName("Gauge")
	private String gauge;

	@SerializedName("StartDate")
	private String startDate;

	@SerializedName("PileDenie")
	private String pileDenie;

	@SerializedName("ArtificialGrassRollLength")
	private String artificialGrassRollLength;

	@SerializedName("ArtificialGrassCatagoryName")
	private String artificialGrassCatagoryName;

	@SerializedName("Price")
	private String price;

	@SerializedName("ArtificialGrassCatagoryID")
	private String artificialGrassCatagoryID;

	@SerializedName("ArtificialGrassWidth")
	private String artificialGrassWidth;

	@SerializedName("Backing")
	private String backing;

	public void setPath(String path){
		this.path = path;
	}

	public String getPath(){
		return path;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setGrassPriceID(String grassPriceID){
		this.grassPriceID = grassPriceID;
	}

	public String getGrassPriceID(){
		return grassPriceID;
	}

	public void setEditDate(String editDate){
		this.editDate = editDate;
	}

	public String getEditDate(){
		return editDate;
	}

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	public void setSitchRate(String sitchRate){
		this.sitchRate = sitchRate;
	}

	public String getSitchRate(){
		return sitchRate;
	}

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setArtificialGrassName(String artificialGrassName){
		this.artificialGrassName = artificialGrassName;
	}

	public String getArtificialGrassName(){
		return artificialGrassName;
	}

	public void setArtificialGrassID(String artificialGrassID){
		this.artificialGrassID = artificialGrassID;
	}

	public String getArtificialGrassID(){
		return artificialGrassID;
	}

	public void setPileHeight(String pileHeight){
		this.pileHeight = pileHeight;
	}

	public String getPileHeight(){
		return pileHeight;
	}

	public void setGauge(String gauge){
		this.gauge = gauge;
	}

	public String getGauge(){
		return gauge;
	}

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public String getStartDate(){
		return startDate;
	}

	public String getPileDenie() {
		return pileDenie;
	}

	public void setPileDenie(String pileDenie) {
		this.pileDenie = pileDenie;
	}

	public void setArtificialGrassRollLength(String artificialGrassRollLength){
		this.artificialGrassRollLength = artificialGrassRollLength;
	}

	public String getArtificialGrassRollLength(){
		return artificialGrassRollLength;
	}

	public void setArtificialGrassCatagoryName(String artificialGrassCatagoryName){
		this.artificialGrassCatagoryName = artificialGrassCatagoryName;
	}

	public String getArtificialGrassCatagoryName(){
		return artificialGrassCatagoryName;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setArtificialGrassCatagoryID(String artificialGrassCatagoryID){
		this.artificialGrassCatagoryID = artificialGrassCatagoryID;
	}

	public String getArtificialGrassCatagoryID(){
		return artificialGrassCatagoryID;
	}

	public void setArtificialGrassWidth(String artificialGrassWidth){
		this.artificialGrassWidth = artificialGrassWidth;
	}

	public String getArtificialGrassWidth(){
		return artificialGrassWidth;
	}

	public void setBacking(String backing){
		this.backing = backing;
	}

	public String getBacking(){
		return backing;
	}
}