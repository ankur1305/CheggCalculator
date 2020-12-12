package com.osinfosoft.cheggcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Implementing writeToUs functionality
        LinearLayout writeToUsLayout = findViewById(R.id.writeToUsLayout);
        writeToUsLayout.setOnClickListener(view -> {
            Intent sendEmail = new Intent(Intent.ACTION_SENDTO);
            sendEmail.setData(Uri.parse("mailto:"));
            sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"99ankursinghal@gmail.com"});
            sendEmail.putExtra(Intent.EXTRA_SUBJECT, "");
            sendEmail.putExtra(Intent.EXTRA_TEXT, "");
            try {
                startActivity(sendEmail);
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
        });

        //Settings button click functionality
        ImageView imageBackFromSettings = findViewById(R.id.imageBackFromSettings);
        imageBackFromSettings.setOnClickListener(v -> onBackPressed());
    }
}