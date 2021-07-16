package org.iot.ex0713_0514_p225_simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   EditText edit1, edit2;
   Button btnAdd, btnSub, btnMul, btnDiv;
   TextView textResult;
   String num1, num2;
   Integer result;
   Button[] numButtons = new Button[10];
   Integer[] numBtnIDs = {
           R.id.btn0, R.id.btn1, R.id.btn2,
           R.id.btn3, R.id.btn4, R.id.btn5,
           R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
   };
   int i;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      setTitle("테이블 레이아웃 계산기");

      edit1 = (EditText) findViewById(R.id.edit1);
      edit2 = (EditText) findViewById(R.id.edit2);
      btnAdd = (Button) findViewById(R.id.btnPlus);
      btnSub = (Button) findViewById(R.id.btnMinus);
      btnMul = (Button) findViewById(R.id.btnMultipl);
      btnDiv = (Button) findViewById(R.id.btnDivide);
      textResult = (TextView) findViewById(R.id.tvResult);

      btnAdd.setOnTouchListener(new View.OnTouchListener() {
         public boolean onTouch(View v, MotionEvent event) {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) + Integer.parseInt(num2);
            textResult.setText("게산 결과 : " + result.toString());
            return false;
         }
      });

      btnSub.setOnTouchListener(new View.OnTouchListener() {
         public boolean onTouch(View v, MotionEvent event) {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) - Integer.parseInt(num2);
            textResult.setText("게산 결과 : " + result.toString());
            return false;
         }
      });

      btnMul.setOnTouchListener(new View.OnTouchListener() {
         public boolean onTouch(View v, MotionEvent event) {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) * Integer.parseInt(num2);
            textResult.setText("게산 결과 : " + result.toString());
            return false;
         }
      });

      btnDiv.setOnTouchListener(new View.OnTouchListener() {
         public boolean onTouch(View v, MotionEvent event) {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            if (Integer.parseInt(num2) != 0) {
               result = Integer.parseInt(num1) / Integer.parseInt(num2);
               textResult.setText("게산 결과 : " + result.toString());
            } else {
               Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
            }
            return false;
         }
      });

      for (i = 0; i < numBtnIDs.length; i++) {
         numButtons[i] = (Button) findViewById(numBtnIDs[i]);
      }

      for (i = 0; i < numBtnIDs.length; i++) {
         final int index;
         index = i;

         numButtons[index].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if (edit1.isFocused() == true) {
                  if (num1.charAt(0) == 0) {
                     if (numButtons[index].getText().toString().equals("0")) {
                        num1 = "0";
                     } else {
                        num1 = numButtons[index].getText().toString();
                        edit1.setText(num1);
                     }
                  } else {
                     num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                     edit1.setText(num1);
                  }
               } else if (edit2.isFocused() == true) {
                  num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                  edit2.setText(num2);
               } else {
                  Toast.makeText(getApplicationContext(), "먼저 에디터를 선택하세요", Toast.LENGTH_SHORT).show();
               }
            }
         });
      }


   }
}