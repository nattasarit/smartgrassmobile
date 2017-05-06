package bsd.chula.smartgrass.api.model;

import java.util.List;

/**
 * Created by Dev_Tee on 5/1/17.
 */

public class GetMaxWorkResponse {

    private List<MaxWork> mMaxWorkList;

    public List<MaxWork> getMaxWorkList() {
        return mMaxWorkList;
    }

    public void setMaxWorkList(List<MaxWork> maxWorkList) {
        mMaxWorkList = maxWorkList;
    }
}
