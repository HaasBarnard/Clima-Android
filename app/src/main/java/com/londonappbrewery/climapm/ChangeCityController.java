package com.londonappbrewery.climapm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChangeCityController extends AppCompatActivity
{
    private EditText m_editText;
    private ImageButton m_backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_city_layout);

        m_editText = findViewById(R.id.queryET);
        m_backButton = findViewById(R.id.backButton);

        m_backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });

        m_editText.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent)
            {
                String newCity = textView.getText().toString();
                Intent newCityIntent = new Intent(ChangeCityController.this, WeatherController.class);
                newCityIntent.putExtra("city",newCity);


                startActivity(newCityIntent);

                return false;
            }
        });
    }
}
