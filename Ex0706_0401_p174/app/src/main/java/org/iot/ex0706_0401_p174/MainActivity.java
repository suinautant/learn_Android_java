package org.iot.ex0706_0401_p174;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   Button btnCheck, btnPlus, btnMinus, btnDivide, btnMultiply, btnMod;
   EditText edit01, edit02;
   TextView resultView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      getSupportActionBar().setDisplayShowHomeEnabled(true);
      getSupportActionBar().setIcon(R.drawable.logo);
      setTitle("초간단 계산기");

      btnCheck = (Button) findViewById(R.id.btnCheck);
      btnPlus = (Button) findViewById(R.id.btnPlus);
      btnMinus = (Button) findViewById(R.id.btnMinus);
      btnDivide = (Button) findViewById(R.id.btnDivide);
      btnMultiply = (Button) findViewById(R.id.btnMultiply);
      btnMod = (Button) findViewById(R.id.btnMod);
      edit01 = (EditText) findViewById(R.id.edit01);
      edit02 = (EditText) findViewById(R.id.edit02);
      resultView = (TextView) findViewById(R.id.resultView);

      Context toastContext = getApplicationContext();
      String errNotInput = "입력값이 비었습니다.";
      String errNotZero = "0을 나눌 수 없습니다.";

      Toast.makeText(getApplicationContext(),"앱을 시작합니다", Toast.LENGTH_SHORT).show();

      btnCheck.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {
            String num01 = edit01.getText().toString();
            String num02 = edit02.getText().toString();

            Toast.makeText(getApplicationContext(), "쳌쳌쳌쳌", Toast.LENGTH_SHORT);

            if (num01.trim().equals("") || num02.trim().equals("")) {
               Toast.makeText(getApplicationContext(), errNotInput, Toast.LENGTH_SHORT);
               resultView.setText("오류");
            } else {
               resultView.setText("[" + num01 + " , " + num02 + "]");
            }
         }
      });

      btnPlus.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {
            String num01 = edit01.getText().toString();
            String num02 = edit02.getText().toString();

            if (num01.trim().equals("") || num02.trim().equals("")) {
               Toast.makeText(toastContext, errNotInput, Toast.LENGTH_SHORT);
               resultView.setText("더하기 오류");
            } else {
               Integer result = Integer.parseInt(num01) + Integer.parseInt(num02);
               resultView.setText(num01 + " + " + num02 + " = " + result.toString());
            }

         }
      });
      btnMinus.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {
            String num01 = edit01.getText().toString();
            String num02 = edit02.getText().toString();

            if (num01.trim().equals("") || num02.trim().equals("")) {
               Toast.makeText(toastContext, errNotInput, Toast.LENGTH_SHORT);
               resultView.setText("빼기 오류");
            } else {
               Integer result = Integer.parseInt(num01) - Integer.parseInt(num02);
               resultView.setText(num01 + " - " + num02 + " = " + result.toString());
            }
         }
      });

      btnMultiply.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {
            String num01 = edit01.getText().toString();
            String num02 = edit02.getText().toString();

            if (num01.trim().equals("") || num02.trim().equals("")) {
               Toast.makeText(toastContext, errNotInput, Toast.LENGTH_SHORT);
               resultView.setText("곱하기 오류");
            } else {
               Integer result = Integer.parseInt(num01) * Integer.parseInt(num02);
               resultView.setText(num01 + " * " + num02 + " = " + result.toString());
            }
         }
      });

      btnDivide.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {
            String num01 = edit01.getText().toString();
            String num02 = edit02.getText().toString();

            if (num01.trim().equals("") || num02.trim().equals("")) {
               Toast.makeText(toastContext, errNotInput, Toast.LENGTH_SHORT);
               resultView.setText("나누기 오류");
            } else {
               if (num02.trim().equals("0")) {
                  Toast.makeText(toastContext, errNotZero, Toast.LENGTH_SHORT);
                  resultView.setText("0으로 나누기 오류");
               } else {
                  Double result = Double.parseDouble(num01) / Double.parseDouble(num02);
                  resultView.setText(num01 + " / " + num02 + " = " + result.toString());
               }
            }
         }
      });

      btnMod.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {
            String num01 = edit01.getText().toString();
            String num02 = edit02.getText().toString();

            if (num01.trim().equals("") || num02.trim().equals("")) {
               Toast.makeText(toastContext, errNotInput, Toast.LENGTH_SHORT);
               resultView.setText("나머지 오류");
            } else {
               if (num02.trim().equals("0")) {
                  Toast.makeText(toastContext, errNotZero, Toast.LENGTH_SHORT);
                  resultView.setText("0으로 나머지 오류");
               } else {
                  Integer result = Integer.parseInt(num01) % Integer.parseInt(num02);
                  resultView.setText(num01 + " % " + num02 + " = " + result.toString());
               }
            }
         }
      });

   }
}