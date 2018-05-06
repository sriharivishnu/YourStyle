package com.magnitudestudios.sriharivishnu.outfitters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

public class SettingsPage extends AppCompatActivity {

    private ImageButton backButton;
    private Button editProfile;
    private Button changePassword;
    private Button signOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        backButton = (ImageButton) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        editProfile = (Button) findViewById(R.id.Edit_Profile);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(SettingsPage.this, EditProfile.class);
                startActivity(in);
            }
        });
        changePassword = (Button) findViewById(R.id.Password);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(SettingsPage.this, ChangePassword.class);
                startActivity(in);
            }
        });
        signOut = (Button) findViewById(R.id.signout);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(SettingsPage.this, LoginActivity.class);
                startActivity(in);
                finish();
            }

        });
    }
}