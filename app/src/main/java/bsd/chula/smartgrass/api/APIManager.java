package bsd.chula.smartgrass.api;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class APIManager {

    public static APIServices getService() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit restAdapter = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return restAdapter.create(APIServices.class);
    }
}
