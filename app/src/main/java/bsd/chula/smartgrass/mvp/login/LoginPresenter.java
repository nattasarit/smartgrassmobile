package bsd.chula.smartgrass.mvp.login;

import java.util.List;

import bsd.chula.smartgrass.api.model.Role;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class LoginPresenter implements LoginContract.UserActions {

    private LoginContract.View view;
    private LoginInteractor interactor;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;

        interactor = new LoginInteractor();
    }

    @Override
    public void login(String username, String password) {

        interactor.login(username, password, new LoginContract.LoginListener() {
            @Override
            public void onLoginSuccess(List<Role> roleList) {
                view.showLoginSuccessUI(roleList);
            }

            @Override
            public void onLoginError(String msg) {
                view.showLoginError(msg);
            }
        });
    }
}
