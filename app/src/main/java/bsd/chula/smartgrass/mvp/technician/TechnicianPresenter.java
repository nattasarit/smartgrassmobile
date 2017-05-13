package bsd.chula.smartgrass.mvp.technician;

import java.util.List;

import bsd.chula.smartgrass.api.APIManager;
import bsd.chula.smartgrass.api.APIServices;
import bsd.chula.smartgrass.api.model.Schedule;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dev_Tee on 5/13/17.
 */

public class TechnicianPresenter implements TechnicianContract.TechnicianPresenter {

    private APIServices mAPIServices;
    private TechnicianContract.TechnicianView mView;

    public TechnicianPresenter(TechnicianContract.TechnicianView view) {
        mView = view;
    }

    @Override
    public void loadScheduleList() {

        mAPIServices = APIManager.getService();

        mAPIServices.getSchedule().enqueue(new Callback<List<Schedule>>() {
            @Override
            public void onResponse(Call<List<Schedule>> call, Response<List<Schedule>> response) {

                List<Schedule> result = response.body();

                if (response.code() == 200) {
                    mView.onShowScheduleList(result);
                } else {
                    mView.onShowErrorDialog(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Schedule>> call, Throwable t) {
                mView.onShowErrorDialog(t.getLocalizedMessage());
            }
        });
    }
}
