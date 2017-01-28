package bsd.chula.smartgrass.main;

import java.util.List;

import bsd.chula.smartgrass.data.task.Task;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public interface MainContract {

    interface View {

        void showAllTasks(List<Task> taskList);

        void showTaskDetailUI(Task task);

    }

    interface UserActions {

        void loadTaskList(List<Task> taskList);

        void loadTask(int id);
    }

    interface Interactor {

        void getAllTask(GetAllTaskListener listener);

        void getTask(int id, GetTaskListener listener);
    }

    interface GetAllTaskListener {

        void onGetAllTaskSuccess(List<Task> taskList);

        void onGetAllTaskError(String msg);
    }

    interface GetTaskListener {

        void onGetTaskSuccess(Task task);

        void onGetTaskError(String msg);
    }
}
