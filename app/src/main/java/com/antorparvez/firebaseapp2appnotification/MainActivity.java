package com.antorparvez.firebaseapp2appnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText EmailTB, PassTB;
    Button LoginB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmailTB = findViewById(R.id.EmailTB);
        PassTB = findViewById(R.id.PassTB);
        LoginB = findViewById(R.id.Login);
        if (FirebaseAuth.getInstance().getCurrentUser()!= null) {
            startActivity(new Intent(this, SendNotificationActivity.class));
        } else {
            LoginB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(EmailTB.getText().toString().trim(), PassTB.getText().toString().trim()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Log.d("TAG", "onSuccess: "+authResult);
                            startActivity(new Intent(MainActivity.this, SendNotificationActivity.class));
                        }
                    });
                }
            });
        }
    }

}