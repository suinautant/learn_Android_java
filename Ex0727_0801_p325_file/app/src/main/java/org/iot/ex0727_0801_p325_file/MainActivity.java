package org.iot.ex0727_0801_p325_file;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      Button btnRead, btnWrite;
      btnRead = (Button) findViewById(R.id.btnRead);
      btnWrite = (Button) findViewById(R.id.btnWrite);

      btnWrite.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            try {
               FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE);
               String str = "쿡북 안드로이드";
               outFs.write(str.getBytes());
               outFs.close();
               Toast.makeText(getApplicationContext(), "file.txt가 생성됨", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
               System.out.println("IOException : " + e.getMessage());
            }
         }
      });

      btnRead.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            try {
               FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE);
               String str = "쿡북 안드로이드";
               outFs.write(str.getBytes());
               outFs.close();
               Toast.makeText(getApplicationContext(), "file.txt가 생성됨", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
               System.out.println("IOException : " + e.getMessage());
            }
         }
      });
   }
}