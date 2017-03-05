package bsd.chula.smartgrass.data.model;

import com.google.gson.annotations.SerializedName;

public class Grass{

	@SerializedName("Path")
	private Object path;

	@SerializedName("PileDenie")
	private String pileDenie;

	@SerializedName("ArtificialGrassRollLength")
	private String artificialGrassRollLength;

	@SerializedName("Color")
	private String color;

	@SerializedName("ArtificialGrassCatagoryID")
	private String artificialGrassCatagoryID;

	@SerializedName("ArtificialGrassWidth")
	private String artificialGrassWidth;

	@SerializedName("SitchRate")
	private String sitchRate;

	@SerializedName("Backing")
	private String backing;

	@SerializedName("ArtificialGrassName")
	private String artificialGrassName;

	@SerializedName("ArtificialGrassID")
	private String artificialGrassID;

	@SerializedName("PileHeight")
	private String pileHeight;

	@SerializedName("Gauge")
	private Object gauge;

	public void setPath(Object path){
		this.path = path;
	}

	public Object getPath(){
		return path;
	}

	public void setPileDenie(String pileDenie){
		this.pileDenie = pileDenie;
	}

	public String getPileDenie(){
		return pileDenie;
	}

	public void setArtificialGrassRollLength(String artificialGrassRollLength){
		this.artificialGrassRollLength = artificialGrassRollLength;
	}

	public String getArtificialGrassRollLength(){
		return artificialGrassRollLength;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
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

	public void setSitchRate(String sitchRate){
		this.sitchRate = sitchRate;
	}

	public String getSitchRate(){
		return sitchRate;
	}

	public void setBacking(String backing){
		this.backing = backing;
	}

	public String getBacking(){
		return backing;
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

	public void setGauge(Object gauge){
		this.gauge = gauge;
	}

	public Object getGauge(){
		return gauge;
	}

	@Override
 	public String toString(){
		return 
			"Grass{" + 
			"path = '" + path + '\'' + 
			",pileDenie = '" + pileDenie + '\'' + 
			",artificialGrassRollLength = '" + artificialGrassRollLength + '\'' + 
			",color = '" + color + '\'' + 
			",artificialGrassCatagoryID = '" + artificialGrassCatagoryID + '\'' + 
			",artificialGrassWidth = '" + artificialGrassWidth + '\'' + 
			",sitchRate = '" + sitchRate + '\'' + 
			",backing = '" + backing + '\'' + 
			",artificialGrassName = '" + artificialGrassName + '\'' + 
			",artificialGrassID = '" + artificialGrassID + '\'' + 
			",pileHeight = '" + pileHeight + '\'' + 
			",gauge = '" + gauge + '\'' + 
			"}";
		}
}