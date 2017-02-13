package bsd.chula.smartgrass.draw;

import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.utils.SpacesItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.lang.Object;
import java.lang.reflect.Array;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.opengl.GLES31;
import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import javax.microedition.khronos.opengles.GL10;

public class DrawActivity extends AppCompatActivity {

    @BindView(R.id.editLength)
    EditText editLength;
    @BindView(R.id.editAngle)
    EditText ediAngle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw2);

        ButterKnife.bind(this);

        //presenter = new DrawPresenter(getApplicationContext(), this);

        initView();

        //presenter.loadTaskList();
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(50);


    }

    @OnClick(R.id.btnDraw)
    public void onDrawButtonClick(View view) {
        String length = editLength.getText().toString();
        String angle = ediAngle.getText().toString();


        GLSurfaceView view2 = new GLSurfaceView(this);
        view2.setRenderer(new OpenGLRenderer());
        setContentView(view2);
    }

//        Line line = new Line();
//        line.draw(a);


}
