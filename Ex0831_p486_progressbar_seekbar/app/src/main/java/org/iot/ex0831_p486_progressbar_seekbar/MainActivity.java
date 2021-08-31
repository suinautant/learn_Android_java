package org.iot.ex0831_p486_progressbar_seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   Button btnInc;
   Button btnDec;
   ProgressBar pb1;
   TextView tvSeek;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      pb1 = (ProgressBar) findViewById(R.id.progressBar1);
      btnInc = (Button) findViewById(R.id.btnInc);
      btnInc.setOnClickListener(this);
      btnDec = (Button) findViewById(R.id.btnDec);
      btnDec.setOnClickListener(this);

      tvSeek = (TextView) findViewById(R.id.tvSeek);
      SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBar);

      seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
         @Override
         public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            tvSeek.setText("진행률 : " + progress + " %");
         }

         @Override
         public void onStartTrackingTouch(SeekBar seekBar) {

         }

         @Override
         public void onStopTrackingTouch(SeekBar seekBar) {

         }
      });
   }

   @Override
   public void onClick(View v) {
      switch (v.getId()) {
         case R.id.btnInc:
            pb1.incrementProgressBy(10);
            break;
         case R.id.btnDec:
            pb1.incrementProgressBy(-10);
            break;
      }
   }
}