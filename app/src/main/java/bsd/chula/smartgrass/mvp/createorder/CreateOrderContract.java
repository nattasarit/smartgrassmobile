package bsd.chula.smartgrass.mvp.createorder;

import java.util.Date;

import bsd.chula.smartgrass.data.model.Order;

/**
 * Created by Dev_Tee on 3/25/17.
 */

public interface CreateOrderContract {

    interface View {

        void showGrassList();

        void showCalendar();

    }

    interface UserActions {

        void chooseGrass(int category_id);

        void chooseAppointmentDate(Date requestDate);

        void sendOrder(Order newOrder);
    }

    interface Interactor {

        void loadGrass(int id, OnLoadGrassCallback callback);

        void loadAvailableDate(Date date, OnLoadAvailableDateCallback callback);

        void postNewOrder(Order order, OnPostNewOrderCallback callback);

    }

    interface OnLoadGrassCallback {
        void onLoadGrassSuccess();

        void onLoadGrassError();
    }

    interface OnLoadAvailableDateCallback {

        void onLoadAvailableDateSuccess();

        void onLoadAvailableDateError();
    }

    interface OnPostNewOrderCallback {

        void onPostNewOrderSuccess();

        void onPostNewOrderError();
    }
}
