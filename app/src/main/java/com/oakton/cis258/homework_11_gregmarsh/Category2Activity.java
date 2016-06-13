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

public class Category2Activity extends AppSettings
{
    // Variables
    ListView lvCategories;
    String strCategory;
    TextView tvScreenName;
    String [] aryCategories;

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

        // Declare and populate array
        aryCategories = getResources().getStringArray(R.array.categories);

        // Instantiate Variables
        lvCategories = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> aryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, aryCategories);
        lvCategories.setAdapter(aryAdapter);
        tvScreenName = (TextView)findViewById(R.id.textView);
        tvScreenName.setText(getString(R.string.category));

        // ListView Listener
        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // Store Info into shared preferences and switch activity
                strCategory = ((TextView) view).getText().toString();
                editor.putInt("Category",position);
                editor.commit();
                startActivity(new Intent(Category2Activity.this, Question3Activity.class));
                finish();
            }
        });

    }
}
