package bsd.chula.smartgrass.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.main.MainActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.editUsername)
    EditText editUsername;
    @BindView(R.id.editPassword)
    EditText editPassword;

    private Context context;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        context = getApplicationContext();
        presenter = new LoginPresenter(context, this);
    }

    @Override
    public void showLoginSuccessUI() {

        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);

        finish();
    }

    @Override
    public void showLoginError(String msg) {

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
