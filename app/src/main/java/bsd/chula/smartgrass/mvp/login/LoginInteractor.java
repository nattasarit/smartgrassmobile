package bsd.chula.smartgrass.mvp.login;


import java.util.List;

import bsd.chula.smartgrass.api.APIManager;
import bsd.chula.smartgrass.api.APIServices;
import bsd.chula.smartgrass.api.model.Role;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class LoginInteractor implements LoginContract.Interactor{

    private APIServices apiServices;

    public LoginInteractor() {
        apiServices = APIManager.getService();
    }

    @Override
    public void login(String username, String password, final LoginContract.LoginListener listener) {
        apiServices.getLogin(username, password).enqueue(new Callback<List<Role>>() {
            @Override
            public void onResponse(Call<List<Role>> call, Response<List<Role>> response) {

                if (response.code() == 200) {
                    List<Role> roleList = response.body();
                    listener.onLoginSuccess(roleList);
                } else {
                    listener.onLoginError(response.message());
                }

            }

            @Override
            public void onFailure(Call<List<Role>> call, Throwable t) {
                listener.onLoginError(t.getLocalizedMessage());
            }
        });
    }
}
