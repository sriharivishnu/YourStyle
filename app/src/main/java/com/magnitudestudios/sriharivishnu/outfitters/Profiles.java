package com.magnitudestudios.sriharivishnu.outfitters;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Profiles extends AppCompatActivity {

    private ImageButton backButton;
    private ImageButton settingsButton;
    private ListView listView;
    private TextView usernameShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);

        settingsButton = (ImageButton) findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Profiles.this, SettingsPage.class);
                startActivity(in);
            }
        });

        backButton = (ImageButton) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        usernameShow = (TextView) findViewById(R.id.userName);
        usernameShow.setText(load("current_username"));

        ArrayList<Integer> myImages = new ArrayList<>();

        myImages.add(R.drawable.shirtpicture);
        myImages.add(R.drawable.shoes);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ImageAdapter(this, myImages));
    }
    public String load(String username) {
        SharedPreferences sharedPreferences = getSharedPreferences("Settings_Money", MODE_PRIVATE);
        return sharedPreferences.getString(username,"");
    }
}
