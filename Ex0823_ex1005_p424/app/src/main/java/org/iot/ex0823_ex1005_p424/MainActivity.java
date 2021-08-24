package org.iot.ex0823_ex1005_p424;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
   Button btnOpenWindow;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      setTitle("첫번째 액티비티");

      btnOpenWindow = (Button) findViewById(R.id.btnOpenWindow);

      btnOpenWindow.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent intent = new Intent();
            intent = new Intent(getApplicationContext(), SecondActivity.class);
            startActivity(intent);
         }
      });
   }
}