package bsd.chula.smartgrass.mvp.task.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.data.model.Work;
import bsd.chula.smartgrass.mvp.checktoreceive.CheckToReceiveActivity;
import bsd.chula.smartgrass.mvp.navigate.NavigateActivity;
import bsd.chula.smartgrass.utils.SpacesItemDecoration;
import bsd.chula.smartgrass.web.WebViewActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dev_Tee on 2/19/17.
 */

public class TaskBottomSheetFragment extends BottomSheetDialogFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private Context context;
    private TaskBottomSheetDialogAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private Work work;

    public static TaskBottomSheetFragment newInstance(Work newWork) {
        TaskBottomSheetFragment fragment = new TaskBottomSheetFragment();
        fragment.work = newWork;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity();

        linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        View view = View.inflate(context, R.layout.fragment_main_bottomsheet, null);
        ButterKnife.bind(this, view);
        dialog.setContentView(view);

        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new SpacesItemDecoration(10));
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        adapter = new TaskBottomSheetDialogAdapter(context, createDialogList(), onMainDialogItemClick);

        recyclerView.setAdapter(adapter);
    }

    private List<TaskDialogObject> createDialogList() {

        List<TaskDialogObject> results = new ArrayList<>();

        TaskDialogObject object1 = new TaskDialogObject();
        object1.setId(1);
        object1.setRes(R.drawable.ic_alert);
        object1.setTitle(context.getString(R.string.main_dialog_event_evaluation));

        TaskDialogObject object2 = new TaskDialogObject();
        object2.setId(2);
        object2.setRes(R.drawable.ic_calendar);
        object2.setTitle(context.getString(R.string.main_dialog_event_show_details));

        TaskDialogObject object3 = new TaskDialogObject();
        object3.setId(3);
        object3.setRes(R.drawable.ic_calendar);
        object3.setTitle(context.getString(R.string.main_dialog_event_show_direction));

        TaskDialogObject object4 = new TaskDialogObject();
        object4.setId(4);
        object4.setRes(R.drawable.ic_calendar);
        object4.setTitle(context.getString(R.string.main_dialog_event_check));

        TaskDialogObject object5 = new TaskDialogObject();
        object5.setId(5);
        object5.setRes(R.drawable.ic_calendar);
        object5.setTitle(context.getString(R.string.main_dialog_event_deliver));

        switch (work.getWorkStatusID()) {

            case "01": {

                results.add(object1);
                results.add(object2);

            } break;

            case "02": {

                results.add(object3);
                results.add(object2);

            } break;

            case "03": {

                results.add(object4);
                results.add(object2);

            } break;

            case "04": {

                results.add(object5);
                results.add(object2);

            } break;

        }

        return results;
    }

    TaskBottomSheetDialogAdapter.OnMainDialogItemClick onMainDialogItemClick
            = new TaskBottomSheetDialogAdapter.OnMainDialogItemClick() {

        @Override
        public void onMainDialogItemClick(TaskDialogObject item) {

            switch (item.getId()) {

                case 1: {

                    Intent webViewIntent = new Intent(context, WebViewActivity.class);
                    context.startActivity(webViewIntent);

                } break;

                case 2: {

                } break;


                case 3: {

                    Intent directionIntent = new Intent(context, NavigateActivity.class);
                    context.startActivity(directionIntent);

                } break;

                case 4: {

                    Intent checkToReceiveIntent = new Intent(context, CheckToReceiveActivity.class);
                    context.startActivity(checkToReceiveIntent);

                } break;

                case 5: {

                } break;

            }


            dismiss();

        }
    };
}
