package org.iot.ex0712_ex0402_p188;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   TextView text1;
   TextView text2;
   CheckBox chkAgree;
   RadioGroup rGroup1;
   RadioButton rdoDog;
   RadioButton rdoCat;
   RadioButton rdoRabbit;
   Button btnOK;
   ImageView imgPet;

   Context toastContext;
   String toastMsg;
   Integer toastShort;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      getSupportActionBar().setDisplayShowHomeEnabled(true);
      getSupportActionBar().setIcon(R.drawable.r);
      setTitle("애완동물 사진 보기");

      toastContext = getApplicationContext();
      toastMsg = "동물 먼저 선택하세요";
      toastShort = Toast.LENGTH_SHORT;

      text1 = (TextView) findViewById(R.id.text1);
      text2 = (TextView) findViewById(R.id.text2);
      chkAgree = (CheckBox) findViewById(R.id.chkAgree);
      rGroup1 = (RadioGroup) findViewById(R.id.rGroup1);
      rdoDog = (RadioButton) findViewById(R.id.rdoDog);
      rdoCat = (RadioButton) findViewById(R.id.rdoCat);
      rdoRabbit = (RadioButton) findViewById(R.id.rdoRabbit);
      btnOK = (Button) findViewById(R.id.btnOK);
      imgPet = (ImageView) findViewById(R.id.imgPet);


      chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (chkAgree.isChecked() == true) {
               text2.setVisibility(View.VISIBLE);
               rGroup1.setVisibility(View.VISIBLE);
               btnOK.setVisibility(View.VISIBLE);
               imgPet.setVisibility(View.VISIBLE);
               Toast.makeText(toastContext, imgPet.getVisibility(), Toast.LENGTH_SHORT).show();
            } else {
               text2.setVisibility(View.INVISIBLE);
               rGroup1.setVisibility(View.INVISIBLE);
               btnOK.setVisibility(View.INVISIBLE);
               imgPet.setVisibility(View.INVISIBLE);
            }
         }
      });

      btnOK.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {
            switch (rGroup1.getCheckedRadioButtonId()) {
               case R.id.rdoDog:
                  imgPet.setImageResource(R.drawable.dog);
                  break;
               case R.id.rdoCat:
                  imgPet.setImageResource(R.drawable.cat);
                  break;
               case R.id.rdoRabbit:
                  imgPet.setImageResource(R.drawable.bunny);
                  break;
               default:
                  Toast.makeText(toastContext, toastMsg, toastShort).show();
            }

         }
      });
   }
}