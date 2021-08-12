package org.iot.ex0803_raw_file_p335;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
   Button btnRead;
   EditText edtRaw;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      setTitle("/rew/raw 폴더 파일 읽기");
      btnRead = (Button) findViewById(R.id.button);
      edtRaw = (EditText) findViewById(R.id.edtRaw);

      btnRead.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
            try {
               InputStream is = getResources().openRawResource(R.raw.raw_test);
               byte[] txt = new byte[is.available()];
               is.read(txt);
               edtRaw.setText(new String(txt));
               is.close();
            } catch (IOException e) {
               System.out.println("IOException : " + e.getMessage());
               e.printStackTrace();
            }
         }
      });

   }
}
