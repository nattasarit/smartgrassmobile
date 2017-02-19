package bsd.chula.smartgrass.navigate;

import android.content.Context;
import android.location.Location;

/**
 * Created by Dev_Tee on 2/19/17.
 */

public class NavigatePresenter implements NavigateContract.UserActions {

    private NavigateContract.View view;
    private Location destinationLocation;

    public NavigatePresenter(NavigateContract.View view, Location destinationLocation) {
        this.view = view;
        this.destinationLocation = destinationLocation;
    }

    @Override
    public void loadNavigationMap() {

        view.showShowNavigationMap();
    }
}
