package org.iot.ex0823_p409_2way_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      setTitle("양방향 엑티비티");

      Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
      btnNewActivity.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
            Integer rdoCalcId[] = {
                    R.id.rdoCalc0,
                    R.id.rdoCalc1,
                    R.id.rdoCalc2,
                    R.id.rdoCalc3
            };
            RadioButton rdoCalc[] = new RadioButton[rdoCalcId.length];
            Integer menu=9;
            for (int i = 0; i < rdoCalcId.length; i++) {
               rdoCalc[i] = (RadioButton) findViewById(rdoCalcId[i]);
               if (rdoCalc[i].isChecked()) {
                  menu = i;
               }
            }

            EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
            EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
            intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
            intent.putExtra("Menu", menu);
            startActivityForResult(intent, 0);
         }
      });
   }

   @Override
   protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
      if (resultCode == RESULT_OK) {
         int result = data.getIntExtra("Result", 0);
         String calc = data.getStringExtra("Calc");
         Toast.makeText(getApplicationContext(), calc + " 결과 : " + result, Toast.LENGTH_SHORT).show();
      }
   }
}