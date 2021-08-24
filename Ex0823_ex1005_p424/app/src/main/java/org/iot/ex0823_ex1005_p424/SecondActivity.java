package org.iot.ex0823_ex1005_p424;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
   Button btnReturn;
   Button btnNewWindow;

   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.second);
      setTitle("두번째 액티비티");

      btnNewWindow = (Button) findViewById(R.id.btnNewWindow);
      btnNewWindow.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent intent = new Intent();
            intent = new Intent(getApplicationContext(), ThirdActivity.class);
            startActivity(intent);
         }
      });

      btnReturn = (Button) findViewById(R.id.btnReturn);
      btnReturn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            finish();
         }
      });
   }
}
