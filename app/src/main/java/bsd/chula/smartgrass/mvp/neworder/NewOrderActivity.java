package bsd.chula.smartgrass.mvp.neworder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bsd.chula.smartgrass.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dev_Tee on 5/6/17.
 */

public class NewOrderActivity extends AppCompatActivity {

    @BindView(R.id.content_frame)
    FrameLayout mContentFrame;
    @BindView(R.id.textStep1)
    TextView mTextStep1;
    @BindView(R.id.layoutStep1)
    RelativeLayout mLayoutStep1;
    @BindView(R.id.textStep2)
    TextView mTextStep2;
    @BindView(R.id.layoutStep2)
    RelativeLayout mLayoutStep2;
    @BindView(R.id.textStep3)
    TextView mTextStep3;
    @BindView(R.id.layoutStep3)
    RelativeLayout mLayoutStep3;
    @BindView(R.id.layoutStep4)
    RelativeLayout mLayoutStep4;
    @BindView(R.id.imageThumbnail)
    AppCompatImageView mImageThumbnail;
    @BindView(R.id.textStepDescription)
    TextView mTextStepDescription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);
        ButterKnife.bind(this);
    }

    private void switchFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(mContentFrame.getId(), fragment)
                .commit();
    }
}
