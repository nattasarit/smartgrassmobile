package bsd.chula.smartgrass.checktoreceive;

import android.content.Context;

import bsd.chula.smartgrass.data.model.Order;

/**
 * Created by Dev_Tee on 2/22/17.
 */

public class CheckToReceiveInteractor implements CheckToReceiveContract.Interactor {

    private Context context;

    public CheckToReceiveInteractor(Context context) {
        this.context = context;
    }

    @Override
    public void getOrderFromAPI(int id, CheckToReceiveContract.OnGetOrderCallback callback) {

    }

    @Override
    public void updateOrderStatus(Order order, CheckToReceiveContract.OnPutOrderCallback callback) {

    }
}
