package hemiy.qinghui.com.mytestdemo.times;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * https://github.com/square/android-times-square
 * 一款时间日期的选择控件
 * Created by hemiy on 16/6/10.
 */
public class TimeActivity extends Activity {
    @BindView(R.id.calendar_view)
    CalendarPickerView calendarView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times);
        ButterKnife.bind(this);
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        Date today = new Date();
        calendarView.init(today, nextYear.getTime()).withSelectedDate(today);
        Log.i("hemiy","选择的时间是"+calendarView.getSelectedDate());


    }
}
