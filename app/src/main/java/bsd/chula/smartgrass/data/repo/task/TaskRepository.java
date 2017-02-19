package bsd.chula.smartgrass.data.repo.task;

import java.util.List;

import bsd.chula.smartgrass.data.model.Order;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public interface TaskRepository {

    void selectAllTasks(SelectAllTasksCallback callback);

    void selectTaskItem(int id, SelectTaskItemCallback callback);

    void updateTaskItem(Order order, UpdateTaskItemCallback callback);

    void deleteTaskItem(DeleteTaskItemCallback callback);

    interface SelectAllTasksCallback {

        void onGetAllTasksSuccess(List<Order> orderList);

        void onGetAllTasksError(String msg);
    }

    interface SelectTaskItemCallback {

        void onGetTaskItemSuccess(Order order);

        void onGetTaskItemError(String msg);
    }

    interface UpdateTaskItemCallback {

        void onUpdateTaskSuccess(Order order);

        void onUpdateTaskError(String msg);
    }

    interface DeleteTaskItemCallback {

        void onDeleteTaskSuccess(String msg);

        void onDeleteTaskError(String msg);
    }

}
