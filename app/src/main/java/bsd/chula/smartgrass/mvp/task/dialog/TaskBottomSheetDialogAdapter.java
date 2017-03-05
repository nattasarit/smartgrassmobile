package bsd.chula.smartgrass.mvp.task.dialog;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import bsd.chula.smartgrass.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dev_Tee on 2/19/17.
 */

public class TaskBottomSheetDialogAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<TaskDialogObject> taskDialogObjectList;
    private OnMainDialogItemClick itemClick;

    public TaskBottomSheetDialogAdapter(Context context, List<TaskDialogObject> taskDialogObjectList,
                                        OnMainDialogItemClick itemClick) {

        this.context = context;
        this.taskDialogObjectList = taskDialogObjectList;
        this.itemClick = itemClick;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_main_dialog, parent, false);
        return new MainDialogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MainDialogViewHolder viewHolder = (MainDialogViewHolder) holder;
        final TaskDialogObject object = taskDialogObjectList.get(position);

        viewHolder.imgRes.setImageResource(object.getRes());
        viewHolder.txtTitle.setText(object.getTitle());

        viewHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick.onMainDialogItemClick(object);
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskDialogObjectList.size();
    }

    public class MainDialogViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rootView)
        LinearLayout rootView;
        @BindView(R.id.imgRes)
        AppCompatImageView imgRes;
        @BindView(R.id.txtTitle)
        TextView txtTitle;

        public MainDialogViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnMainDialogItemClick {
        void onMainDialogItemClick(TaskDialogObject item);
    }
}
