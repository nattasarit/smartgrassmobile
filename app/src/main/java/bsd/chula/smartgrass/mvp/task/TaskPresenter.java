package bsd.chula.smartgrass.mvp.task;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import bsd.chula.smartgrass.data.model.Customer;
import bsd.chula.smartgrass.data.model.Order;
import bsd.chula.smartgrass.data.model.Status;
import bsd.chula.smartgrass.data.model.Work;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class TaskPresenter implements TaskContract.UserActions {

    private TaskContract.View view;
    private TaskInteractor interactor;

    public TaskPresenter(Context context, TaskContract.View view) {
        this.view = view;

        interactor = new TaskInteractor(context);
    }

    @Override
    public void loadTaskList() {

        interactor.getAllTask(new TaskContract.GetAllTaskListener() {
            @Override
            public void onGetAllTaskSuccess(List<Work> workList) {
                view.showAllTasks(workList);
            }

            @Override
            public void onGetAllTaskError(String msg) {
                view.showErrorDialog(msg);
            }
        });
    }

    @Override
    public void loadTask(int id) {

    }
}
