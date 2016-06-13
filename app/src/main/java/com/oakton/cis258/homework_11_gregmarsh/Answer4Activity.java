package com.oakton.cis258.homework_11_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Answer4Activity extends AppSettings
{
    // Variables
    TextView tvAnswer;
    Button btMain;
    Button btCategory;
    String [] aryAnswer;
    int intPosition;
    String strCorrect;
    String strUserAnswer;

    // Global Variables.
    SharedPreferences spAppSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer4);

        // Instantiate App Settings / Editor
        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = spAppSettings.edit();

        // Instantiate Variables
        tvAnswer = (TextView) findViewById(R.id.textView2);
        btMain = (Button) findViewById(R.id.button3);
        btCategory = (Button) findViewById(R.id.button4);

        // Get category selected array value position
        int intPosition = spAppSettings.getInt("Category",0);

        // Get correct answer
        aryAnswer = getResources().getStringArray(R.array.answers);
        strCorrect = aryAnswer[intPosition];

        // Get user answer
        strUserAnswer = spAppSettings.getString("Choice","");

        // Get stats
        int intNumberQuestions = spAppSettings.getInt("NumberQuestions",0);
        int intNumberCorrect = spAppSettings.getInt("NumberCorrect",0);

        // Update text and stats
        intNumberQuestions++;
        if (strUserAnswer.equals(strCorrect))
        {
            tvAnswer.setText(R.string.correct);
            intNumberCorrect++;
            editor.putInt("NumberQuestions",intNumberQuestions);
            editor.putInt("NumberCorrect",intNumberCorrect);
        }
        else
        {
            tvAnswer.setText("Answer is: " + strCorrect);
            editor.putInt("NumberQuestions",intNumberQuestions);
        }
        editor.commit();

        // Switch to Main Activity
        btMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Answer4Activity.this, Menu1Activity.class));
                finish();
            }
        });

        // Switch to Category Activity
        btCategory.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Answer4Activity.this, Category2Activity.class));
                finish();
            }
        });

    }
}
