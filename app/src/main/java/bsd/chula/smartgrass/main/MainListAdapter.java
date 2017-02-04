package bsd.chula.smartgrass.main;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.txusballesteros.widgets.FitChart;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.data.task.Task;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dev_Tee on 2/4/17.
 */

public class MainListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Task> taskList;
    private OnTaskItemClick taskItemClick;

    public MainListAdapter(Context context, OnTaskItemClick taskItemClick) {
        this.context = context;

        taskList = new ArrayList<>();
        this.taskItemClick = taskItemClick;
    }

    public void appendItems(List<Task> taskList) {
        this.taskList.addAll(taskList);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_main_item, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MainViewHolder viewHolder = (MainViewHolder) holder;
        final Task item = taskList.get(position);

        viewHolder.txtCustName.setText(item.getFirstName() + " " + item.getLastName());
        viewHolder.txtDescription.setText(item.getDescription());

        viewHolder.txtOrderNum.setText("Order 0" + item.getId());

        viewHolder.chartView.setMinValue(0f);
        viewHolder.chartView.setMaxValue(100f);
        viewHolder.chartView.setValue(80f);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date dateFormated = dateFormat.parse(item.getDateTime());
            String dateStr = dateFormated.toString();

            viewHolder.txtDate.setText(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (position % 2 == 0) {
            viewHolder.imgAlert.setColorFilter(context.getResources().getColor(android.R.color.holo_red_dark),
                    PorterDuff.Mode.SRC_IN);
            viewHolder.imgAction.setColorFilter(context.getResources().getColor(android.R.color.holo_green_dark),
                    PorterDuff.Mode.SRC_IN);

        } else {
            viewHolder.imgAlert.setColorFilter(context.getResources().getColor(android.R.color.holo_green_dark),
                    PorterDuff.Mode.SRC_IN);
            viewHolder.imgAction.setColorFilter(context.getResources().getColor(android.R.color.holo_orange_dark),
                    PorterDuff.Mode.SRC_IN);
        }

        if (position % 2 != 0) {
            viewHolder.viewGate.setBackgroundColor(context.getResources().getColor(android.R.color.holo_blue_dark));
        } else {
            viewHolder.viewGate.setBackgroundColor(context.getResources().getColor(android.R.color.holo_orange_dark));
        }

        viewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskItemClick.onTaskItemClick(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.container)
        CardView container;
        @BindView(R.id.viewGate)
        View viewGate;
        @BindView(R.id.chartView)
        FitChart chartView;
        @BindView(R.id.txtCustName)
        TextView txtCustName;
        @BindView(R.id.txtOrderNum)
        TextView txtOrderNum;
        @BindView(R.id.txtDescription)
        TextView txtDescription;
        @BindView(R.id.txtDate)
        TextView txtDate;
        @BindView(R.id.txtLocation)
        TextView txtLocation;
        @BindView(R.id.imgAlert)
        AppCompatImageView imgAlert;
        @BindView(R.id.imgAction)
        AppCompatImageView imgAction;

        public MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnTaskItemClick {
        void onTaskItemClick(Task task);
    }
}
