package bsd.chula.smartgrass.mvp.task;

import java.util.List;

import bsd.chula.smartgrass.api.model.Work;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public interface TaskContract {

    interface View {

        void showAllTasks(List<Work> workList);

        void showErrorDialog(String msg);

        void showTaskDetailUI(Work work);

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

        void onGetAllTaskSuccess(List<Work> workList);

        void onGetAllTaskError(String msg);
    }

    interface GetTaskListener {

        void onGetTaskSuccess(Work work);

        void onGetTaskError(String msg);
    }
}
