package bsd.chula.smartgrass;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import bsd.chula.smartgrass.api.APIManager;
import bsd.chula.smartgrass.api.APIServices;
import bsd.chula.smartgrass.api.model.MaxOrder;
import bsd.chula.smartgrass.api.model.MaxWork;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by Dev_Tee on 5/1/17.
 */

public class ServiceTest {

    @Mock
    private Context mContext;

    private APIServices mAPIServices;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        mAPIServices = APIManager.getService();
    }

    @Test
    public void get_max_work_test() {

        mAPIServices.getMaxWork().enqueue(new Callback<List<MaxWork>>() {
            @Override
            public void onResponse(Call<List<MaxWork>> call, Response<List<MaxWork>> response) {

                assertEquals(200, response.code());
                assertNotNull(response.body());
            }

            @Override
            public void onFailure(Call<List<MaxWork>> call, Throwable t) {

            }
        });
    }

    @Test
    public void get_max_order_test() {

        mAPIServices.getMaxOrder().enqueue(new Callback<List<MaxOrder>>() {
            @Override
            public void onResponse(Call<List<MaxOrder>> call, Response<List<MaxOrder>> response) {

                assertEquals(200, response.code());
                assertNotNull(response.body());
            }

            @Override
            public void onFailure(Call<List<MaxOrder>> call, Throwable t) {

            }
        });
    }
}
