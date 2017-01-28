package bsd.chula.smartgrass.data.customer;

import java.util.List;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public interface CustomerRepository {

    void getCustomerList();

    void getCustomer(int id);

    interface GetCustomerListCallback {

        void onGetCustomerListSuccess(List<Customer> customerList);

        void onGetCustomerListError(String msg);

    }

    interface GetCustomerCallback {

        void onGetCustomerSuccess(Customer customer);

        void onGetCustomerError(String msg);
    }
}
