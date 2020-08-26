package com.helloworld.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import notes.NotesActivity;

public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUserName = findViewById(R.id.etUserName);
        final EditText etPasword = findViewById(R.id.etPasword);
        Button btLogin = findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUserName.getText().toString();
                String password = etPasword.getText().toString();

                if (username.equals("pablo") && password.equals("123")) {
                    prefs.setPref(Constans.PREFS_USER, true);
                    Intent intent = new Intent(LoginActivity.this, NotesActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }

                    else {
                        Toast.makeText(LoginActivity.this,"Ingreso Incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}



