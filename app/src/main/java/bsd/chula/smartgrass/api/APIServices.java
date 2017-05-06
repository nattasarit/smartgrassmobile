package bsd.chula.smartgrass.api;

import java.util.List;

import bsd.chula.smartgrass.api.model.Grass;
import bsd.chula.smartgrass.api.model.InsertResponse;
import bsd.chula.smartgrass.api.model.MaxOrder;
import bsd.chula.smartgrass.api.model.MaxWork;
import bsd.chula.smartgrass.api.model.Role;
import bsd.chula.smartgrass.api.model.Work;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

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

    @GET("serviceGet.php?action=getLogin")
    Call<List<Role>> getLogin (
            @Query("Username") String username,
            @Query("Password") String password
    );

    @GET("serviceGet.php?action=getMaxWork")
    Call<List<MaxWork>> getMaxWork (

    );

    @GET("serviceInsert.php?action=insertWork")
    Call<List<InsertResponse>> insertWork (
            @Query("WorkID") int workID,
            @Query("CustomerID") int customerID,
            @Query("WorkStatusID") int statusID,
            @Query("ArtificialGrassCatagoryID") int categoryID,
            @Query("latitude") double latitude,
            @Query("longitude") double longitude
    );

    @GET("serviceGet.php?action=getMaxOrder")
    Call<List<MaxOrder>> getMaxOrder (

    );

    @GET("serviceInsert.php?action=insertOrder")
    Call<List<InsertResponse>> insertOrder (
            @Query("OrderID") int orderID,
            @Query("MaterialID") int materialID,
            @Query("ArtificialGrassID") int grassID,
            @Query("OrderDate") String date,
            @Query("Quantity") double quantity,
            @Query("Unit") int unit,
            @Query("Amount") double amount
    );
}
