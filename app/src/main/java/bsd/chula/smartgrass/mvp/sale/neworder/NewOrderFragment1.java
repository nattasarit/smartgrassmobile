package bsd.chula.smartgrass.mvp.sale.neworder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import bsd.chula.smartgrass.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Dev_Tee on 5/13/17.
 */

public class NewOrderFragment1 extends Fragment {

    @BindView(R.id.buttonOrderFirst)
    Button mButtonOrderFirst;
    @BindView(R.id.buttonOrderSecond)
    Button mButtonOrderSecond;
    Unbinder unbinder;

    public static NewOrderFragment1 newInstance() {
        NewOrderFragment1 fragment = new NewOrderFragment1();
        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_order_step_one, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick(R.id.buttonOrderFirst)
    public void onButtonOrderFirstClick(View view){
        ((NewOrderActivity) getActivity()).switchFragment(NewOrderFragment2.newInstance(1),
                "NewOrderFragment2");
    }

    @OnClick(R.id.buttonOrderSecond)
    public void onButtonOrderSecondClick(View view) {
        ((NewOrderActivity) getActivity()).switchFragment(NewOrderFragment2.newInstance(2),
                "NewOrderFragment2");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
