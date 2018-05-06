package com.magnitudestudios.sriharivishnu.outfitters;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import org.w3c.dom.Text;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private ImageButton signupbutton;
    private ImageButton loginbutton;
    private EditText username_edit;
    private EditText password_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupbutton = (ImageButton) findViewById(R.id.signUpButton);
        signupbutton.setOnClickListener(this);

        loginbutton = (ImageButton) findViewById(R.id.loginButton);
        loginbutton.setOnClickListener(this);

        username_edit = (EditText) findViewById(R.id.loginUserEdit);
        password_edit = (EditText) findViewById(R.id.loginPasswordEdit);



    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUpButton:
                if (username_edit.getText().toString().equals("")) {
                    username_edit.setError("This field is necessary");

                } else if (password_edit.getText().toString().equals("")){
                    password_edit.setError("This field is necessary");
                } else {
                    save(username_edit.getText().toString(), password_edit.getText().toString());
                    save("current_username",username_edit.getText().toString());
                    Intent intent = new Intent(SignUp.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.loginButton:
                Intent in = new Intent(SignUp.this, LoginActivity.class);
                startActivity(in);
                finish();
                break;
        }
    }
    public void save(String username, final String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("Settings_Money", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(username,password);
        editor.commit();
    }

}
