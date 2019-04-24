package sg.edu.rp.c390.p01_dailygoals;

import android.content.Context;
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
import android.widget.TextView;

public class DailyGoalActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3, tv4;
    RadioButton rb1, rb2, rb3, rb4, rb5, rb6;
    RadioGroup rg1, rg2, rg3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_goal);

        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);

        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        rb5 = findViewById(R.id.radioButton5);
        rb6 = findViewById(R.id.radioButton6);

        rg1= findViewById(R.id.radioGroup1);
        rg2 = findViewById(R.id.radioGroup2);
        rg3 = findViewById(R.id.radioGroup3);

        Button btnOK = findViewById(R.id.buttonOK);

        //write retrieving logic in oncreate method  no need to create editor but create shared pref
        SharedPreferences sp = getSharedPreferences("mysavedsummary", Context.MODE_PRIVATE);
        // -1 means default value no data
        int radio1 = sp.getInt("rG1",-1);
        if(radio1 != -1) {
            if(radio1 == 1) {
                rb1.setChecked(true);
            } else {
                rb2.setChecked(true);
            }
        }

        int radio2 = sp.getInt("rG2",-1);
        if(radio2 != -1) {
            if(radio2 == 3) {
                rb3.setChecked(true);
            } else {
                rb4.setChecked(true);
            }
        }

        int radio3 = sp.getInt("rG3",-1);
        if(radio3 != -1) {
            if(radio3 == 5) {
                rb5.setChecked(true);
            } else {
                rb6.setChecked(true);
            }
        }

        String reflection = sp.getString("reflection", "");
        EditText etReflection =findViewById(R.id.editTextReflection);
        etReflection.setText(reflection);


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                //MAKE ARRAY OF STRING SO TO STORE SINCE TEXTVIEW IS TEXT
                String[] values = new String[4];

                //create common shared pref file for storing all data
                SharedPreferences summary = getSharedPreferences("mysavedsummary", MODE_PRIVATE);
                SharedPreferences.Editor prefEdit = summary.edit();

                    //SELECTION OF RADIOGROUP

                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                //IF USER CHOOSE THE FIRST RADIOBUTTON
                if (selectedButtonId1 == R.id.radioButton1) {
                    //PUT IN FIRST ARRAY  // GET TEXT OF TEXTVIEW // GET TEXT OF RADIO BUTTON YES/NO
                    values[0] = tv1.getText() + " : " + rb1.getText();
                    //STORE SHARED PREF USING THE SAME RADIOGROUP
                    prefEdit.putInt("rG1",1);
                } else {
                    values[0] = tv1.getText() + " : " + rb2.getText();
                    prefEdit.putInt("rG1",2);
                }


                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                if (selectedButtonId2 == R.id.radioButton3) {
                    values[1] = tv2.getText() + " : " + rb3.getText();
                    prefEdit.putInt("rG2",3);
                } else {
                    values[1] = tv2.getText() + " : " + rb4.getText();
                    prefEdit.putInt("rG2",4);
                }


                 int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                if (selectedButtonId3 == R.id.radioButton5) {
                    values[2] = tv3.getText() + " : " + rb5.getText();
                    prefEdit.putInt("rG3",5);
                } else {
                    values[2] = tv3.getText() + " : " + rb6.getText();
                    prefEdit.putInt("rG3",6);
                }



               EditText etReflection = findViewById(R.id.editTextReflection);
                values[3] = etReflection.getText().toString();
                prefEdit.putString("reflection",etReflection.getText().toString());
                prefEdit.commit();


                 Intent i = new Intent(DailyGoalActivity.this, SummaryActivity.class);
                i.putExtra("msg",values);
                startActivity(i);
//                 i.putExtra("reflection",etReflection.getText().toString());
//                 i.putExtra("radio1",rb1.getText());
            }

        });


    }
}
