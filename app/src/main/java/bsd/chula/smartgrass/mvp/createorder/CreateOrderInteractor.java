package bsd.chula.smartgrass.mvp.createorder;

import java.util.Date;

import bsd.chula.smartgrass.api.APIManager;
import bsd.chula.smartgrass.api.APIServices;
import bsd.chula.smartgrass.data.model.Order;

/**
 * Created by Dev_Tee on 3/25/17.
 */

public class CreateOrderInteractor implements CreateOrderContract.Interactor {

    private APIServices apiServices;

    public CreateOrderInteractor() {
        apiServices = APIManager.getService();
    }

    @Override
    public void loadGrass(int id, CreateOrderContract.OnLoadGrassCallback callback) {

    }

    @Override
    public void loadAvailableDate(Date date, CreateOrderContract.OnLoadAvailableDateCallback callback) {

    }

    @Override
    public void postNewOrder(Order order, CreateOrderContract.OnPostNewOrderCallback callback) {

    }
}
