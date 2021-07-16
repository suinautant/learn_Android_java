package org.iot.ex0712_ch04_excise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
   CheckBox chkEnable;
   CheckBox chkClick;
   CheckBox chkRotate;
   Button btn;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      chkEnable = (CheckBox) findViewById(R.id.chkEnable);
      chkClick = (CheckBox) findViewById(R.id.chkClick);
      chkRotate = (CheckBox) findViewById(R.id.chkRotate);
      btn = (Button) findViewById(R.id.btn);

      chkEnable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
               btn.setEnabled(true);
            } else {
               btn.setEnabled(false);
            }
         }
      });

      chkClick.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
               btn.setClickable(true);
            } else {
               btn.setClickable(false);
            }
         }
      });

      chkRotate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
               btn.setRotation(45);
            } else {
               btn.setRotation(0);
            }
         }
      });


   }
}