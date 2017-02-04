package bsd.chula.smartgrass.main;

import android.content.Context;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class MainInteractor implements MainContract.Interactor {

    private Context context;

    public MainInteractor(Context context) {
        this.context = context;
    }

    @Override
    public void getAllTask(MainContract.GetAllTaskListener listener) {

    }

    @Override
    public void getTask(int id, MainContract.GetTaskListener listener) {

    }
}
