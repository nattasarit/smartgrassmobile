package bsd.chula.smartgrass.mvp.sale;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.api.model.Work;
import bsd.chula.smartgrass.mvp.sale.neworder.NewOrderActivity;
import bsd.chula.smartgrass.utils.SpacesItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dev_Tee on 5/13/17.
 */

public class SaleActivity extends AppCompatActivity implements SaleListAdapter.OnTaskItemClick,
        SaleContract.SaleView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.fab)
    FloatingActionButton mFab;

    private Context mContext;
    private SalePresenter mSalePresenter;
    private SaleListAdapter mListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
        ButterKnife.bind(this);

        mContext = getApplicationContext();
        mSalePresenter = new SalePresenter(this);
        mListAdapter = new SaleListAdapter(mContext, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(10);

        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(spacesItemDecoration);

        mSalePresenter.loadAllTask();

        mRecyclerView.setAdapter(mListAdapter);
    }

    @Override
    public void onTaskItemClick(Work work) {

    }

    @Override
    public void showAllTasks(List<Work> workList) {
        mListAdapter.appendItems(workList);
    }

    @Override
    public void showErrorDialog(String msg) {

    }

    @OnClick(R.id.fab)
    public void onAddButtonClick(View view) {

        Intent intent = new Intent(mContext, NewOrderActivity.class);
        startActivity(intent);
    }
}
