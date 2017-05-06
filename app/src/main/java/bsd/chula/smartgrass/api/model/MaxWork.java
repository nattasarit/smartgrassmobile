package bsd.chula.smartgrass.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dev_Tee on 5/1/17.
 */

public class MaxWork {

    @SerializedName("maxWorkID")
    private int maxWorkID;

    public int getMaxWorkID() {
        return maxWorkID;
    }

    public void setMaxWorkID(int maxWorkID) {
        this.maxWorkID = maxWorkID;
    }
}
