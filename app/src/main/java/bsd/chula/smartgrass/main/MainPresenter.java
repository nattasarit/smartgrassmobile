package bsd.chula.smartgrass.main;

import android.content.Context;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bsd.chula.smartgrass.data.task.Task;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class MainPresenter implements MainContract.UserActions {

    private Context context;
    private MainContract.View view;
    private MainInteractor interactor;

    private List<Task> SAMPLE_TASK = new ArrayList<>();

    public MainPresenter(Context context, MainContract.View view) {
        this.context = context;
        this.view = view;

        interactor = new MainInteractor(context);


        for (int i = 0; i < 10; i++) {

            Task newTask = new Task();
            newTask.setId(i);
            newTask.setFirstName("Kittisak " + i);
            newTask.setLastName("Buaphanna " + i);

            Date date = new Date();
            String stringDate = DateFormat.getDateTimeInstance().format(date);

            newTask.setDateTime(stringDate);

            newTask.setDescription("ปูสนามหญ้าหลังบ้าน");
            newTask.setLat(13.805358);
            newTask.setLng(100.575501);

            SAMPLE_TASK.add(newTask);
        }
    }

    @Override
    public void loadTaskList() {

        view.showAllTasks(SAMPLE_TASK);

        interactor.getAllTask(new MainContract.GetAllTaskListener() {
            @Override
            public void onGetAllTaskSuccess(List<Task> taskList) {

                view.showAllTasks(taskList);
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
