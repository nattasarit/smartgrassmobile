package bsd.chula.smartgrass.mvp.task;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import bsd.chula.smartgrass.data.model.Customer;
import bsd.chula.smartgrass.data.model.Order;
import bsd.chula.smartgrass.data.model.Status;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class TaskPresenter implements TaskContract.UserActions {

    private Context context;
    private TaskContract.View view;
    private TaskInteractor interactor;

    private List<Order> SAMPLE_ORDER = new ArrayList<>();

    public TaskPresenter(Context context, TaskContract.View view) {
        this.context = context;
        this.view = view;

        interactor = new TaskInteractor(context);

        sampleOrderCreate();
    }

    private void sampleOrderCreate() {

        Customer newCustomer1 = new Customer();
        newCustomer1.setId(1);
        newCustomer1.setFirstName("กิตติศักดิ์");
        newCustomer1.setLastName("บัวพันนา");
        newCustomer1.setAddress("Asok, Bangkok Thailand");
        newCustomer1.setTelephone("088-1111111");

        Customer newCustomer2 = new Customer();
        newCustomer2.setId(2);
        newCustomer2.setFirstName("จิตติมา");
        newCustomer2.setLastName("ก่อทรัพย์");
        newCustomer2.setAddress("Rama 2, Bangkok Thailand");
        newCustomer2.setTelephone("088-2222222");

        Customer newCustomer3 = new Customer();
        newCustomer3.setId(3);
        newCustomer3.setFirstName("ณัฐกมล");
        newCustomer3.setLastName("กาญจนาพิสิฐ");
        newCustomer3.setAddress("Ladprao, Bangkok Thailand");
        newCustomer3.setTelephone("088-3333333");

        Customer newCustomer4 = new Customer();
        newCustomer4.setId(4);
        newCustomer4.setFirstName("ปวีย์ ");
        newCustomer4.setLastName("เพชรรักษ์");
        newCustomer4.setAddress("Ladkrabang, Bangkok Thailand");
        newCustomer4.setTelephone("088-4444444");

        Customer newCustomer5 = new Customer();
        newCustomer5.setId(5);
        newCustomer5.setFirstName("ศิรินทรา");
        newCustomer5.setLastName("พึ่งธรรม");
        newCustomer5.setAddress("Rama 3, Bangkok Thailand");
        newCustomer5.setTelephone("088-5555555");

        Status newStatus1 = new Status();
        newStatus1.setId(1);
        newStatus1.setName("รอประเมินหน้างาน");

        Status newStatus2 = new Status();
        newStatus2.setId(2);
        newStatus2.setName("รอติดตั้ง");

        Status newStatus3 = new Status();
        newStatus3.setId(3);
        newStatus3.setName("รอตรวจรับ");

        Status newStatus4 = new Status();
        newStatus4.setId(4);
        newStatus4.setName("รอจัดส่ง");

        Status newStatus5 = new Status();
        newStatus5.setId(5);
        newStatus5.setName("ส่งมอบแล้ว");

        Order newOrder1 = new Order();
        newOrder1.setId(1);
        newOrder1.setCustomer(newCustomer1);
        newOrder1.setDescription("ปูสนามหญ้าหลังบ้าน");
        newOrder1.setLat(0);
        newOrder1.setLng(0);
        newOrder1.setDateTime("");
        newOrder1.setStatus(newStatus1);

        Order newOrder2 = new Order();
        newOrder2.setId(2);
        newOrder2.setCustomer(newCustomer2);
        newOrder2.setDescription("ปูสนามหญ้าหน้าบ้าน");
        newOrder2.setLat(0);
        newOrder2.setLng(0);
        newOrder2.setDateTime("");
        newOrder2.setStatus(newStatus2);

        Order newOrder3 = new Order();
        newOrder3.setId(3);
        newOrder3.setCustomer(newCustomer3);
        newOrder3.setDescription("ปูสนามหญ้า bra bra");
        newOrder3.setLat(0);
        newOrder3.setLng(0);
        newOrder3.setDateTime("");
        newOrder3.setStatus(newStatus3);

        Order newOrder4 = new Order();
        newOrder4.setId(4);
        newOrder4.setCustomer(newCustomer4);
        newOrder4.setDescription("ปูสนามหญ้า bra");
        newOrder4.setLat(0);
        newOrder4.setLng(0);
        newOrder4.setDateTime("");
        newOrder4.setStatus(newStatus4);

        Order newOrder5 = new Order();
        newOrder5.setId(3);
        newOrder5.setCustomer(newCustomer5);
        newOrder5.setDescription("ปูสนามหญ้า bra bra 123");
        newOrder5.setLat(0);
        newOrder5.setLng(0);
        newOrder5.setDateTime("");
        newOrder5.setStatus(newStatus5);

        SAMPLE_ORDER.add(newOrder1);
        SAMPLE_ORDER.add(newOrder2);
        SAMPLE_ORDER.add(newOrder3);
        SAMPLE_ORDER.add(newOrder4);
        SAMPLE_ORDER.add(newOrder5);
    }

    @Override
    public void loadTaskList() {

        view.showAllTasks(SAMPLE_ORDER);

        interactor.getAllTask(new TaskContract.GetAllTaskListener() {
            @Override
            public void onGetAllTaskSuccess(List<Order> orderList) {

                view.showAllTasks(orderList);
            }

            @Override
            public void onGetAllTaskError(String msg) {

                view.showErrorDialog(msg);
            }
        });
    }

    @Override
    public void loadTask(int id) {

    }
}
