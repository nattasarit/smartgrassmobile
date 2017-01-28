package bsd.chula.smartgrass.login;

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

        void login(String username, String password, LoginListener listener);
    }

    interface LoginListener {

        void onLoginSuccess();

        void onLoginError(String msg);
    }
}
