package bsd.chula.smartgrass.main.dialog;

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
import bsd.chula.smartgrass.data.model.Order;
import bsd.chula.smartgrass.draw.DrawActivity;
import bsd.chula.smartgrass.navigate.NavigateActivity;
import bsd.chula.smartgrass.utils.SpacesItemDecoration;
import bsd.chula.smartgrass.web.WebViewActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dev_Tee on 2/19/17.
 */

public class MainBottomSheetFragment extends BottomSheetDialogFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private Context context;
    private MainBottomSheetDialogAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private Order order;

    public static MainBottomSheetFragment newInstance(Order newOrder) {
        MainBottomSheetFragment fragment = new MainBottomSheetFragment();
        fragment.order = newOrder;
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


        adapter = new MainBottomSheetDialogAdapter(context, createDialogList(), onMainDialogItemClick);

        recyclerView.setAdapter(adapter);
    }

    private List<MainDialogObject> createDialogList() {

        List<MainDialogObject> results = new ArrayList<>();

        MainDialogObject object1 = new MainDialogObject();
        object1.setId(1);
        object1.setRes(R.drawable.ic_alert);
        object1.setTitle(context.getString(R.string.main_dialog_event_evaluation));

        MainDialogObject object2 = new MainDialogObject();
        object2.setId(2);
        object2.setRes(R.drawable.ic_calendar);
        object2.setTitle(context.getString(R.string.main_dialog_event_show_details));

        MainDialogObject object3 = new MainDialogObject();
        object3.setId(3);
        object3.setRes(R.drawable.ic_calendar);
        object3.setTitle(context.getString(R.string.main_dialog_event_show_direction));

        MainDialogObject object4 = new MainDialogObject();
        object4.setId(4);
        object4.setRes(R.drawable.ic_calendar);
        object4.setTitle(context.getString(R.string.main_dialog_event_check));

        MainDialogObject object5 = new MainDialogObject();
        object5.setId(5);
        object5.setRes(R.drawable.ic_calendar);
        object5.setTitle(context.getString(R.string.main_dialog_event_deliver));

        MainDialogObject object6 = new MainDialogObject();
        object6.setId(6);
        object6.setRes(R.drawable.ic_alert);
        object6.setTitle("ประเมินหน้างาน - WebView");

        switch (order.getStatus().getId()) {

            case 1: {

                results.add(object1);
                results.add(object2);
                results.add(object6);

            } break;

            case 2: {

                results.add(object3);
                results.add(object2);

            } break;

            case 3: {

                results.add(object4);
                results.add(object2);

            } break;

            case 4: {

                results.add(object5);
                results.add(object2);

            } break;

        }

        return results;
    }

    MainBottomSheetDialogAdapter.OnMainDialogItemClick onMainDialogItemClick
            = new MainBottomSheetDialogAdapter.OnMainDialogItemClick() {

        @Override
        public void onMainDialogItemClick(MainDialogObject item) {

            switch (item.getId()) {

                case 1: {

                    Intent drawIntent = new Intent(context, DrawActivity.class);
                    context.startActivity(drawIntent);

                } break;

                case 2: {

                } break;


                case 3: {

                    Intent directionIntent = new Intent(context, NavigateActivity.class);
                    context.startActivity(directionIntent);

                } break;

                case 4: {

                } break;

                case 5: {

                } break;

                case 6: {

                    Intent webViewIntent = new Intent(context, WebViewActivity.class);
                    context.startActivity(webViewIntent);

                } break;
            }


            dismiss();

        }
    };
}
