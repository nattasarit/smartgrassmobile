package bsd.chula.smartgrass.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.gcacace.signaturepad.views.SignaturePad;

import bsd.chula.smartgrass.R;
import butterknife.BindView;
import butterknife.ButterKnife;

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
    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.buttonsContainer)
    LinearLayout buttonsContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        ButterKnife.bind(this);
    }
}
