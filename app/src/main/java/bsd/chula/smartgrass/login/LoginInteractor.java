package bsd.chula.smartgrass.login;

import android.content.Context;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class LoginInteractor implements LoginContract.Interactor{

    private Context context;

    public LoginInteractor(Context context) {
        this.context = context;
    }

    @Override
    public void login(String username, String password, LoginContract.LoginListener listener) {

        //ทดสอบ

//        if (username.contentEquals("Kittisak") && password.contentEquals("password1")) {
//            listener.onLoginSuccess();
//        } else {
//            listener.onLoginError("Your Username & Password NOT Correct!");
//        }
        listener.onLoginSuccess();

    }
}
