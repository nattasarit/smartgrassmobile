package bsd.chula.smartgrass.mvp.suggestion;

import android.content.Context;

import java.util.List;

import bsd.chula.smartgrass.api.APIManager;
import bsd.chula.smartgrass.api.APIServices;
import bsd.chula.smartgrass.api.model.Grass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dev_Tee on 3/5/17.
 */

public class SuggestionInteractor implements SuggestionContract.Interactor {

    private Context context;
    private APIServices apiServices;

    public SuggestionInteractor(Context context) {
        this.context = context;

        apiServices = APIManager.getService();
    }

    @Override
    public void getAllGrass(final SuggestionContract.OnGetAllGrassCallback callback) {

        apiServices.getAllGrass().enqueue(new Callback<List<Grass>>() {
            @Override
            public void onResponse(Call<List<Grass>> call, Response<List<Grass>> response) {

                List<Grass> result = response.body();

                if (response.code() == 200) {
                    callback.onGetAllGrassSuccess(result);
                } else {
                    callback.onGetAllGrassError(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Grass>> call, Throwable t) {

                callback.onGetAllGrassError(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void getGrass(SuggestionContract.OnGetGrassItemCallback callback) {

    }
}
