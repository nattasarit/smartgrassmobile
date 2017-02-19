package bsd.chula.smartgrass.draw;

/**
 * Created by Nattasarit on 2/15/17.
 */

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import java.lang.Math;

public class GLRenderer implements Renderer {



    // Our matrices
    private final float[] mtrxProjection = new float[16];
    private final float[] mtrxView = new float[16];
    private final float[] mtrxProjectionAndView = new float[16];

    // Geometric variables
    public static float vertices[];
    public static short indices[];
    public FloatBuffer vertexBuffer;
    public ShortBuffer drawListBuffer;

    // Our screenresolution
    float   mScreenWidth = 1280;
    float   mScreenHeight = 1280;

    // Misc
    Context mContext;
    long mLastTime;
    int mProgram;

    public GLRenderer(Context c)
    {
        mContext = c;
        mLastTime = System.currentTimeMillis() + 100;
    }

    public void onPause()
    {
        /* Do stuff to pause the renderer */
    }

    public void onResume()
    {
        /* Do stuff to resume the renderer */
        mLastTime = System.currentTimeMillis();
    }

    @Override
    public void onDrawFrame(GL10 unused) {

        // Get the current time
        long now = System.currentTimeMillis();

        // We should make sure we are valid and sane
        if (mLastTime > now) return;

        // Get the amount of time the last frame took.
        long elapsed = now - mLastTime;

        // Update our example

        // Render our example
        Render(mtrxProjectionAndView);

        // Save the current time to see how long it took <img src="http://androidblog.reindustries.com/wp-includes/images/smilies/icon_smile.gif" alt=":)" class="wp-smiley"> .
        mLastTime = now;
    }

    private void Render(float[] m) {

        // clear Screen and Depth Buffer, we have set the clear color as black.

        //GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        // get handle to vertex shader's vPosition member
        int mPositionHandle = GLES20.glGetAttribLocation(riGraphicTools.sp_SolidColor, "vPosition");

        // Enable generic vertex attribute array
        GLES20.glEnableVertexAttribArray(mPositionHandle);

        // Prepare the triangle coordinate data
        GLES20.glVertexAttribPointer(mPositionHandle, 3,
                GLES20.GL_FLOAT, false,
                0, vertexBuffer);

        // Get handle to shape's transformation matrix
        int mtrxhandle = GLES20.glGetUniformLocation(riGraphicTools.sp_SolidColor, "uMVPMatrix");

        // Apply the projection and view transformation
        GLES20.glUniformMatrix4fv(mtrxhandle, 1, false, m, 0);

        // Draw the triangle
        GLES20.glDrawElements(GLES20.GL_LINES, indices.length,
                GLES20.GL_UNSIGNED_SHORT, drawListBuffer);
        GLES20.glLineWidth(5.0f);

        // Disable vertex array
        GLES20.glDisableVertexAttribArray(mPositionHandle);

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

        // We need to know the current width and height.
        mScreenWidth = width;
        mScreenHeight = height;

        // Redo the Viewport, making it fullscreen.
        GLES20.glViewport(0, 0, (int)mScreenWidth, (int)mScreenHeight);

        // Clear our matrices
        for(int i=0;i<16;i++)
        {
            mtrxProjection[i] = 0.0f;
            mtrxView[i] = 0.0f;
            mtrxProjectionAndView[i] = 0.0f;
        }

        // Setup our screen width and height for normal sprite translation.
        Matrix.orthoM(mtrxProjection, 0, 0f, mScreenWidth, 0.0f, mScreenHeight, 0, 50);

        // Set the camera position (View matrix)
        Matrix.setLookAtM(mtrxView, 0, 0f, 0f, 1f, 0f, 0f, 0f, 0f, 1.0f, 0.0f);

        // Calculate the projection and view transformation
        Matrix.multiplyMM(mtrxProjectionAndView, 0, mtrxProjection, 0, mtrxView, 0);

    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {


        //Create the triangle
        SetupTriangle();

        //Set the clear color to black
        GLES20.glClearColor(255.0f, 255.0f, 255.0f, 1);

        // Create the shaders
        int vertexShader = riGraphicTools.loadShader(GLES20.GL_VERTEX_SHADER, riGraphicTools.vs_SolidColor);
        int fragmentShader = riGraphicTools.loadShader(GLES20.GL_FRAGMENT_SHADER, riGraphicTools.fs_SolidColor);

        riGraphicTools.sp_SolidColor = GLES20.glCreateProgram();             // create empty OpenGL ES Program
        GLES20.glAttachShader(riGraphicTools.sp_SolidColor, vertexShader);   // add the vertex shader to program
        GLES20.glAttachShader(riGraphicTools.sp_SolidColor, fragmentShader); // add the fragment shader to program
        GLES20.glLinkProgram(riGraphicTools.sp_SolidColor);                  // creates OpenGL ES program executables

        // Set our shader programm
        GLES20.glUseProgram(riGraphicTools.sp_SolidColor);

        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
    }

    public void SetupTriangle()
    {
        // We have create the vertices of our view.
//        vertices = new float[]
//                {
//                        10.0f, 200f, 0.0f,
//                        10.0f, 100f, 0.0f,
//                        100f, 100f, 0.0f,
//                };

        vertices = new float[]
                {
                        0.0f, 0.0f, 0.0f,
                        0.0f, 0.0f, 0.0f,
                        0.0f, 0.0f, 0.0f,
                };

        indices = new short[] {0, 1, 2}; // loop in the android official tutorial opengles why different order.

        // The vertex buffer.
        ByteBuffer bb = ByteBuffer.allocateDirect(vertices.length * 4);
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);



        // initialize byte buffer for the draw list
        ByteBuffer dlb = ByteBuffer.allocateDirect(indices.length * 2);
        dlb.order(ByteOrder.nativeOrder());
        drawListBuffer = dlb.asShortBuffer();
        drawListBuffer.put(indices);
        drawListBuffer.position(0);

    }

