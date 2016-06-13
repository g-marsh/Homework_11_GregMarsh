package com.oakton.cis258.homework_11_gregmarsh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu1Activity extends AppSettings
{
    // Variables
    Button btnGame;
    Button btnStats;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        // Instantiate variables
        btnGame = (Button)findViewById(R.id.button);
        btnStats = (Button)findViewById(R.id.button2);

        // Start Game
        btnGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Menu1Activity.this, Category2Activity.class));
                finish();
            }

        });

        // View Stats
        btnStats.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Menu1Activity.this, Stats5Activity.class));
                finish();
            }
        });

    }
}
