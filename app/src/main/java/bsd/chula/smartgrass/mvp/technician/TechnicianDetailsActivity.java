package bsd.chula.smartgrass.mvp.technician;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import org.parceler.Parcels;

import java.util.List;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.api.APIManager;
import bsd.chula.smartgrass.api.APIServices;
import bsd.chula.smartgrass.api.model.Work;
import bsd.chula.smartgrass.mvp.ReportActivity;
import bsd.chula.smartgrass.web.WebViewActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dev_Tee on 5/14/17.
 */

public class TechnicianDetailsActivity extends AppCompatActivity {

    @BindView(R.id.textWorkID)
    TextView mTextWorkID;
    @BindView(R.id.textFirstName)
    TextView mTextFirstName;
    @BindView(R.id.textLastName)
    TextView mTextLastName;
    @BindView(R.id.buttonTop)
    Button mButtonTop;
    @BindView(R.id.buttonBottom)
    Button mButtonBottom;

    public static String EXTRA_WORK_ID = "EXTRA_WORK_ID";

    private ProgressDialog mProgressDialog;
    private String mWorkID;
    private Work mWork;

    private final LatLng mDefaultLocation = new LatLng(13.7383829, 100.5298641);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_details);
        ButterKnife.bind(this);

        mProgressDialog = new ProgressDialog(this);

        mWorkID = getIntent().getStringExtra(EXTRA_WORK_ID);

        loadWork();
    }

    private void loadWork() {

        mProgressDialog.show();

        APIServices apiServices = APIManager.getService();

        apiServices.getWorkByID(mWorkID).enqueue(new Callback<List<Work>>() {
            @Override
            public void onResponse(Call<List<Work>> call, Response<List<Work>> response) {

                mProgressDialog.dismiss();

                List<Work> result = response.body();

                if (response.code() == 200) {
                    mWork = result.get(0);
                    checkWorkStatus(mWork);
                } else {
                    showErrorDialog();
                }
            }

            @Override
            public void onFailure(Call<List<Work>> call, Throwable t) {
                mProgressDialog.dismiss();
                showErrorDialog();
            }
        });

    }

    private void checkWorkStatus(Work work) {

        mTextWorkID.setText(work.getWorkID());
        mTextFirstName.setText(work.getCustomerName());


        mButtonTop.setVisibility(View.VISIBLE);
        mButtonBottom.setVisibility(View.VISIBLE);

        switch (work.getWorkStatusID()) {

            case "02":
            case "03":

                mButtonTop.setText(getString(R.string.action_navigate));
                mButtonTop.setOnClickListener(new OnGoToNavigate());

                mButtonBottom.setText(getString(R.string.action_explore));
                mButtonBottom.setOnClickListener(new OnGoToExplore());

                break;

            case "05":

                mButtonTop.setText(getString(R.string.action_implement));
                mButtonTop.setOnClickListener(new OnGoToImplement());

                mButtonBottom.setVisibility(View.GONE);

                break;

            case "01":
            case "07":

                mButtonTop.setText(getString(R.string.action_navigate));
                mButtonTop.setOnClickListener(new OnGoToNavigate());

                mButtonBottom.setText(getString(R.string.action_delivery));
                mButtonBottom.setOnClickListener(new OnGoToDelivery());

                break;
        }
    }

    private class OnGoToNavigate implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            String URL = "http://maps.google.com/maps?saddr={lat},{lng}&daddr={lat2},{lng2}";

            URL = URL.replace("{lat}", "" + mDefaultLocation.latitude);
            URL = URL.replace("{lng}", "" + mDefaultLocation.longitude);
            URL = URL.replace("{lat2}", mWork.getLatitude());
            URL = URL.replace("{lng2}", mWork.getLongitude());

            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(URL));
            startActivity(intent);

        }
    }

    private class OnGoToExplore implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            String URL = "http://websmartgrass.gear.host/core_testing/SmartGrassNew.html?WOID="
                    + mWork.getWorkID();

            Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
            intent.putExtra(WebViewActivity.EXTRA_URL, URL);
            startActivity(intent);

        /*    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
            startActivity(intent);
*/
        }
    }

    private class OnGoToImplement implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
            intent.putExtra(ReportActivity.EXTRA_WORK, Parcels.wrap(mWork));
            startActivity(intent);

        }
    }

    private class OnGoToDelivery implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(getApplicationContext(), ReportActivity.class);
            intent.putExtra(ReportActivity.EXTRA_WORK, Parcels.wrap(mWork));
            startActivity(intent);

        }
    }

    private void showErrorDialog() {

    }
}