    float x1 = 10.0f;
    float y1 = 200.0f;

    float x2 = 10.0f;
    float y2 = 100.0f;

    float x3 = 100.0f;
    float y3 = 100.0f;
    public void Test(){
        x1+=20f;
        y1+=20f;

        x2+=20f;
        y2+=20f;

        x3+=20f;
        y3+=20f;

        // We have create the vertices of our view.
        vertices = new float[]
                {
                        x1, y1, 0.0f,
                        x2, y2, 0.0f,
                        x3, y3, 0.0f,
                };

        indices = new short[] {0, 1, 2}; // loop in the android official tutorial opengles why different order.

        // The vertex buffer.
        ByteBuffer bb = ByteBuffer.allocateDirect(vertices.length * 4);
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);

        // initialize byte buffer for the draw list
        ByteBuffer dlb = ByteBuffer.allocateDirect(indices.length * 2);
        dlb.order(ByteOrder.nativeOrder());
        drawListBuffer = dlb.asShortBuffer();
        drawListBuffer.put(indices);
        drawListBuffer.position(0);

    }

    public void Test2(){
        Line eastHorz = new Line();
        eastHorz.draw();
    }


    float[] previusEndPoint = null;
    public void DrawLine(float length, float angle) {



        float[] startPoint;
        float[] endPoint;

        if(previusEndPoint == null){
            previusEndPoint = new float[3];

            startPoint = new float[]{
                    300.0f, 0.0f, 0.0f
            };

//            endPoint = new float[]{
//                    300.0f, 100.0f, 0.0f
//            };

            endPoint = calEndPoint(startPoint, length, angle);
        }
        else{
            startPoint = previusEndPoint;

//            float end = previusEndPoint[1] + length;
//            endPoint =new float[]{
//                    300.0f, end, 0.0f
//            };
            endPoint = calEndPoint(startPoint, length, angle);
        }

        vertices = new float[]
                {
                        startPoint[0], startPoint[1], startPoint[2],
                        endPoint[0], endPoint[1], endPoint[2]
                };

        previusEndPoint = new float[]{
                vertices[3], vertices[4], vertices[5]
        };


        indices = new short[] {0, 1}; // loop in the android official tutorial opengles why different order.

        // The vertex buffer.
        ByteBuffer bb = ByteBuffer.allocateDirect(vertices.length * 4);
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);

        // initialize byte buffer for the draw list
        ByteBuffer dlb = ByteBuffer.allocateDirect(indices.length * 2);
        dlb.order(ByteOrder.nativeOrder());
        drawListBuffer = dlb.asShortBuffer();
        drawListBuffer.put(indices);
        drawListBuffer.position(0);
    }

    private float[] calEndPoint(float[] startPoint, float length, float angle) {
        float[] endpoint = new float[3];

        //

//        if(angle >= 0.0f && angle <= 90.0f){
//            angle = Math.abs(angle-90);
//        }else if(angle > 90.0f && angle <= 180.0f){
//            angle = angle + 90;
//        }
//        else{
//            angle = 360 + angle;
//        }


        //angle = (float) (Math.toDegrees(angle)+180);

        if(angle == 0){
            angle = angle + 90;
        }
        else if(angle > 0 && angle <= 90){
            angle = Math.abs(angle - 90);
        }
        else if(angle > 90 && angle <= 180){
            angle = 360 - Math.abs(90 - angle);
        }
        else if(angle > 180 && angle <= 270 ){
            angle = 270 - Math.abs(180 - angle);
        }
        else if(angle > 270 && angle <=360){
            angle = 180 - Math.abs(270 - angle);
        }

        angle = (float)(angle * 0.017453292519);



        float pointX = startPoint[0] + (float)(Math.cos(angle) * length);
        float pointY = startPoint[1] + (float)(Math.sin(angle) * length);
        float pointZ = 0.0f;

        endpoint = new float[]{
                pointX, pointY, pointZ
        };

        return endpoint;
    }
}
