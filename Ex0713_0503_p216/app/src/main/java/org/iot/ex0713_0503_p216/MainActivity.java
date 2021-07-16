package org.iot.ex0713_0503_p216;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
//      setContentView(R.layout.activity_main);

      // define layout for LinearLayout
      LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
              LinearLayout.LayoutParams.MATCH_PARENT,
              LinearLayout.LayoutParams.MATCH_PARENT
      );
      LinearLayout baseLayout = new LinearLayout(this);
      baseLayout.setOrientation(LinearLayout.VERTICAL);
      setContentView(baseLayout, params);

      // Add widget
      EditText etInput = new EditText(this);
      Button btnSubmit = new Button(this);
      TextView tvDisplay = new TextView(this);

      btnSubmit.setText("버튼입니다.");
      btnSubmit.setBackgroundColor(Color.YELLOW);
      tvDisplay.setTextColor(Color.MAGENTA);

      baseLayout.addView(etInput);
      baseLayout.addView(btnSubmit);
      baseLayout.addView(tvDisplay);

      // button onclick listener and handler
      // if click button, display from editbox value to textview
      btnSubmit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            tvDisplay.setText(etInput.getText().toString());
         }
      });

   }
}