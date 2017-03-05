package bsd.chula.smartgrass.mvp.suggestion;

import android.content.Context;

import java.util.List;

import bsd.chula.smartgrass.data.model.Grass;

/**
 * Created by Dev_Tee on 3/5/17.
 */

public class SuggestionPresenter implements SuggestionContract.UserActions {

    private Context context;
    private SuggestionContract.View view;
    private SuggestionInteractor interactor;

    public SuggestionPresenter(Context context, SuggestionContract.View view) {
        this.context = context;
        this.view = view;

        interactor = new SuggestionInteractor(context);
    }

    @Override
    public void loadAllGrass() {

        interactor.getAllGrass(new SuggestionContract.OnGetAllGrassCallback() {
            @Override
            public void onGetAllGrassSuccess(List<Grass> grassList) {

                view.showGrassList(grassList);
            }

            @Override
            public void onGetAllGrassError(String msg) {

                view.showErrorDialog(msg);
            }
        });
    }

    @Override
    public void loadGrassItem(String id) {

    }
}
