package org.iot.ex0830_ex1206_p474_simple_diary_using_db;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
   MyDBHelper myDBHelper;
   SQLiteDatabase sqlDB;
   DatePicker dp;
   EditText edtDiary;
   Button btnWrite;
   String todayDate;
   Boolean isEdit = false;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      setTitle("간단 일기장 - DB");

      dp = (DatePicker) findViewById(R.id.dp);
      edtDiary = (EditText) findViewById(R.id.edtDiary);
      btnWrite = (Button) findViewById(R.id.btnWrite);

      Calendar cal = Calendar.getInstance();
      int cYear = cal.get(Calendar.YEAR);
      int cMonth = cal.get(Calendar.MONTH);
      int cDay = cal.get(Calendar.DAY_OF_MONTH);
      todayDate = Integer.toString(cYear) + "-"
              + Integer.toString(cMonth + 1) + "-"
              + Integer.toString(cDay);
      // for debug
      System.out.println("init : " + todayDate);

      // for DB
      myDBHelper = new MyDBHelper(this);
      // DB read
      sqlDB = myDBHelper.getReadableDatabase();
      Cursor cursor;
      cursor = sqlDB.rawQuery("SELECT * FROM myDiary WHERE diaryDate = '" + todayDate + "';", null);

      String strDiary = "";
      if (cursor.moveToNext()) {
         strDiary = cursor.getString(1);
         btnWrite.setEnabled(true);
         edtDiary.setText(strDiary);
         btnWrite.setText("수정하기");
         isEdit = true;
      } else {
         edtDiary.setText("");
         btnWrite.setText("작성하기");
         isEdit = false;
      }


      dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
         @Override
         public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            todayDate = Integer.toString(year) + "-"
                    + Integer.toString(monthOfYear + 1) + "-"
                    + Integer.toString(dayOfMonth);
            // for debug
            System.out.println("changed : " + todayDate);

            // DB read
            sqlDB = myDBHelper.getReadableDatabase();
            Cursor cursor;
            cursor = sqlDB.rawQuery("SELECT * FROM myDiary WHERE diaryDate = '" + todayDate + "';", null);

            String strDiary = "";
            if (cursor.moveToNext()) {
               strDiary = cursor.getString(1);
               btnWrite.setEnabled(true);
               edtDiary.setText(strDiary);
               btnWrite.setText("수정하기");
               isEdit = true;
            } else {
               edtDiary.setText("");
               btnWrite.setText("작성하기");
               isEdit = false;
            }
         }
      });

      btnWrite.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            sqlDB = myDBHelper.getWritableDatabase();
            if (isEdit) {
               sqlDB.execSQL("UPDATE myDiary SET content = '" + edtDiary.getText().toString() + "' WHERE diaryDate = '" + todayDate + "';");
               sqlDB.close();
               Toast.makeText(getApplicationContext(), "수정됨", 0).show();
            } else {
               sqlDB.execSQL("INSERT INTO myDiary (diaryDate, content) VALUES ('" + todayDate + "', '" + edtDiary.getText().toString() + "');");
               sqlDB.close();
               Toast.makeText(getApplicationContext(), "작성됨", 0).show();
            }
         }
      });
   }

   public class MyDBHelper extends SQLiteOpenHelper {
      public MyDBHelper(Context context) {
         super(context, "myDB", null, 1);
      }

      @Override
      public void onCreate(SQLiteDatabase db) {
         db.execSQL("CREATE TABLE myDiary IF EXISTS (diaryDate CHAR(10), content varCHAR(500));");
      }

      @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("DROP TABLE IF EXISTS myDiary");
      }
   }
}