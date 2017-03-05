package bsd.chula.smartgrass.api;

import java.util.List;

import bsd.chula.smartgrass.data.model.Grass;
import bsd.chula.smartgrass.data.model.Work;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public interface APIServices {

    @GET("service8.php?action=getWork")
    Call<List<Work>> getAllWorks (
    );

    @GET("service8.php?action=getGrassDetail")
    Call<List<Grass>> getAllGrass (

    );
}
