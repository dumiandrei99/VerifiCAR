package com.example.verificar.pages;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.verificar.R;
import com.example.verificar.db.DataBase;
import com.example.verificar.models.CarModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCarPage extends Activity {
    String userName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_car_page);
        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
        EditText numePropietar = (EditText) findViewById(R.id.editTextNumePropietar);
        EditText prenumePropietar = (EditText) findViewById(R.id.editTextPrenumePropietar);
        EditText modelAuto = (EditText) findViewById(R.id.editTextModelAuto);
        EditText categorieAuto = (EditText) findViewById(R.id.editTextCategorieAuto);
        EditText serieSasiu = (EditText) findViewById(R.id.editTextSerieSasiu);
        EditText cm3 = (EditText) findViewById(R.id.editTextCmCubi);
        EditText putere = (EditText) findViewById(R.id.editTextCaiPutere);
        EditText masa = (EditText) findViewById(R.id.editTextMasaAutovehicul);
        EditText serieCIV = (EditText) findViewById(R.id.editTextSerieCIV);
        EditText combustibil = (EditText) findViewById(R.id.editTextCombustibil);
        EditText anFabricatie = (EditText) findViewById(R.id.editTextAnFabricatie);

        numePropietar.setHintTextColor(Color.BLACK);
        prenumePropietar.setHintTextColor(Color.BLACK);
        modelAuto.setHintTextColor(Color.BLACK);
        categorieAuto.setHintTextColor(Color.BLACK);
        serieSasiu.setHintTextColor(Color.BLACK);
        cm3.setHintTextColor(Color.BLACK);
        putere.setHintTextColor(Color.BLACK);
        masa.setHintTextColor(Color.BLACK);
        serieCIV.setHintTextColor(Color.BLACK);
        combustibil.setHintTextColor(Color.BLACK);
        anFabricatie.setHintTextColor(Color.BLACK);

    }


    public void onAdaugaMasina(View view) {

        EditText numePropietar = (EditText) findViewById(R.id.editTextNumePropietar);
        EditText prenumePropietar = (EditText) findViewById(R.id.editTextPrenumePropietar);
        EditText modelAuto = (EditText) findViewById(R.id.editTextModelAuto);
        EditText categorieAuto = (EditText) findViewById(R.id.editTextCategorieAuto);
        EditText serieSasiu = (EditText) findViewById(R.id.editTextSerieSasiu);
        EditText cm3 = (EditText) findViewById(R.id.editTextCmCubi);
        EditText putere = (EditText) findViewById(R.id.editTextCaiPutere);
        EditText masa = (EditText) findViewById(R.id.editTextMasaAutovehicul);
        EditText serieCIV = (EditText) findViewById(R.id.editTextSerieCIV);
        EditText combustibil = (EditText) findViewById(R.id.editTextCombustibil);
        EditText anFabricatie = (EditText) findViewById(R.id.editTextAnFabricatie);

        CarModel carModel;

        try {
            carModel = new CarModel(userName,numePropietar.getText().toString(),prenumePropietar.getText().toString(),modelAuto.getText().toString(),categorieAuto.getText().toString(),
                                    serieSasiu.getText().toString(),Integer.parseInt(cm3.getText().toString()),Integer.parseInt(putere.getText().toString()), Float.parseFloat(masa.getText().toString()),
                                    serieCIV.getText().toString(),combustibil.getText().toString(),Integer.parseInt(anFabricatie.getText().toString()));


            if(carModel.getNumePropietar().length() > 0 && carModel.getPrenumePropietar().length() > 0 && carModel.getModelAuto().length() > 0 &&
              carModel.getCategorieAuto().length() > 0 && carModel.getSeriseSasiu().length() > 0 && carModel.getCaiPutere() > 0 && carModel.getMasa() > 0 &&
              carModel.getSerieCiv().length() > 0 && carModel.getTipCombustibil().length() > 0){

                DataBase db = new DataBase(AddCarPage.this);
                boolean succes = db.addCar(carModel);
                if(succes){
                    Toast.makeText(AddCarPage.this,"Masina adaugata cu succes!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, CustomerPage.class);
                    intent.putExtra("userName",userName);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(AddCarPage.this,"Seria de sasiu exista deja in baza noastra!",Toast.LENGTH_SHORT).show();
                }
            }

        } catch (Exception e) {
            Toast.makeText(AddCarPage.this,"Introduceti toate campurile !",Toast.LENGTH_SHORT).show();

        }
    }
}
