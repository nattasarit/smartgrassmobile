package bsd.chula.smartgrass.mvp.sign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.github.gcacace.signaturepad.views.SignaturePad;

import bsd.chula.smartgrass.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dev_Tee on 2/19/17.
 */

public class SignActivity extends AppCompatActivity {

    @BindView(R.id.signaturePad)
    SignaturePad signaturePad;
    @BindView(R.id.signature_pad_container)
    RelativeLayout signaturePadContainer;
    @BindView(R.id.btnClear)
    Button btnClear;
    @BindView(R.id.buttonsContainer)
    LinearLayout buttonsContainer;

    public static final int REQUEST_SIGNATURE_BITMAP = 1;
    public static final String EXTRA_SIGNATURE_BITMAP = "bitmap";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnClear)
    public void onClearClick() {
        signaturePad.clear();
    }

    @OnClick(R.id.btnSave)
    public void onSaveClick() {

        Intent intent=new Intent();
        intent.putExtra(EXTRA_SIGNATURE_BITMAP, signaturePad.getSignatureBitmap());
        setResult(REQUEST_SIGNATURE_BITMAP,intent);
        finish();
    }
}
