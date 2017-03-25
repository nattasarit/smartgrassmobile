package bsd.chula.smartgrass.mvp.createorder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.kofigyan.stateprogressbar.StateProgressBar;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.mvp.createorder.step1.Step1Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dev_Tee on 3/25/17.
 */

public class CreateOrderActivity extends AppCompatActivity {

    @BindView(R.id.state_progress)
    StateProgressBar stateProgress;
    @BindView(R.id.frame_container)
    FrameLayout frameContainer;
    @BindView(R.id.text_current_state)
    TextView textCurrentState;
    @BindView(R.id.text_current_state_description)
    TextView textCurrentStateDescription;

    private String[] mStateNumber = {"1", "2", "3", "4"};
    private String[] mStateDescriptionList = {"Customer Information", "Grass Information", "Appointment",
    "Review"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            stateProgress.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
            textCurrentState.setText(mStateNumber[0]);
            textCurrentStateDescription.setText(mStateDescriptionList[0]);

            switchFragment(Step1Fragment.newInstance());
        }
    }

    private void switchFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(frameContainer.getId(), fragment)
                .commit();
    }
}
