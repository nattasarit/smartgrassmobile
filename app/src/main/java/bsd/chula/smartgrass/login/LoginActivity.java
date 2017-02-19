package bsd.chula.smartgrass.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.AppCompatEditText;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.draw.DrawActivity;
import bsd.chula.smartgrass.main.MainActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.editUsername)
    AppCompatEditText editUsername;
    @BindView(R.id.editPassword)
    AppCompatEditText editPassword;

    private Context context;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        context = getApplicationContext();
        presenter = new LoginPresenter(context, this);

        setDrawableLeft(editUsername, R.drawable.ic_username);
        setDrawableLeft(editPassword, R.drawable.ic_password);
    }

    @Override
    public void showLoginSuccessUI() {

        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);

/*
        Intent drawIntent = new Intent(this, DrawActivity.class);
        startActivity(drawIntent);
*/

        finish();
    }

    @Override
    public void showLoginError(String msg) {

    }

    @OnClick(R.id.btnLogin)
    public void onLoginButtonClick(View view) {
        /*String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();

        if (username.length() == 0) {
            setEditTextError(editUsername);

        } else if (password.length() == 0) {

            setEditTextError(editPassword);
        } else {
            presenter.login(username, password);
        }

        presenter.login(username, password);*/

        Intent drawIntent = new Intent(this, DrawActivity.class);
        startActivity(drawIntent);
    }

    private static void setDrawableLeft(EditText editText, int resourceId) {
        Drawable drawable = VectorDrawableCompat.create(editText.getResources(), resourceId, editText.getContext().getTheme());
        Drawable[] drawables = editText.getCompoundDrawables();
        editText.setCompoundDrawablesWithIntrinsicBounds(drawable,
                drawables[1], drawables[2], drawables[3]);
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
}
