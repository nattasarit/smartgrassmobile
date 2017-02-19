package bsd.chula.smartgrass.draw;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.login.LoginPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import bsd.chula.smartgrass.draw.GLSurf;

public class DrawActivity extends Activity {

    // Our OpenGL Surfaceview
    private GLSurf glSurfaceView;

    @BindView(R.id.editLength)
    EditText editLength;
    @BindView(R.id.editAngle)
    EditText editAngle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Turn off the window's title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Super
        super.onCreate(savedInstanceState);

        // Fullscreen mode
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // We create our Surfaceview for our OpenGL here.
        glSurfaceView = new GLSurf(this);

        // Set our view.
        setContentView(R.layout.activity_draw2);

        // Retrieve our Relative layout from our main layout we just set to our view.
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.gamelayout);

        // Attach our surfaceview to our relative layout from our main layout.
        //RelativeLayout.LayoutParams glParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        RelativeLayout.LayoutParams glParams = new RelativeLayout.LayoutParams(900, 900);

        layout.addView(glSurfaceView, glParams);

        ButterKnife.bind(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        glSurfaceView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        glSurfaceView.onResume();
    }


    @OnClick(R.id.btnDraw)
    public void onDrawButtonClick(View view) {
        float lenght = 0.0f;
        if(editLength.getText().toString().length() > 0){
            lenght = Float.valueOf(editLength.getText().toString());
        }

        float angle = 0.0f;
        if(editLength.getText().toString().length() > 0) {
            angle = Float.valueOf(editAngle.getText().toString());
        }


        glSurfaceView.DrawLine(lenght,angle);


    }

}
