package bsd.chula.smartgrass.mvp.task;

import android.content.Context;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class TaskInteractor implements TaskContract.Interactor {

    private Context context;

    public TaskInteractor(Context context) {
        this.context = context;
    }

    @Override
    public void getAllTask(TaskContract.GetAllTaskListener listener) {

    }

    @Override
    public void getTask(int id, TaskContract.GetTaskListener listener) {

    }
}
