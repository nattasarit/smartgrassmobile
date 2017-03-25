package bsd.chula.smartgrass.mvp.createorder;

import java.util.Date;

import bsd.chula.smartgrass.data.model.Order;

/**
 * Created by Dev_Tee on 3/25/17.
 */

public class CreateOrderPresenter implements CreateOrderContract.UserActions {

    private CreateOrderContract.View view;
    private CreateOrderInteractor interactor;

    public CreateOrderPresenter(CreateOrderContract.View view) {
        this.view = view;
        this.interactor = new CreateOrderInteractor();
    }

    @Override
    public void chooseGrass(int category_id) {

    }

    @Override
    public void chooseAppointmentDate(Date requestDate) {

    }

    @Override
    public void sendOrder(Order newOrder) {

    }
}
