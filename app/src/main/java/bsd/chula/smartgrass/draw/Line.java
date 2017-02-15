package bsd.chula.smartgrass.draw;

/**
 * Created by Nattasarit on 2/13/17.
 */

import java.lang.Object;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLES20;

public class Line {

    //private FloatBuffer vertexBuffer;
    private FloatBuffer frameVertices;

    ByteBuffer diagIndices;


    float[] vertices = {
            -0.5f, -0.5f, 0.0f,
            -0.5f, 0.5f,  0.0f
    };

    public Line(GL10 gl) {
        // a float has 4 bytes so we allocate for each coordinate 4 bytes
        ByteBuffer vertexByteBuffer = ByteBuffer.allocateDirect(vertices.length * 4);
        vertexByteBuffer.order(ByteOrder.nativeOrder());

        // allocates the memory from the byte buffer
        frameVertices = vertexByteBuffer.asFloatBuffer();

        // fill the vertexBuffer with the vertices
        frameVertices.put(vertices);

        // set the cursor position to the beginning of the buffer
        frameVertices.position(0);

    }


    /** The draw method for the triangle with the GL context */
    public void draw(GL10 gl) {

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, frameVertices);
        gl.glColor4f(1.0f, 1.0f, 1.0f, 1f);

        gl.glDrawArrays(GL10.GL_LINE_LOOP , 0, vertices.length / 3);
        gl.glLineWidth(5.0f);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}