package com.example.verificar.pages;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.verificar.db.DataBase;
import com.example.verificar.models.PersonModel;
import com.example.verificar.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RegistrationPage extends Activity {
    private int id = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        EditText userName = (EditText) findViewById(R.id.editTextTextPersonName11);
        EditText password = (EditText) findViewById(R.id.editTextTextPersonName10);
        EditText nume = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText prenume = (EditText) findViewById(R.id.editTextTextPersonName3);
        EditText email = (EditText) findViewById(R.id.editTextTextPersonName4);
        EditText cnp = (EditText) findViewById(R.id.editTextTextPersonName5);
        EditText kz = (EditText) findViewById(R.id.editTextTextPersonName6);
        EditText nrBuletin = (EditText) findViewById(R.id.editTextTextPersonName7);
        EditText adresa = (EditText) findViewById(R.id.editTextTextPersonName8);
        EditText telefon = (EditText) findViewById(R.id.editTextTextPersonName9);
        EditText dataExpirare = (EditText) findViewById(R.id.editTextTextPersonName12);

        email.setHintTextColor(Color.BLACK);
        password.setHintTextColor(Color.BLACK);
        userName.setHintTextColor(Color.BLACK);
        nume.setHintTextColor(Color.BLACK);
        prenume.setHintTextColor(Color.BLACK);
        cnp.setHintTextColor(Color.BLACK);
        kz.setHintTextColor(Color.BLACK);
        nrBuletin.setHintTextColor(Color.BLACK);
        adresa.setHintTextColor(Color.BLACK);
        telefon.setHintTextColor(Color.BLACK);
        dataExpirare.setHintTextColor(Color.BLACK);

    }

    public void onFinalizare(View view) throws ParseException {

        EditText userName = (EditText) findViewById(R.id.editTextTextPersonName11);
        EditText password = (EditText) findViewById(R.id.editTextTextPersonName10);
        EditText nume = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText prenume = (EditText) findViewById(R.id.editTextTextPersonName3);
        EditText email = (EditText) findViewById(R.id.editTextTextPersonName4);
        EditText cnp = (EditText) findViewById(R.id.editTextTextPersonName5);
        EditText kz = (EditText) findViewById(R.id.editTextTextPersonName6);
        EditText nrBuletin = (EditText) findViewById(R.id.editTextTextPersonName7);
        EditText adresa = (EditText) findViewById(R.id.editTextTextPersonName8);
        EditText telefon = (EditText) findViewById(R.id.editTextTextPersonName9);
        EditText dataExpirare = (EditText) findViewById(R.id.editTextTextPersonName12);

        PersonModel personModel;

        try{
            personModel = new PersonModel (userName.getText().toString(),password.getText().toString(),nume.getText().toString(), prenume.getText().toString(),
                    email.getText().toString(), cnp.getText().toString(), kz.getText().toString(),
                    Integer.parseInt(nrBuletin.getText().toString()), adresa.getText().toString(), Integer.parseInt(telefon.getText().toString()),
                    new SimpleDateFormat("yyyy/MM/dd").parse(dataExpirare.getText().toString()));

            if(personModel.getUserName().length() < 6){
                Toast.makeText(RegistrationPage.this,"User nameul trebuie sa aiba minim 6 caractere !",Toast.LENGTH_SHORT).show();
                userName.setText("");
                password.setText("");
            }
            if(personModel.getPassword().length() < 8){
                Toast.makeText(RegistrationPage.this,"Parola trebuie sa aiba minim 8 caractere !",Toast.LENGTH_SHORT).show();
                userName.setText("");
                password.setText("");
            }


            if(personModel.getUserName().length() >= 6 && personModel.getPassword().length() >=8 ){
                DataBase dataBase = new DataBase(RegistrationPage.this);
                boolean succes = dataBase.addPersonAccount(personModel);

                if(succes){
                    Intent intent = new Intent(this, WelcomePage.class);
                    intent.putExtra("userName",personModel.getUserName());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(RegistrationPage.this,"User-ul exista deja !",Toast.LENGTH_SHORT).show();
                    userName.setText("");
                    password.setText("");
                }
            }
        }

        catch (Exception e){
            Toast.makeText(RegistrationPage.this,"Datele nu au fost introduse in format corect!",Toast.LENGTH_SHORT).show();
            userName.setText("");
            password.setText("");
            nume.setText("");
            prenume.setText("");
            email.setText("");
            cnp.setText("");
            kz.setText("");
            nrBuletin.setText("");
            adresa.setText("");
            telefon.setText("");
            dataExpirare.setText("");
        }
    }
}

