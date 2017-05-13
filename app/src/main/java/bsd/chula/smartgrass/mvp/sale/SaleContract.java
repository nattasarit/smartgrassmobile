package bsd.chula.smartgrass.mvp.sale;

import java.util.List;

import bsd.chula.smartgrass.api.model.Work;

/**
 * Created by Dev_Tee on 5/13/17.
 */

public interface SaleContract {

    interface SaleView {
        void showAllTasks(List<Work> workList);
        void showErrorDialog(String msg);
    }

    interface SalePresenter {
        void loadAllTask();
    }

    interface OnGetTaskCallback {
        void onGetAllTaskSuccess(List<Work> workList);
        void onGetAllTaskError(String msg);
    }
}
