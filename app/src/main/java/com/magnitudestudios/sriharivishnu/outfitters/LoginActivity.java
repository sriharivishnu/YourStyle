package com.magnitudestudios.sriharivishnu.outfitters;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton loginButton;
    private ImageButton signUpButton;
    private EditText username_edit;
    private EditText password_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (ImageButton) findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);

        signUpButton = (ImageButton) findViewById(R.id.sign_up_button);
        signUpButton.setOnClickListener(this);

        username_edit = (EditText) findViewById(R.id.login_user_edit);
        password_edit = (EditText) findViewById(R.id.login_password_edit);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                if (username_edit.getText().toString().equals("")) {
                    username_edit.setError("This field is necessary");

                } else if (password_edit.getText().toString().equals("")){
                    password_edit.setError("This field is necessary");
                } else {
                    if (load(username_edit.getText().toString()).equals(password_edit.getText().toString())) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        save("current_username",username_edit.getText().toString());
                    } else {
                        username_edit.setError("Username or password not found");
                    }
                }
                break;
            case R.id.sign_up_button:
                Intent in = new Intent(LoginActivity.this, SignUp.class);
                startActivity(in);
                finish();
                break;
        }

    }
    @Override
    public void onBackPressed() {

    }
    public String load(String username) {
        SharedPreferences sharedPreferences = getSharedPreferences("Settings_Money", MODE_PRIVATE);
        return sharedPreferences.getString(username,"");
    }
    public void save(String username, final String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("Settings_Money", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(username,password);
        editor.commit();
    }


}
