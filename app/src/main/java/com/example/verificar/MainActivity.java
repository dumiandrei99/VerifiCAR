package com.example.verificar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.verificar.db.DataBase;
import com.example.verificar.pages.CustomerPage;
import com.example.verificar.pages.RegistrationPage;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText username = (EditText) findViewById(R.id.editTextTextEmailAddress);
        EditText password = (EditText) findViewById(R.id.editTextTextPassword);
        username.setHintTextColor(Color.BLACK);
        password.setHintTextColor(Color.BLACK);
    }

    public void onLogIn(View view) {

        EditText username = (EditText) findViewById(R.id.editTextTextEmailAddress);
        EditText password = (EditText) findViewById(R.id.editTextTextPassword);

        if (username.getText().length() == 0 || password.getText().length() == 0) {
            Toast.makeText(MainActivity.this, "Introduceti datele complet !", Toast.LENGTH_SHORT).show();
        } else {
            DataBase db = new DataBase(MainActivity.this);
            if (!db.checkUserName(username.getText().toString())) {
                Toast.makeText(MainActivity.this, "User-ul nu exista. Inregistrati-va!", Toast.LENGTH_SHORT).show();
            } else {
                if (!db.checkUserNamePassword(username.getText().toString(), password.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Parola nu este corecta!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(this, CustomerPage.class);
                    intent.putExtra("userName", username.getText().toString());
                    startActivity(intent);
                }
            }
        }

    }

    public void onRegister(View view) {
        Intent intent = new Intent(this, RegistrationPage.class);
        startActivity(intent);

    }

}
