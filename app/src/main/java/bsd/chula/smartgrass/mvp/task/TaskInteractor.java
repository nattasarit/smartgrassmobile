package bsd.chula.smartgrass.mvp.task;

import android.content.Context;

import java.util.List;

import bsd.chula.smartgrass.api.APIManager;
import bsd.chula.smartgrass.api.APIServices;
import bsd.chula.smartgrass.api.model.Work;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class TaskInteractor implements TaskContract.Interactor {

    private Context context;
    private APIServices apiServices;

    public TaskInteractor(Context context) {
        this.context = context;

        apiServices = APIManager.getService();
    }

    @Override
    public void getAllTask(final TaskContract.GetAllTaskListener listener) {

        apiServices.getAllWorks().enqueue(new Callback<List<Work>>() {
            @Override
            public void onResponse(Call<List<Work>> call, Response<List<Work>> response) {

                List<Work> result = response.body();

                if (response.code() == 200) {
                    listener.onGetAllTaskSuccess(result);
                } else {
                    listener.onGetAllTaskError(response.message());
                }

            }

            @Override
            public void onFailure(Call<List<Work>> call, Throwable t) {

                listener.onGetAllTaskError(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void getTask(int id, TaskContract.GetTaskListener listener) {

    }
}
