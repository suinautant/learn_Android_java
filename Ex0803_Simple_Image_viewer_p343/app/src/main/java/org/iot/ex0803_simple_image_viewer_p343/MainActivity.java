package org.iot.ex0803_simple_image_viewer_p343;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
   Button btnPrev, btnNext;
   MyPictureView myPicture;
   int curNum = 1;
   File[] imageFiles;
   String imageFname;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      setTitle("간단 이미지 뷰어");
      ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
      btnPrev = (Button) findViewById(R.id.btnPrev);
      btnNext = (Button) findViewById(R.id.btnNext);
      myPicture = (MyPictureView) findViewById(R.id.myPictureView1);

      imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures").listFiles();
      imageFname = imageFiles[1].toString();
      System.out.println("Main ************************************" + imageFname);
      myPicture.imagePath = imageFname;

      btnPrev.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            if (curNum <= 1) {
               Toast.makeText(getApplicationContext(), "첫번째 그림입니다.", Toast.LENGTH_SHORT).show();
            } else {
               curNum--;
               imageFname = imageFiles[curNum].toString();
               myPicture.imagePath = imageFname;
               myPicture.invalidate();
            }
         }
      });

      btnNext.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            if (curNum >= imageFiles.length - 1) {
               Toast.makeText(getApplicationContext(), "마지막 그림입니다.", Toast.LENGTH_SHORT).show();
            } else {
               curNum++;
               imageFname = imageFiles[curNum].toString();
               myPicture.imagePath = imageFname;
               myPicture.invalidate();
            }
         }
      });

   }
}