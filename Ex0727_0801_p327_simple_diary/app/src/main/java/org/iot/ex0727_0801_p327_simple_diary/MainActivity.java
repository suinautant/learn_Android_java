package org.iot.ex0727_0801_p327_simple_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
   DatePicker dp;
   EditText edtDiary;
   Button btnWrite;
   String fileName;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      setTitle("간단 일기장");

      dp = (DatePicker) findViewById(R.id.dp);
      edtDiary = (EditText) findViewById(R.id.edtDiary);
      btnWrite = (Button) findViewById(R.id.btnWrite);

      Calendar cal = Calendar.getInstance();
      int cYear = cal.get(Calendar.YEAR);
      int cMonth = cal.get(Calendar.MONTH);
      int cDay = cal.get(Calendar.DAY_OF_MONTH);

      dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
         @Override
         public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            fileName = Integer.toString(year) + "_"
                    + Integer.toString(monthOfYear + 1) + "_"
                    + Integer.toString(dayOfMonth) + ".txt";
            String str = readDiary(fileName);
            edtDiary.setText(str);
            btnWrite.setEnabled(true);
         }
      });

      btnWrite.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            try {
               FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
               String str = edtDiary.getText().toString();
               fos.write(str.getBytes());
               fos.close();
               Toast.makeText(getApplicationContext(), fileName + " 이 저장됨", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
               System.out.println("IOException : " + e.getMessage());
            }
         }
      });
   }

   String readDiary(String fName) {
      String diaryStr = null;
      FileInputStream fis;
      try {
         fis = openFileInput(fName);
         byte[] txt = new byte[50];
         fis.read(txt);
         fis.close();
         diaryStr = (new String(txt)).trim();
         btnWrite.setText("수정하기");
      } catch (Exception e) {
         System.out.println("Exception : " + e.getMessage());
         edtDiary.setHint("일기 없음");
         btnWrite.setText("새로 저장");
      }
      return diaryStr;
   }


}