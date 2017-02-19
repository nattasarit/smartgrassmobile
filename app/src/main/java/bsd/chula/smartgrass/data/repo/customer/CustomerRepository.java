package bsd.chula.smartgrass.data.repo.customer;

import java.util.List;

import bsd.chula.smartgrass.data.model.Customer;

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
