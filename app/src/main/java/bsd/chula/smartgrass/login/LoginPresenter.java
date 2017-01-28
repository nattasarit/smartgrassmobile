package bsd.chula.smartgrass.login;

import android.content.Context;

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

        interactor = new LoginInteractor(context);
    }

    @Override
    public void login(String username, String password) {

        interactor.login(username, password, new LoginContract.LoginListener() {
            @Override
            public void onLoginSuccess() {
                view.showLoginSuccessUI();
            }

            @Override
            public void onLoginError(String msg) {
                view.showLoginError(msg);
            }
        });
    }
}
