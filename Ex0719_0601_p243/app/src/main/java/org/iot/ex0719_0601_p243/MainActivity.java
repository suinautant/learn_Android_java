package org.iot.ex0719_0601_p243;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
   Chronometer chronometer1;
   Button btnStart, btnEnd;
   RadioButton rdoCal, rdoTime;
   CalendarView calView;
   TimePicker tPicker;
   TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
   int selectYear, selectMonth, selectDay;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      setTitle("시간 예약");

      btnStart = (Button) findViewById(R.id.btnStart);
      btnEnd = (Button) findViewById(R.id.btnEnd);
      chronometer1 = (Chronometer) findViewById(R.id.chronometer1);
      rdoCal = (RadioButton) findViewById(R.id.rdoCal);
      rdoTime = (RadioButton) findViewById(R.id.rdoTime);
      tPicker = (TimePicker) findViewById(R.id.timePicker1);
      tvYear = (TextView) findViewById(R.id.tvYear);
      tvMonth = (TextView) findViewById(R.id.tvMonth);
      tvDay = (TextView) findViewById(R.id.tvDay);
      tvHour = (TextView) findViewById(R.id.tvHour);
      tvMinute = (TextView) findViewById(R.id.tvMinute);
      calView = (CalendarView) findViewById(R.id.calendarView1);

      tPicker.setVisibility(View.INVISIBLE);
      calView.setVisibility(View.INVISIBLE);

      rdoCal.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            tPicker.setVisibility(View.INVISIBLE);
            calView.setVisibility(View.VISIBLE);
         }
      });
      rdoTime.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            tPicker.setVisibility(View.VISIBLE);
            calView.setVisibility(View.INVISIBLE);
         }
      });

      btnStart.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            chronometer1.setBase(SystemClock.elapsedRealtime());
            chronometer1.start();
            chronometer1.setTextColor(Color.RED);
         }
      });
      btnEnd.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            chronometer1.stop();
            chronometer1.setTextColor(Color.BLUE);

            tvYear.setText(Integer.toString(selectYear));
            tvMonth.setText(Integer.toString(selectMonth));
            tvDay.setText(Integer.toString(selectDay));
            tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
            tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
         }
      });

      calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
         @Override
         public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
            selectYear = year;
            selectMonth = month + 1;
            selectDay = dayOfMonth;
         }
      });



   }
}