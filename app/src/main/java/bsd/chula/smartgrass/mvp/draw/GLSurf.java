package bsd.chula.smartgrass.mvp.draw;

/**
 * Created by Nattasarit on 2/15/17.
 */

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class GLSurf extends GLSurfaceView {

    private GLRenderer mRenderer;

    public GLSurf(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2);

        // Set the Renderer for drawing on the GLSurfaceView
        mRenderer = new GLRenderer(context);
        setRenderer(mRenderer);


        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case (MotionEvent.ACTION_DOWN): // Touch screen pressed
                break;
            case (MotionEvent.ACTION_UP): // Touch screen touch ended
                break;
            case (MotionEvent.ACTION_MOVE): // Contact has moved across screen
                break;
            case (MotionEvent.ACTION_CANCEL): // Touch event cancelled
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        mRenderer.onPause();
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        mRenderer.onResume();
    }

    public void DrawLine(Float length, Float angle){
        mRenderer.DrawLine(length,angle);
        //mRenderer.Test2();
    }



}

