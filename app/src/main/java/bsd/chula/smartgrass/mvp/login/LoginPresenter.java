package bsd.chula.smartgrass.mvp.login;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import bsd.chula.smartgrass.data.model.Login;
import bsd.chula.smartgrass.data.model.LoginItem;
import bsd.chula.smartgrass.data.model.Role;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class LoginPresenter implements LoginContract.UserActions {

    private Context context;
    private LoginContract.View view;
    private LoginInteractor interactor;

    public LoginPresenter(Context context, LoginContract.View view) {
        this.context = context;
        this.view = view;

        interactor = new LoginInteractor();
    }

    @Override
    public void login(String username, String password) {

        Login login = new Login();

        LoginItem loginItem = new LoginItem();
        loginItem.setUsername(username);
        loginItem.setPassword(password);

        List<LoginItem> newList = new ArrayList<>();
        newList.add(loginItem);

        login.setLogin(newList);

        interactor.login(login, new LoginContract.LoginListener() {
            @Override
            public void onLoginSuccess(List<Role> roleList) {
                view.showLoginSuccessUI();
            }

            @Override
            public void onLoginError(String msg) {
                view.showLoginError(msg);
            }
        });
    }
}
