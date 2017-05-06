package bsd.chula.smartgrass.mvp.suggestion;

import java.util.List;

import bsd.chula.smartgrass.api.model.Grass;

/**
 * Created by Dev_Tee on 3/5/17.
 */

public interface SuggestionContract {

    interface View {

        void showGrassList(List<Grass> grassList);

        void showErrorDialog(String msg);
    }

    interface UserActions {

        void loadAllGrass();

        void loadGrassItem(String id);
    }

    interface Interactor {

        void getAllGrass(OnGetAllGrassCallback callback);

        void getGrass(OnGetGrassItemCallback callback);
    }

    interface OnGetAllGrassCallback {

        void onGetAllGrassSuccess(List<Grass> grassList);

        void onGetAllGrassError(String msg);
    }

    interface OnGetGrassItemCallback {

        void onGetGrassItemSuccess(Grass grass);

        void onGetGrassItemError(String msg);
    }
}
