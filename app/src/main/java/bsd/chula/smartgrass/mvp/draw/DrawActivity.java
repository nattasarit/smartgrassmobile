package bsd.chula.smartgrass.mvp.draw;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

import bsd.chula.smartgrass.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.View.OnTouchListener;
import android.view.MotionEvent;


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
        //RelativeLayout.LayoutParams glParams = new RelativeLayout.LayoutParams(1280, 1280);

        RelativeLayout.LayoutParams glParams = new RelativeLayout.LayoutParams(2560, 1440);

        layout.addView(glSurfaceView, glParams);


        glSurfaceView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Interpret MotionEvent data
                // Handle touch here
                return true;
            }
        });

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
        if(editAngle.getText().toString().length() > 0) {
            angle = Float.valueOf(editAngle.getText().toString());
        }


        glSurfaceView.DrawLine(lenght,angle);


    }

}
