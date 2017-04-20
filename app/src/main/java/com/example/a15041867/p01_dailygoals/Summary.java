package com.example.a15041867.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // Get the intent so as to get the "things" inside the intent
        Intent i = getIntent();
        // Get the String array named "info" we passed in
        String[] info = i.getStringArrayExtra("info");
        // Get the TextView object
        TextView tv1 = (TextView) findViewById(R.id.textViewResults);
        // Display the name and age on the TextView
        tv1.setText("Read Up on materials before class :" + info[0] +"\n" + "Arrive on time so as not miss important part of the lesson: " + info[1] +"\n" + "Attempt the problem myself : " + info[2] +"\n" + "My personal reflection today :" + info[3]);

        Button btnBack = (Button)findViewById(R.id.buttonBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Summary.this,
                        MainActivity.class);
                startActivity(i);

            }
        });
    }
}
