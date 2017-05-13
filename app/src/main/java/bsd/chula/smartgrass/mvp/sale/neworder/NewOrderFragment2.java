package bsd.chula.smartgrass.mvp.sale.neworder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.parceler.Parcels;

import bsd.chula.smartgrass.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Dev_Tee on 5/6/17.
 */

public class NewOrderFragment2 extends Fragment {

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

    private static int mOrderType;

    public static NewOrderFragment2 newInstance(int orderType) {
        NewOrderFragment2 fragment = new NewOrderFragment2();
        fragment.mOrderType = orderType;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_order_step_two, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NewOrderChooseLocationActivity.REQUEST_CHOOSE_LOCATION_CODE) {

            NewOrderLocationData result = Parcels.unwrap(data.getExtras()
                    .getParcelable(NewOrderChooseLocationActivity.KEY_DESTINATION_RESULT));

            if (result != null) {
                mTextLocation.setText(result.getPlaceName());
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.layoutBtnNext)
    public void onNextButtonClick(View view) {

        ((NewOrderActivity) getActivity()).switchFragment(NewOrderFragment3.newInstance(),
                "NewOrderFragment3");
    }

    @OnClick(R.id.textLocation)
    public void onChooseLocationButtonClick(View view) {

        Intent chooseLocationIntent = new Intent(getActivity(), NewOrderChooseLocationActivity.class);
        startActivityForResult(chooseLocationIntent, NewOrderChooseLocationActivity.REQUEST_CHOOSE_LOCATION_CODE);
    }
}
