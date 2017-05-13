package bsd.chula.smartgrass.mvp.technician;

import java.util.List;

import bsd.chula.smartgrass.api.model.Schedule;

/**
 * Created by Dev_Tee on 5/13/17.
 */

public interface TechnicianContract {

    interface TechnicianView {
        void onShowScheduleList(List<Schedule> scheduleList);
        void onShowErrorDialog(String msg);
    }

    interface TechnicianPresenter {
        void loadScheduleList();
    }

    interface OnLoadScheduleCallback {
        void onLoadScheduleSuccess(List<Schedule> scheduleList);
        void onLoadScheduleError(String msg);
    }
}
