package bsd.chula.smartgrass.mvp.sale.neworder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.apmem.tools.layouts.FlowLayout;

import bsd.chula.smartgrass.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Dev_Tee on 5/6/17.
 */

public class NewOrderFragment3 extends Fragment {

    @BindView(R.id.text_order_id)
    TextView mTextOrderId;
    @BindView(R.id.textGrassName)
    TextView mTextGrassName;
    @BindView(R.id.textGrassPrice)
    TextView mTextGrassPrice;
    @BindView(R.id.layoutGrassItem)
    RelativeLayout mLayoutGrassItem;
    @BindView(R.id.layoutFlow)
    FlowLayout mLayoutFlow;
    @BindView(R.id.recycler_view_summary)
    RecyclerView mRecyclerViewSummary;
    @BindView(R.id.layoutBtnNext)
    LinearLayout mLayoutBtnNext;
    Unbinder unbinder;

    public static NewOrderFragment3 newInstance() {
        NewOrderFragment3 fragment2 = new NewOrderFragment3();
        return fragment2;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_order_step_three, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick(R.id.layoutBtnNext)
    public void onButtonNextClick(View view) {
        ((NewOrderActivity) getActivity()).switchFragment(NewOrderFragment4.newInstance(), "NewOrderFragment4");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
