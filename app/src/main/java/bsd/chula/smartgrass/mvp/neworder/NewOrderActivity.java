package bsd.chula.smartgrass.mvp.neworder;

import android.content.Intent;
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
    @BindView(R.id.textStep4)
    TextView mTextStep4;
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

        if (savedInstanceState == null) {
            switchFragment(NewOrderFragment1.newInstance(), "NewOrderFragment1");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void switchFragment(Fragment fragment, String tag) {

        changeStateIndicator(tag);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(mContentFrame.getId(), fragment, tag)
                .commit();
    }

    private void changeStateIndicator(String tag) {

        mLayoutStep1.setBackgroundResource(R.drawable.oval_stroke_5dp_gray);
        mLayoutStep2.setBackgroundResource(R.drawable.oval_stroke_5dp_gray);
        mLayoutStep3.setBackgroundResource(R.drawable.oval_stroke_5dp_gray);
        mLayoutStep4.setBackgroundResource(R.drawable.oval_stroke_5dp_gray);

        mTextStep1.setTextColor(getResources().getColor(R.color.gray_line));
        mTextStep2.setTextColor(getResources().getColor(R.color.gray_line));
        mTextStep3.setTextColor(getResources().getColor(R.color.gray_line));
        mTextStep4.setTextColor(getResources().getColor(R.color.gray_line));

        switch (tag) {
            case "NewOrderFragment1":
                mLayoutStep1.setBackgroundResource(R.drawable.oval_stroke_5dp_green);
                mTextStep1.setTextColor(getResources().getColor(R.color.green));
                break;

            case "NewOrderFragment2":
                mLayoutStep2.setBackgroundResource(R.drawable.oval_stroke_5dp_green);
                mTextStep2.setTextColor(getResources().getColor(R.color.green));
                break;

            case "NewOrderFragment3":
                mLayoutStep3.setBackgroundResource(R.drawable.oval_stroke_5dp_green);
                mTextStep3.setTextColor(getResources().getColor(R.color.green));
                break;

            case "NewOrderFragment4":
                mLayoutStep4.setBackgroundResource(R.drawable.oval_stroke_5dp_green);
                mTextStep4.setTextColor(getResources().getColor(R.color.green));
                break;
        }
    }
}
