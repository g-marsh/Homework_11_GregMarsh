package com.oakton.cis258.homework_11_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Stats5Activity extends AppSettings
{
    // Global Variables
    SharedPreferences spAppSettings;

    // Variables
    TextView tvNumber;
    TextView tvCorrect;
    Button btnClear;
    Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats5);

        // Instantiate App Settings
        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = spAppSettings.edit();

        // Variables
        tvNumber = (TextView) findViewById(R.id.textView3);
        tvCorrect = (TextView) findViewById(R.id.textView4);
        btnClear = (Button) findViewById(R.id.button5);
        btnMain = (Button) findViewById(R.id.button6);

        // Display Stats
        tvNumber.setText(String.valueOf(spAppSettings.getInt("NumberQuestions",0)));
        tvCorrect.setText(String.valueOf(spAppSettings.getInt("NumberCorrect", 0)));

        // Clear Stats
        btnClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editor.putInt("NumberQuestions",0);
                editor.putInt("NumberCorrect",0);
                tvNumber.setText("0");
                tvCorrect.setText("0");
                editor.commit();
            }
        });

        // Main Screen
        btnMain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Stats5Activity.this, Menu1Activity.class));
                finish();
            }
        });

    }
}
