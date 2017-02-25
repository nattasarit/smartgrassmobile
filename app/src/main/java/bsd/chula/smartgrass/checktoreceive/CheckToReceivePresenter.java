package bsd.chula.smartgrass.checktoreceive;

import android.content.Context;

import bsd.chula.smartgrass.data.model.Order;

/**
 * Created by Dev_Tee on 2/22/17.
 */

public class CheckToReceivePresenter implements CheckToReceiveContract.UserActions {

    private Context context;
    private CheckToReceiveContract.View view;
    private CheckToReceiveInteractor interactor;
    private Order order;

    public CheckToReceivePresenter(Context context, CheckToReceiveContract.View view) {
        this.context = context;
        this.view = view;

        interactor = new CheckToReceiveInteractor(context);
    }

    @Override
    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public void loadOrder() {

        interactor.getOrderFromAPI(order.getId(), new CheckToReceiveContract.OnGetOrderCallback() {
            @Override
            public void onGetOrderSuccess(Order order) {

                view.showOrderDetails(order);

            }

            @Override
            public void onGetOrderError(String msg) {

                view.showErrorDialog(msg);

            }
        });

    }

    @Override
    public void signContract() {

        interactor.updateOrderStatus(order, new CheckToReceiveContract.OnPutOrderCallback() {
            @Override
            public void onPutOrderSuccess(Order order) {

            }

            @Override
            public void onPutOrderError(String msg) {

            }
        });

    }
}
