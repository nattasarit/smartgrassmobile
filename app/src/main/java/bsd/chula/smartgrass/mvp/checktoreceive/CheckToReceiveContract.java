package bsd.chula.smartgrass.mvp.checktoreceive;

import bsd.chula.smartgrass.data.model.Order;

/**
 * Created by Dev_Tee on 2/22/17.
 */

public interface CheckToReceiveContract {

    interface View {

        void showOrderDetails(Order order);

        void showErrorDialog(String msg);
    }

    interface UserActions {

        void setOrder(Order order);

        void loadOrder();

        void signContract();
    }

    interface Interactor {

        void getOrderFromAPI(int id, OnGetOrderCallback callback);

        void updateOrderStatus(Order order, OnPutOrderCallback callback);
    }

    interface OnGetOrderCallback {

        void onGetOrderSuccess(Order order);

        void onGetOrderError(String msg);

    }

    interface OnPutOrderCallback {

        void onPutOrderSuccess(Order order);

        void onPutOrderError(String msg);
    }
}
