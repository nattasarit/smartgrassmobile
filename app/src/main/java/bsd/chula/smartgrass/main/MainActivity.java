package bsd.chula.smartgrass.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.data.task.Task;
import bsd.chula.smartgrass.utils.SpacesItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private MainPresenter presenter;
    private MainListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter(getApplicationContext(), this);
        adapter = new MainListAdapter(getApplicationContext(), onTaskItemClick);

        initView();

        presenter.loadTaskList();
    }

    private void initView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(50);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(spacesItemDecoration);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showAllTasks(List<Task> taskList) {

        adapter.appendItems(taskList);
    }

    @Override
    public void showErrorDialog(String msg) {

    }

    @Override
    public void showTaskDetailUI(Task task) {

    }

    MainListAdapter.OnTaskItemClick onTaskItemClick = new MainListAdapter.OnTaskItemClick() {
        @Override
        public void onTaskItemClick(Task task) {
            presenter.loadTask(task.getId());
        }
    };
}
