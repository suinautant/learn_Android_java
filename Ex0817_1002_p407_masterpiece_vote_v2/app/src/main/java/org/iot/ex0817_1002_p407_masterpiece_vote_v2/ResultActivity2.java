package org.iot.ex0817_1002_p407_masterpiece_vote_v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


public class ResultActivity2 extends Activity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.result2);
      setTitle("투표 결과2");

      Intent intent = getIntent();
      int[] voteResult = intent.getIntArrayExtra("VoteCount");
      String[] imageName = intent.getStringArrayExtra("ImageName");

      TextView tv[] = new TextView[imageName.length];
      RatingBar rbar[] = new RatingBar[imageName.length];
      ImageView images[] = new ImageView[imageName.length];

      Integer tvId[] = {
              R.id.tv1,
              R.id.tv2,
              R.id.tv3,
              R.id.tv4,
              R.id.tv5,
              R.id.tv6,
              R.id.tv7,
              R.id.tv8,
              R.id.tv9
      };
      Integer rbarId[] = {
              R.id.rbar1,
              R.id.rbar2,
              R.id.rbar3,
              R.id.rbar4,
              R.id.rbar5,
              R.id.rbar6,
              R.id.rbar7,
              R.id.rbar8,
              R.id.rbar9
      };
      Integer imageFileId[] = {
              R.drawable.suyangha01,
              R.drawable.suyangha02,
              R.drawable.suyangha03,
              R.drawable.suyangha04,
              R.drawable.suyangha05,
              R.drawable.suyangha06,
              R.drawable.suyangha07,
              R.drawable.suyangha08,
              R.drawable.suyangha09,
      };

      for (int i = 0; i < voteResult.length; i++) {
         tv[i] = (TextView) findViewById(tvId[i]);
         rbar[i] = (RatingBar) findViewById(rbarId[i]);
         images[i] = (ImageView) findViewById(imageFileId[i]);
      }

      int max = voteResult[0];
//      int imgMax = imageFileId[0];
      int idxMax = 0;
      for (int i = 0; i < voteResult.length; i++) {
         tv[i].setText(imageName[i]);
         rbar[i].setRating((float) voteResult[i]);
         // 최다 득표
         if (max < voteResult[i]) {
            max = voteResult[i];
//            imgMax = imageFileId[i];
            idxMax = i;
         }
      }

      ImageView imageView = (ImageView) findViewById(R.id.ivImage);

//      imageView.setImageResource(imgMax);
      imageView.setImageResource(imageFileId[idxMax]);
      TextView tvImageName = (TextView) findViewById(R.id.tvImageName);
      tvImageName.setText(imageName[idxMax]);

      Button btnReturn = (Button) findViewById(R.id.btnReturn);
      btnReturn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            finish();
         }
      });


   }
}
