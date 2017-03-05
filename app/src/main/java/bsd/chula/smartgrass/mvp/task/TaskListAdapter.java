package bsd.chula.smartgrass.mvp.task;


import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.txusballesteros.widgets.FitChart;
import com.txusballesteros.widgets.FitChartValue;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.data.model.Order;
import bsd.chula.smartgrass.data.model.Work;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dev_Tee on 2/4/17.
 */

public class TaskListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Work> workList;
    private OnTaskItemClick taskItemClick;

    public TaskListAdapter(Context context, OnTaskItemClick taskItemClick) {
        this.context = context;

        workList = new ArrayList<>();
        this.taskItemClick = taskItemClick;
    }

    public void appendItems(List<Work> works) {
        this.workList.addAll(works);
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
        final Work item = workList.get(position);

        viewHolder.txtCustName.setText(item.getCustomerName());
        viewHolder.txtDescription.setText(item.getArtificialGrassCatagoryName());

        viewHolder.txtOrderNum.setText("Order 0" + item.getWorkID());

        viewHolder.chartView.setMinValue(0f);
        viewHolder.chartView.setMaxValue(100f);

        onSetGateStatus(item, viewHolder);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date(System.currentTimeMillis());

        try {
            Date dateFormated = dateFormat.parse(date.toString());
            String dateStr = dateFormated.toString();

            viewHolder.txtDate.setText(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        viewHolder.txtStatus.setText(item.getWorkStatusName());

        viewHolder.layoutContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskItemClick.onTaskItemClick(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return workList.size();
    }

    private void onSetGateStatus(final Work work, MainViewHolder viewHolder) {

        if (work.getWorkStatusID().equalsIgnoreCase("01")) {

            viewHolder.viewGate.setBackgroundColor(context.getResources().getColor(R.color.colorStatus1));
            viewHolder.imgAlert.setColorFilter(context.getResources().getColor(R.color.colorStatus1),
                    PorterDuff.Mode.SRC_IN);
            viewHolder.imgAction.setColorFilter(context.getResources().getColor(R.color.colorStatus1),
                    PorterDuff.Mode.SRC_IN);

            Collection<FitChartValue> values = new ArrayList<>();
            values.add(new FitChartValue(20f, context.getResources().getColor(R.color.colorStatus1)));

            viewHolder.chartView.setValues(values);

        } else if (work.getWorkStatusID().equalsIgnoreCase("02")) {

            viewHolder.viewGate.setBackgroundColor(context.getResources().getColor(R.color.colorStatus2));
            viewHolder.imgAlert.setColorFilter(context.getResources().getColor(R.color.colorStatus2),
                    PorterDuff.Mode.SRC_IN);
            viewHolder.imgAction.setColorFilter(context.getResources().getColor(R.color.colorStatus2),
                    PorterDuff.Mode.SRC_IN);

            Collection<FitChartValue> values = new ArrayList<>();
            values.add(new FitChartValue(40f, context.getResources().getColor(R.color.colorStatus2)));

            viewHolder.chartView.setValues(values);

        } else if (work.getWorkStatusID().equalsIgnoreCase("03")) {

            viewHolder.viewGate.setBackgroundColor(context.getResources().getColor(R.color.colorStatus3));
            viewHolder.imgAlert.setColorFilter(context.getResources().getColor(R.color.colorStatus3),
                    PorterDuff.Mode.SRC_IN);
            viewHolder.imgAction.setColorFilter(context.getResources().getColor(R.color.colorStatus3),
                    PorterDuff.Mode.SRC_IN);

            Collection<FitChartValue> values = new ArrayList<>();
            values.add(new FitChartValue(60f, context.getResources().getColor(R.color.colorStatus3)));

            viewHolder.chartView.setValues(values);

        } else if (work.getWorkStatusID().equalsIgnoreCase("04")) {

            viewHolder.viewGate.setBackgroundColor(context.getResources().getColor(R.color.colorStatus4));
            viewHolder.imgAlert.setColorFilter(context.getResources().getColor(R.color.colorStatus4),
                    PorterDuff.Mode.SRC_IN);
            viewHolder.imgAction.setColorFilter(context.getResources().getColor(R.color.colorStatus4),
                    PorterDuff.Mode.SRC_IN);

            Collection<FitChartValue> values = new ArrayList<>();
            values.add(new FitChartValue(80f, context.getResources().getColor(R.color.colorStatus4)));

            viewHolder.chartView.setValues(values);


        } else if (work.getWorkStatusID().equalsIgnoreCase("05")) {

            viewHolder.viewGate.setBackgroundColor(context.getResources().getColor(R.color.colorStatus5));
            viewHolder.imgAlert.setColorFilter(context.getResources().getColor(R.color.colorStatus5),
                    PorterDuff.Mode.SRC_IN);
            viewHolder.imgAction.setColorFilter(context.getResources().getColor(R.color.colorStatus5),
                    PorterDuff.Mode.SRC_IN);

            Collection<FitChartValue> values = new ArrayList<>();
            values.add(new FitChartValue(100f, context.getResources().getColor(R.color.colorStatus5)));

            viewHolder.chartView.setValues(values);

        } else {

            viewHolder.viewGate.setBackgroundColor(context.getResources().getColor(android.R.color.white));
            viewHolder.imgAlert.clearColorFilter();
            viewHolder.imgAction.clearColorFilter();
            viewHolder.chartView.setValue(0);
        }

    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

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
        @BindView(R.id.txtDueDate)
        TextView txtDueDate;
        @BindView(R.id.imgAction)
        AppCompatImageView imgAction;
        @BindView(R.id.txtStatus)
        TextView txtStatus;
        @BindView(R.id.layoutContainer)
        CardView layoutContainer;
        @BindView(R.id.btnDueDate)
        LinearLayout btnDueDate;
        @BindView(R.id.btnAction)
        LinearLayout btnAction;

        public MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnTaskItemClick {
        void onTaskItemClick(Work work);
    }
}
