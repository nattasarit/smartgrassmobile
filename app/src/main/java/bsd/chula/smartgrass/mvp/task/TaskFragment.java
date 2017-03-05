package bsd.chula.smartgrass.mvp.task;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.data.model.Order;
import bsd.chula.smartgrass.mvp.task.dialog.TaskBottomSheetFragment;
import bsd.chula.smartgrass.utils.SpacesItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class TaskFragment extends Fragment implements TaskContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private Context context;
    private TaskPresenter presenter;
    private TaskListAdapter adapter;

    public static TaskFragment newInstance() {
        TaskFragment fragment = new TaskFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity();

        presenter = new TaskPresenter(context, this);
        adapter = new TaskListAdapter(context, onTaskItemClick);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();

        presenter.loadTaskList();
    }

    private void initView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(50);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(spacesItemDecoration);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showAllTasks(List<Order> orderList) {

        adapter.appendItems(orderList);
    }

    @Override
    public void showErrorDialog(String msg) {

    }

    @Override
    public void showTaskDetailUI(Order order) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.task, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    TaskListAdapter.OnTaskItemClick onTaskItemClick = new TaskListAdapter.OnTaskItemClick() {
        @Override
        public void onTaskItemClick(Order order) {

            TaskBottomSheetFragment fragment = TaskBottomSheetFragment.newInstance(order);
            fragment.show(getChildFragmentManager(), fragment.getTag());

        }
    };
}
