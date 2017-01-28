package bsd.chula.smartgrass.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

    }

    @Override
    public void showLoginError(String msg) {

    }

    @OnClick(R.id.btnLogin)
    public void onLoginButtonClick(View view) {

        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();

        presenter.login(username, password);
    }
}
