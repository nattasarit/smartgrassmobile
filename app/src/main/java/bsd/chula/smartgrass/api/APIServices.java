package bsd.chula.smartgrass.api;

import java.util.List;

import bsd.chula.smartgrass.data.model.Grass;
import bsd.chula.smartgrass.data.model.Login;
import bsd.chula.smartgrass.data.model.LoginItem;
import bsd.chula.smartgrass.data.model.Role;
import bsd.chula.smartgrass.data.model.Work;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public interface APIServices {

    @GET("serviceGet.php?action=getWork")
    Call<List<Work>> getAllWorks (
    );

    @GET("serviceGet.php?action=getGrassDetail")
    Call<List<Grass>> getAllGrass (
    );

    @FormUrlEncoded
    @GET("serviceGet.php?action")
    Call<List<Role>> getLogin (
            @Body Login login
    );
}
