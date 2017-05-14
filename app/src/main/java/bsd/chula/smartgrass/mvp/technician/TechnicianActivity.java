package bsd.chula.smartgrass.mvp.technician;

import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;

import com.alamkanak.weekview.DateTimeInterpreter;
import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.api.model.Schedule;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dev_Tee on 5/13/17.
 */

public class TechnicianActivity extends AppCompatActivity implements TechnicianContract.TechnicianView,
        MonthLoader.MonthChangeListener, WeekView.EventClickListener, WeekView.EventLongPressListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.weekView)
    WeekView mWeekView;

    private static final int TYPE_DAY_VIEW = 1;
    private static final int TYPE_THREE_DAY_VIEW = 2;
    private static final int TYPE_WEEK_VIEW = 3;
    private int mWeekViewType = TYPE_THREE_DAY_VIEW;

    private TechnicianPresenter mPresenter;
    private Map<String, Schedule> mCacheMap = new HashMap<>();
    private List<Schedule> mSchedules = new ArrayList<>();
    private List<WeekViewEvent> mEvents = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technician);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mWeekView.setMonthChangeListener(this);
        mWeekView.setOnEventClickListener(this);
        mWeekView.setEventLongPressListener(this);

        mPresenter = new TechnicianPresenter(this);

        mPresenter.loadScheduleList();
    }

    @Override
    public void onShowScheduleList(List<Schedule> scheduleList) {
        mSchedules = scheduleList;

        for (Schedule schedule : scheduleList) {
            mEvents.add(createWeekViewEvent(schedule));
            mCacheMap.put(schedule.getScheduleID(), schedule);
        }

        mWeekView.notifyDatasetChanged();
    }

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {

        List<WeekViewEvent> matchedEvents = new ArrayList<>();

        for (WeekViewEvent event : mEvents) {
            if (eventMatches(event, newYear, newMonth)) {
                matchedEvents.add(event);
            }
        }

        return matchedEvents;
    }

    @Override
    public void onEventClick(WeekViewEvent event, RectF eventRect) {

        Schedule result;

        result = CollectionUtil.find(mSchedules,
                item -> item.getScheduleID().contains(String.valueOf(event.getId())));

        Intent intent = new Intent(this, TechnicianDetailsActivity.class);
        intent.putExtra(TechnicianDetailsActivity.EXTRA_WORK_ID, result.getWorkID());
        startActivity(intent);
    }

    @Override
    public void onEventLongPress(WeekViewEvent event, RectF eventRect) {

    }


    @Override
    public void onShowErrorDialog(String msg) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.technician, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        setupDateTimeInterpreter(id == R.id.action_week_view);
        switch (id) {
            case R.id.action_today:
                mWeekView.goToToday();
                return true;
            case R.id.action_day_view:
                if (mWeekViewType != TYPE_DAY_VIEW) {
                    item.setChecked(!item.isChecked());
                    mWeekViewType = TYPE_DAY_VIEW;
                    mWeekView.setNumberOfVisibleDays(1);

                    // Lets change some dimensions to best fit the view.
                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()));
                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                }
                return true;
            case R.id.action_three_day_view:
                if (mWeekViewType != TYPE_THREE_DAY_VIEW) {
                    item.setChecked(!item.isChecked());
                    mWeekViewType = TYPE_THREE_DAY_VIEW;
                    mWeekView.setNumberOfVisibleDays(3);

                    // Lets change some dimensions to best fit the view.
                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()));
                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                }
                return true;
            case R.id.action_week_view:
                if (mWeekViewType != TYPE_WEEK_VIEW) {
                    item.setChecked(!item.isChecked());
                    mWeekViewType = TYPE_WEEK_VIEW;
                    mWeekView.setNumberOfVisibleDays(7);

                    // Lets change some dimensions to best fit the view.
                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private WeekViewEvent createWeekViewEvent(Schedule schedule) {

        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        try {

            startDate.setTime(simpleTimeFormat.parse(schedule.getDate() + " "
                    + schedule.getStartTime()));
            endDate.setTime(simpleTimeFormat.parse(schedule.getDate() + " "
                    + schedule.getEndTime()));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        WeekViewEvent event = new WeekViewEvent();
        event.setId(Long.valueOf(schedule.getScheduleID()));
        event.setName(getEventTitle(schedule));
        event.setStartTime(startDate);
        event.setEndTime(endDate);

        switch (schedule.getScheduleCategoryID()) {
            case "1":
                event.setColor(getResources().getColor(R.color.colorStatus1));
                break;

            case "2":
                event.setColor(getResources().getColor(R.color.colorStatus2));
                break;

            case "3":
                event.setColor(getResources().getColor(R.color.colorStatus3));
                break;
        }

        return event;
    }

    private boolean eventMatches(WeekViewEvent event, int year, int month) {
        return (event.getStartTime().get(Calendar.YEAR) == year &&
                event.getStartTime().get(Calendar.MONTH) == month - 1) ||
                (event.getEndTime().get(Calendar.YEAR) == year &&
                        event.getEndTime().get(Calendar.MONTH) == month - 1);
    }

    private String getEventTitle(Schedule schedule) {
        return String.format("Schedule of " + schedule.getDetail() +
                " for " + schedule.getScheduleCategoryName());
    }

    private void setupDateTimeInterpreter(final boolean shortDate) {
        mWeekView.setDateTimeInterpreter(new DateTimeInterpreter() {
            @Override
            public String interpretDate(Calendar date) {
                SimpleDateFormat weekdayNameFormat = new SimpleDateFormat("EEE", Locale.getDefault());
                String weekday = weekdayNameFormat.format(date.getTime());
                SimpleDateFormat format = new SimpleDateFormat(" M/d", Locale.getDefault());

                if (shortDate)
                    weekday = String.valueOf(weekday.charAt(0));
                return weekday.toUpperCase() + format.format(date.getTime());
            }

            @Override
            public String interpretTime(int hour) {
                return hour > 11 ? (hour - 12) + " PM" : (hour == 0 ? "12 AM" : hour + " AM");
            }
        });
    }

    interface Predicate<T>{
        boolean contains(T item);
    }

    static class CollectionUtil{

        public static <T> T find(final Collection<T> collection, final  Predicate<T> predicate){
            for (T item : collection){
                if (predicate.contains(item)){
                    return item;
                }
            }
            return null;
        }
    }
}
