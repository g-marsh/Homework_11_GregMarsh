package com.oakton.cis258.homework_11_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Question3Activity extends AppSettings
{
    // Variables
    ListView lvChoices;
    String strChoice;
    TextView tvScreenName;
    String [] aryChoices;
    String [] aryQuestions;

    // Global Variables.
    SharedPreferences spAppSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category2);

        // Instantiate App Settings
        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = spAppSettings.edit();

        // Get category selected array value position
        int intPosition = spAppSettings.getInt("Category",0);

        // Populate choices array based on question
        if (intPosition == 0) {
            aryChoices = getResources().getStringArray(R.array.choices_movies);
        }
        else if (intPosition == 1) {
            aryChoices = getResources().getStringArray(R.array.choices_food);
        }
        else if (intPosition == 2) {
            aryChoices = getResources().getStringArray(R.array.choices_music);
        }
        else if (intPosition == 3) {
            aryChoices = getResources().getStringArray(R.array.choices_cameras);
        }
        else if (intPosition == 4) {
            aryChoices = getResources().getStringArray(R.array.choices_engineering);
        }
        else if (intPosition == 5) {
            aryChoices = getResources().getStringArray(R.array.choices_geography);
        }

        // Instantiate Variables
        lvChoices = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> aryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, aryChoices);
        lvChoices.setAdapter(aryAdapter);
        tvScreenName = (TextView)findViewById(R.id.textView);

        // Display Question
        aryQuestions = getResources().getStringArray(R.array.questions);
        tvScreenName.setText(aryQuestions[intPosition]);

        // ListView Listener
        lvChoices.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // Store Info into shared preferences and switch activity
                strChoice = ((TextView) view).getText().toString();
                editor.putString("Choice", strChoice);
                editor.commit();
                startActivity(new Intent(Question3Activity.this, Answer4Activity.class));
                finish();
            }
        });

    }
}
