package org.iot.ex0705_01;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
   Button btn;
   CheckBox checkBox;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      Context context = getApplicationContext();
      CharSequence textBtn = "버튼 눌러짐";
      CharSequence textCheckBox = "체크!! 체크 박스";
      int duration = Toast.LENGTH_SHORT;

      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      btn = (Button) findViewById(R.id.btn);
      btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(context, textBtn, duration).show();
         }
      });

      checkBox = (CheckBox) findViewById(R.id.checkBox);
      checkBox.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(context, textCheckBox, duration).show();
         }
      });
   }


}