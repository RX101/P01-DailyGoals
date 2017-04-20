package com.example.a15041867.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOK = (Button)findViewById(R.id.buttonOK);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get the RadioGroup object
                RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb1 = (RadioButton) findViewById(selectedButtonId1);

                // Get the RadioGroup object
                RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb2 = (RadioButton) findViewById(selectedButtonId2);

                // Get the RadioGroup object
                RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb3 = (RadioButton) findViewById(selectedButtonId3);

                EditText et = (EditText) findViewById(R.id.editText);

                // Put the name and age into an array
                String[] info = {rb1.getText().toString(),rb2.getText().toString(),rb3.getText().toString(),et.getText().toString()};

                // Create an intent to start another activity called
                //  DemoActivities (which we would create later)
                Intent i = new Intent(MainActivity.this,
                        Summary.class);
                // Pass the String array holding the name & age to new activity
                i.putExtra("info", info);
                // Start the new activity
                startActivity(i);

                //Open Shaared Preference
                SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                //create a edit Shared Preference
                SharedPreferences.Editor prefEdit = prefs.edit();
                prefEdit.putInt("rg1", selectedButtonId1);
                prefEdit.putInt("rg2", selectedButtonId2);
                prefEdit.putInt("rg3", selectedButtonId3);
                prefEdit.putString("et",et.getText().toString());
                //commit to save change
                prefEdit.commit();

            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        //retrieve data
        int sb1=prefs.getInt("rg1",0);
        int sb2=prefs.getInt("rg2",0);
        int sb3=prefs.getInt("rg3",0);
        String editText = prefs.getString("et","editText");
        //Update UI element
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        rg1.check(sb1);
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        rg2.check(sb2);
        RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
        rg3.check(sb3);

        EditText et = (EditText) findViewById(R.id.editText);
        et.setText(editText);
    }
}
