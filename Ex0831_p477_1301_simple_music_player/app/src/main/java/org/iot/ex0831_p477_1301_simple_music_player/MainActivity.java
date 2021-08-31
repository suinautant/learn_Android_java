package org.iot.ex0831_p477_1301_simple_music_player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      final MediaPlayer mPlayer;
      mPlayer = MediaPlayer.create(this, R.raw.unavailable);

      final Switch switch1 = (Switch) findViewById(R.id.switch1);
      switch1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            if (switch1.isChecked()) {
               mPlayer.start();
               System.out.println("mplayer start");
            }
            else {
               mPlayer.stop();
               System.out.println("mplayer stop");
            }
         }
      });
   }
}