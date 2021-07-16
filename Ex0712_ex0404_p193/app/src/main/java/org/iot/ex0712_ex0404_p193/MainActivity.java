package org.iot.ex0712_ex0404_p193;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   TextView text1;
   TextView text2;
   RadioGroup rGroup1;
   RadioButton rdoDog;
   RadioButton rdoCat;
   RadioButton rdoRabbit;
   Button btnExit;
   Button btnFirst;
   ImageView imgPet;
   Switch swAgree;


   Context toastContext;
   String toastMsg;
   Integer toastShort;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      getSupportActionBar().setDisplayShowHomeEnabled(true);
      getSupportActionBar().setIcon(R.drawable.logo);
      setTitle("안드로이드 사진 보기");

      toastContext = getApplicationContext();
      toastMsg = "동물 먼저 선택하세요";
      toastShort = Toast.LENGTH_SHORT;

      text1 = (TextView) findViewById(R.id.text1);
      text2 = (TextView) findViewById(R.id.text2);
      rGroup1 = (RadioGroup) findViewById(R.id.rGroup1);
      rdoDog = (RadioButton) findViewById(R.id.rdoDog);
      rdoCat = (RadioButton) findViewById(R.id.rdoCat);
      rdoRabbit = (RadioButton) findViewById(R.id.rdoRabbit);
      btnExit = (Button) findViewById(R.id.btnExit);
      btnFirst = (Button) findViewById(R.id.btnFirst);
      imgPet = (ImageView) findViewById(R.id.imgPet);
      swAgree = (Switch) findViewById(R.id.swAgree);

      swAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked == true) {
               text2.setVisibility(View.VISIBLE);
               rGroup1.setVisibility(View.VISIBLE);
               imgPet.setVisibility(View.VISIBLE);
            } else {
               text2.setVisibility(View.INVISIBLE);
               rGroup1.setVisibility(View.INVISIBLE);
               imgPet.setVisibility(View.INVISIBLE);
            }

         }
      });

      rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
               case R.id.rdoDog:
                  imgPet.setImageResource(R.drawable.q);
                  break;
               case R.id.rdoCat:
                  imgPet.setImageResource(R.drawable.p);
                  break;
               case R.id.rdoRabbit:
                  imgPet.setImageResource(R.drawable.r);
                  break;
               default:
                  Toast.makeText(toastContext, toastMsg, toastShort).show();
            }

         }
      });

      btnFirst.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            swAgree.setChecked(false);
         }
      });

      btnExit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            finish();
         }
      });


   }
}