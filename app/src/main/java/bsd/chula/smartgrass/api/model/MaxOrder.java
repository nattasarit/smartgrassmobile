package bsd.chula.smartgrass.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dev_Tee on 5/6/17.
 */

public class MaxOrder {

    @SerializedName("maxOrderID")
    private int maxOrderID;

    public int getMaxOrderID() {
        return maxOrderID;
    }

    public void setMaxOrderID(int maxOrderID) {
        this.maxOrderID = maxOrderID;
    }
}
