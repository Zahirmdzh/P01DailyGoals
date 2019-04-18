package sg.edu.rp.c390.p01_dailygoals;

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

public class DailyGoalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_goal);

        Button btnOK = findViewById(R.id.buttonOK);
        EditText etReflection = findViewById(R.id.editTextReflection);
        SharedPreferences reflection = getSharedPreferences("mysavedreflection", MODE_PRIVATE);
        String myReflection = reflection.getString("reflection","defvalue");

        etReflection.setText(myReflection);


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup rg1 = findViewById(R.id.radioGroup1);
                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                RadioButton rb1 = findViewById(selectedButtonId1);

                RadioGroup rg2 = findViewById(R.id.radioGroup2);
                 int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                RadioButton rb2 = findViewById(selectedButtonId2);

                 RadioGroup rg3 = findViewById(R.id.radioGroup3);
                 int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                 RadioButton rb3 = findViewById(selectedButtonId3);

               EditText etReflection = findViewById(R.id.editTextReflection);
                SharedPreferences reflection = getSharedPreferences("mysavedreflection", MODE_PRIVATE);
                SharedPreferences.Editor prefEditR = reflection.edit();

                prefEditR.putString("reflection",etReflection.getText().toString());
                prefEditR.commit();




                 Intent i = new Intent(DailyGoalActivity.this, SummaryActivity.class);
                 i.putExtra("reflection",etReflection.getText().toString());
                 i.putExtra("radio1",rb1.getText());
                 i.putExtra("radio2",rb2.getText());
                 i.putExtra("radio3",rb3.getText());
                 startActivity(i);
            };

        });


    }
}
