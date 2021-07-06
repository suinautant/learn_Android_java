package org.iot.ex0705_p111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   EditText edit;
   Button btnToast, btnHomepage;
   RadioButton rdoQ, rdoR;
   ImageView chgAndroid;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      // for Toast.makeText
      Context toastContext = getApplicationContext();
      Integer toastLengthShort = Toast.LENGTH_SHORT;

      // for Intent ACTION_VIEW
      String intentActionView = Intent.ACTION_VIEW;

      // configure app
      getSupportActionBar().setDisplayShowHomeEnabled(true);
      getSupportActionBar().setIcon(R.drawable.r);
      getSupportActionBar().setTitle("좀 그럴듯한 앱");

      // findViewById
      edit = (EditText) findViewById(R.id.edit);
      btnToast = (Button) findViewById(R.id.btnToast);
      btnHomepage = (Button) findViewById(R.id.btnHomepage);
      rdoQ = (RadioButton) findViewById(R.id.rdoQ);
      rdoR = (RadioButton) findViewById(R.id.rdoR);
      chgAndroid = (ImageView) findViewById(R.id.chgAndroid);

      // listener and handler
      // button click
      btnToast.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(toastContext, edit.getText().toString(), toastLengthShort).show();
         }
      });

      // button click
      btnHomepage.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent mIntent = new Intent(intentActionView, Uri.parse(edit.getText().toString()));
            startActivity(mIntent);
         }
      });

      // radiobutton click
      rdoQ.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
           chgAndroid.setImageResource(R.drawable.q);
         }
      });

      // radiobutton click
      rdoR.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            chgAndroid.setImageResource(R.drawable.r);
         }
      });
   }
}