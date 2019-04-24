package sg.edu.rp.c390.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView tv1 = findViewById(R.id.textView1);
        TextView tv2 = findViewById(R.id.textView2);
        TextView tv3 = findViewById(R.id.textView3);
        TextView tv4 = findViewById(R.id.textView4);
        Intent i = getIntent();
//        SharedPreferences myReflection = getSharedPreferences("mysavedreflection",MODE_PRIVATE);
//        String reflection = myReflection.getString("reflection","DefValue");
        String[] msg = i.getStringArrayExtra("msg");

//        String reflection = i.getStringExtra("reflection");
//        String radio1 = i.getStringExtra("radio1");
//        String radio2 = i.getStringExtra("radio2");
//        String radio3 = i.getStringExtra("radio3");

        tv1.setText(msg[0]);
         tv2.setText(msg[1]);
        tv3.setText(msg[2]);

        tv4.setText(getResources().getString(R.string.tvReflection) + msg[3]);

        Button btnBack = findViewById(R.id.buttonBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //similar to back button on phone
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
