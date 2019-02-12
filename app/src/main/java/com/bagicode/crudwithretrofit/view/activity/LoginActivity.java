package com.bagicode.crudwithretrofit.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bagicode.crudwithretrofit.MainActivity;
import com.bagicode.crudwithretrofit.R;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.LoginEvent;
import com.crashlytics.android.answers.SignUpEvent;

import io.fabric.sdk.android.Fabric;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_login);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //nambah fungsi fabricnya untuk login
                Answers.getInstance().logLogin(new LoginEvent()
                        .putMethod("Digits")
                        .putSuccess(true)
                        .putCustomAttribute("id", "0110")
                        .putCustomAttribute("nama", "Bagicode"));

                // action untuk firebasenya
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        });

        findViewById(R.id.btn_sigup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // nambah fungsi fabric untuk sign up
                Answers.getInstance().logSignUp(new SignUpEvent()
                        .putMethod("Digits")
                        .putSuccess(true)
                        .putCustomAttribute("id", "0110"));
                Toast.makeText(LoginActivity.this, "Anda Sudah terdaftar, Silahkan Login", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
