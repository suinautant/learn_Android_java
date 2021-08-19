package org.iot.ex0817_1006_p425_masterpiece_vote_v3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class ResultActivity extends Activity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.result);
      setTitle("투표 결과");

      Intent intent = getIntent();
      int[] voteResult = intent.getIntArrayExtra("VoteCount");
      String[] imageName = intent.getStringArrayExtra("ImageName");
      int[] indexes = {0, 1, 2, 3, 4, 5, 6, 7, 8};
      ImageView iv[] = new ImageView[imageName.length];
      ViewFlipper vf = (ViewFlipper) findViewById(R.id.vf);
      Button btnStart = (Button) findViewById(R.id.btnStart);
      Button btnStop = (Button) findViewById(R.id.btnStop);

      Integer ivId[] = {
              R.id.iv1,
              R.id.iv2,
              R.id.iv3,
              R.id.iv4,
              R.id.iv5,
              R.id.iv6,
              R.id.iv7,
              R.id.iv8,
              R.id.iv9
      };

      Integer ivPath[] = {
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
         iv[i] = (ImageView) findViewById(ivId[i]);
      }

      // voteResult 내림 차순 정렬
      // ImageView에 정렬한 따른 이미지 표시하기 위한 indexes 배열도 같은 index로 정렬
      for (int i = 0; i <voteResult.length; i++) {
         int max = voteResult[i];
         int idx = i;
         for (int j = i + 1; j < voteResult.length; j++) {
            if (max < voteResult[j]) {
               max = voteResult[j];
               idx = j;
            }
         }
         int tmp = voteResult[i];
         voteResult[i] = voteResult[idx];
         voteResult[idx] = tmp;

         tmp = indexes[i];
         indexes[i] = indexes[idx];
         indexes[idx] = tmp;
      }

      for (int i = 0; i < indexes.length; i++) {
         iv[i].setImageResource(ivPath[indexes[i]]);
      }

      // 버튼 클릭 이벤트
      btnStart.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            vf.setFlipInterval(1000);
            vf.startFlipping();
         }
      });
      // 버튼 클릭 이벤트
      btnStop.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            vf.stopFlipping();
         }
      });


   }
}
