package bsd.chula.smartgrass.mvp.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.function.Predicate;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.api.model.Role;
import bsd.chula.smartgrass.mvp.main.MainActivity;
import bsd.chula.smartgrass.mvp.sale.SaleActivity;
import bsd.chula.smartgrass.mvp.technician.TechnicianActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {

    @BindView(R.id.editUsername)
    AppCompatEditText editUsername;
    @BindView(R.id.editPassword)
    AppCompatEditText editPassword;
    @BindView(R.id.imgThumbnail)
    ImageView imgThumbnail;

    private Context context;
    private LoginPresenter presenter;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        context = getApplicationContext();
        presenter = new LoginPresenter(this);

        initView();
    }

    @Override
    public void showLoginSuccessUI(List<Role> roleList) {

        if (findRole(roleList, "Sell")) {

            Intent saleIntent = new Intent(getApplicationContext(), SaleActivity.class);
            startActivity(saleIntent);

        } else if (findRole(roleList, "Technician")) {

            Intent technicianIntent = new Intent(getApplicationContext(), TechnicianActivity.class);
            startActivity(technicianIntent);
        }

        finish();
    }

    @Override
    public void showLoginError(String msg) {

    }

    @Override
    public void showLoading(boolean isLoad) {
        if (isLoad) {
            mProgressDialog.show();
        } else {
            mProgressDialog.dismiss();
        }
    }

    @OnClick(R.id.btnLogin)
    public void onLoginButtonClick(View view) {
        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();

        if (username.length() == 0) {
            setEditTextError(editUsername);
        } else if (password.length() == 0) {
            setEditTextError(editPassword);
        } else {
            presenter.login(username, password);
        }
    }

    private void initView() {
        Glide.with(context).load(R.mipmap.ic_grass_home)
                .bitmapTransform(new BlurTransformation(context))
                .into(imgThumbnail);

        mProgressDialog = new ProgressDialog(this);
    }

    private void setEditTextError(EditText editText) {

        int errorColor = getResources().getColor(R.color.red);
        String errorStr = "";

        switch (editText.getId()) {
            case R.id.editUsername:
                errorStr = getResources().getString(R.string.login_error_username_msg);
                break;

            case R.id.editPassword:
                errorStr = getResources().getString(R.string.login_error_password_msg);
                break;
        }

        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(errorColor);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(errorStr);
        spannableStringBuilder.setSpan(foregroundColorSpan, 0, errorStr.length(), 0);

        editText.requestFocus();
        editText.setError(spannableStringBuilder);
    }

    private boolean findRole(List<Role> roleList, final String roleName) {
        boolean isHasRole = false;

        for (Role role : roleList) {
            if (role.getRoleName().equalsIgnoreCase(roleName)) {
                return true;
            }
        }

        return isHasRole;
    }
}
