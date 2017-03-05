package bsd.chula.smartgrass.mvp.suggestion;

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
import android.widget.ProgressBar;

import java.util.List;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.data.model.Grass;
import bsd.chula.smartgrass.utils.SpacesItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dev_Tee on 3/5/17.
 */

public class SuggestionFragment extends Fragment implements SuggestionContract.View {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private Context context;
    private SuggestionPresenter presenter;
    private SuggestionAdapter adapter;

    public static SuggestionFragment newInstance() {

        SuggestionFragment fragment = new SuggestionFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        getActivity().setTitle("ระบบแนะนำหญ้า");

        context = getActivity();
        presenter = new SuggestionPresenter(context, this);
        adapter = new SuggestionAdapter(context, onGrassItemClick);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_suggestion, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();

        presenter.loadAllGrass();
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.suggestion_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showGrassList(List<Grass> grassList) {
        progressBar.setVisibility(View.GONE);
        adapter.appendItems(grassList);
    }

    @Override
    public void showErrorDialog(String msg) {

    }

    SuggestionAdapter.OnGrassItemClick onGrassItemClick = new SuggestionAdapter.OnGrassItemClick() {
        @Override
        public void onGrassItemClick(Grass item) {

        }
    };
}
