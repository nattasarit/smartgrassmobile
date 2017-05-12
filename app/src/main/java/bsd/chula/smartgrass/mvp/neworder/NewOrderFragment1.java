package bsd.chula.smartgrass.mvp.neworder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import bsd.chula.smartgrass.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Dev_Tee on 5/6/17.
 */

public class NewOrderFragment1 extends Fragment {

    @BindView(R.id.editFirstName)
    EditText mEditFirstName;
    @BindView(R.id.editLastName)
    EditText mEditLastName;
    @BindView(R.id.editEmail)
    EditText mEditEmail;
    @BindView(R.id.editPhone)
    EditText mEditPhone;
    @BindView(R.id.textLocation)
    TextView mTextLocation;
    @BindView(R.id.layoutBtnNext)
    LinearLayout mLayoutBtnNext;
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
        View view = inflater.inflate(R.layout.fragment_new_order_one, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.layoutBtnNext)
    public void onNextButtonClick(View view) {

        ((NewOrderActivity) getActivity()).switchFragment(NewOrderFragment2.newInstance(),
                "NewOrderFragment2");
    }

    @OnClick(R.id.textLocation)
    public void onChooseLocationButtonClick(View view) {
    }
}
