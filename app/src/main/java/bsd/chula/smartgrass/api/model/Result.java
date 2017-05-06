package bsd.chula.smartgrass.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dev_Tee on 5/1/17.
 */

public class Result {

    @SerializedName("result")
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
