package bsd.chula.smartgrass.mvp.login;

import java.util.List;

import bsd.chula.smartgrass.data.model.Login;
import bsd.chula.smartgrass.data.model.LoginItem;
import bsd.chula.smartgrass.data.model.Role;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public interface LoginContract {

    interface View {

        void showLoginSuccessUI();

        void showLoginError(String msg);

    }

    interface UserActions {

        void login(String username, String password);
    }

    interface Interactor {

        void login(Login login, LoginListener listener);
    }

    interface LoginListener {

        void onLoginSuccess(List<Role> roleList);

        void onLoginError(String msg);
    }
}
