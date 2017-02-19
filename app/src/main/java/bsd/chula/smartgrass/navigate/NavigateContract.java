package bsd.chula.smartgrass.navigate;


/**
 * Created by Dev_Tee on 2/19/17.
 */

public interface NavigateContract {

    interface View {

        void showShowNavigationMap();
    }

    interface UserActions {

        void loadNavigationMap();
    }
}
