package org.iot.ex0823_p409_2way_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
   int result;
   String calc;

   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.second);
      setTitle("세컨드 액티비티");

      Intent inIntent = getIntent();
      int menu = inIntent.getIntExtra("Menu", 9);
      int num1 = inIntent.getIntExtra("Num1", 0);
      int num2 = inIntent.getIntExtra("Num2", 0);
      calc = "";
      switch (menu) {
         case 0:
            result = num1 + num2;
            calc="더하기";
            System.out.println("num1 + num2 : " + result);
            break;
         case 1:
            result = num1 - num2;
            calc="빼기";
            System.out.println("num1 - num2 : " + result);
            break;
         case 2:
            result = num1 * num2;
            calc="곱하기";
            System.out.println("num1 * num2 : " + result);
            break;
         case 3:
            result = num1 / num2;
            System.out.println("num1 / num2 : " + result);
            calc="나누기";
            break;
      }

      Button btnReturn = (Button) findViewById(R.id.btnReturn);
      btnReturn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
            outIntent.putExtra("Result", result);
            outIntent.putExtra("Calc", calc);
            setResult(RESULT_OK, outIntent);
            finish();
         }
      });
   }
}
