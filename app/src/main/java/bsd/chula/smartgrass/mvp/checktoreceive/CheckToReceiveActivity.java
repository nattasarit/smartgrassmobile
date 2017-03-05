package bsd.chula.smartgrass.mvp.checktoreceive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.mvp.sign.SignActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;

/**
 * Created by Dev_Tee on 2/22/17.
 */

public class CheckToReceiveActivity extends AppCompatActivity {

    @BindView(R.id.pdfView)
    FrameLayout pdfView;

    private Context context;
    private RemotePDFViewPager viewPager;
    private PDFPagerAdapter pdfPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        ButterKnife.bind(this);

        context = this;

        fromNetwork("http://www.sso.go.th/wprp/uploads/nakhonsithammarat/AnnounceTOR/04_3sso.pdf");
    }

    @OnClick(R.id.btnSubmit)
    public void onSubmitClick() {

        Intent signIntent = new Intent(this, SignActivity.class);
        startActivityForResult(signIntent, SignActivity.REQUEST_SIGNATURE_BITMAP);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }

    private void fromNetwork(String endpoint) {

        viewPager = new RemotePDFViewPager(this, endpoint, new DownloadFile.Listener() {
            @Override
            public void onSuccess(String url, String destinationPath) {

                pdfPagerAdapter = new PDFPagerAdapter(context, destinationPath);
                viewPager.setAdapter(pdfPagerAdapter);
            }

            @Override
            public void onFailure(Exception e) {

            }

            @Override
            public void onProgressUpdate(int progress, int total) {

            }
        });

        pdfView.addView(viewPager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        pdfPagerAdapter.close();
    }
}
