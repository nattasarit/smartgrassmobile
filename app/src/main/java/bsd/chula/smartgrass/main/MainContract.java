package bsd.chula.smartgrass.main;

import java.util.List;

import bsd.chula.smartgrass.data.model.Order;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public interface MainContract {

    interface View {

        void showAllTasks(List<Order> orderList);

        void showErrorDialog(String msg);

        void showTaskDetailUI(Order order);

    }

    interface UserActions {

        void loadTaskList();

        void loadTask(int id);
    }

    interface Interactor {

        void getAllTask(GetAllTaskListener listener);

        void getTask(int id, GetTaskListener listener);
    }

    interface GetAllTaskListener {

        void onGetAllTaskSuccess(List<Order> orderList);

        void onGetAllTaskError(String msg);
    }

    interface GetTaskListener {

        void onGetTaskSuccess(Order order);

        void onGetTaskError(String msg);
    }
}
