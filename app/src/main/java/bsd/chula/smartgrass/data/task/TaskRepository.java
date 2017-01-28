package bsd.chula.smartgrass.data.task;

import java.util.List;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public interface TaskRepository {

    void selectAllTasks(SelectAllTasksCallback callback);

    void selectTaskItem(int id, SelectTaskItemCallback callback);

    void updateTaskItem(Task task, UpdateTaskItemCallback callback);

    void deleteTaskItem(DeleteTaskItemCallback callback);

    interface SelectAllTasksCallback {

        void onGetAllTasksSuccess(List<Task> taskList);

        void onGetAllTasksError(String msg);
    }

    interface SelectTaskItemCallback {

        void onGetTaskItemSuccess(Task task);

        void onGetTaskItemError(String msg);
    }

    interface UpdateTaskItemCallback {

        void onUpdateTaskSuccess(Task task);

        void onUpdateTaskError(String msg);
    }

    interface DeleteTaskItemCallback {

        void onDeleteTaskSuccess(String msg);

        void onDeleteTaskError(String msg);
    }

}
