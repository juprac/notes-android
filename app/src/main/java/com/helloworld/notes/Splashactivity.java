package com.helloworld.notes;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

import notes.NotesActivity;

public class Splashactivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

     runSplash();
    }

    private void runSplash() {
        final Runnable splash = new Runnable() {
            @Override
            public void run() {


                boolean userLogged = prefs.getPref(Constans.PREFS_USER);

                Intent intent;

                if(userLogged){
                    intent = new Intent(Splashactivity.this, NotesActivity.class);
                } else{
                    intent = new Intent(Splashactivity.this, LoginActivity.class);
                }

                    startActivity(intent);
                    finish();
            }
        };
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(splash);

            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 2000);
    }
}
