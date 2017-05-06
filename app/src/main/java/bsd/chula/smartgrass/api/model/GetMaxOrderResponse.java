package bsd.chula.smartgrass.api.model;

import java.util.List;

/**
 * Created by Dev_Tee on 5/6/17.
 */

public class GetMaxOrderResponse {

    private List<MaxOrder> mMaxOrderList;

    public List<MaxOrder> getMaxOrderList() {
        return mMaxOrderList;
    }

    public void setMaxOrderList(List<MaxOrder> maxOrderList) {
        mMaxOrderList = maxOrderList;
    }
}
