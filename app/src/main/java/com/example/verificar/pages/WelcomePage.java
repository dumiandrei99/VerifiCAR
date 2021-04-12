package com.example.verificar.pages;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.verificar.R;

import org.w3c.dom.Text;

public class WelcomePage extends Activity {

    private String userName;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);
        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
        String putOnPage = "Felicitari " + userName +", contul a fost creat cu succes!";
        TextView welcomeMessage = (TextView) findViewById(R.id.textViewWelcomePage);
        welcomeMessage.append(putOnPage);
    }

    @Override
    public void onBackPressed(){
        return;
    }

    public void onAdaugaMasina(View view){
        Intent intent = new Intent(this,AddCarPage.class);
        intent.putExtra("userName",userName);
        startActivity(intent);
    }
}
