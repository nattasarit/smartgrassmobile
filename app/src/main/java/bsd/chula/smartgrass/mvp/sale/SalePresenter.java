package bsd.chula.smartgrass.mvp.sale;

import android.content.Context;

import java.util.List;

import bsd.chula.smartgrass.api.APIManager;
import bsd.chula.smartgrass.api.APIServices;
import bsd.chula.smartgrass.api.model.Work;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dev_Tee on 5/13/17.
 */

public class SalePresenter implements SaleContract.SalePresenter {

    private APIServices mAPIServices;
    private SaleContract.SaleView mView;

    public SalePresenter(SaleContract.SaleView view) {
        mView = view;
    }

    @Override
    public void loadAllTask() {
        mAPIServices = APIManager.getService();

        mAPIServices.getAllWorks().enqueue(new Callback<List<Work>>() {
            @Override
            public void onResponse(Call<List<Work>> call, Response<List<Work>> response) {

                List<Work> result = response.body();

                if (response.code() == 200) {
                    mView.showAllTasks(result);
                } else {
                    mView.showErrorDialog(response.message());
                }

            }

            @Override
            public void onFailure(Call<List<Work>> call, Throwable t) {
                mView.showErrorDialog(t.getLocalizedMessage());
            }
        });
    }
}
