package org.iot.ex0803_handle_file_sdcard_p337;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
   Button btnRead, btnMkdir, btnRmdir, btnFilelist;
   EditText edtSD, edtFilelist;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      btnRead = (Button) findViewById(R.id.btnRead);
      btnMkdir = (Button) findViewById(R.id.btnMkdir);
      btnRmdir = (Button) findViewById(R.id.btnRmdir);
      btnFilelist = (Button) findViewById(R.id.btnFilelist);
      edtSD = (EditText) findViewById(R.id.edtSD);
      edtFilelist = (EditText) findViewById(R.id.edtFilelist);
      final String strSDpath = Environment.getExternalStorageDirectory().getAbsolutePath();
      final String sysDir  = Environment.getRootDirectory().getAbsolutePath();
      final File myDir = new File(strSDpath + "/mydir");
      final File[] sysFiles = (new File(sysDir)).listFiles();
      ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

      btnRead.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            try {
               FileInputStream fis = new FileInputStream("/storage/emulated/0/sdfiletest.txt");
               byte[] txt = new byte[fis.available()];
               System.out.println(fis.available());
               fis.read(txt);
               edtSD.setText(new String(txt));
               fis.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      });

      btnMkdir.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            myDir.mkdir();
            System.out.println(strSDpath);
         }
      });

      btnRmdir.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            myDir.delete();
            System.out.println(strSDpath);
         }
      });

      btnFilelist.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            String strFname;
            for (int i = 0; i < sysFiles.length; i++) {
               if (sysFiles[i].isDirectory()) {
                  strFname = "<폴더> " + sysFiles[i].toString();
               } else {
                  strFname = "<파일> " + sysFiles[i].toString();
               }

               edtFilelist.setText(edtFilelist.getText() + "\n" + strFname);
            }
         }
      });
   }
}