package com.example.verificar.pages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.verificar.R;
import com.example.verificar.db.DataBase;
import com.example.verificar.models.CarModel;

import java.util.ArrayList;
import java.util.List;

public class CarDetails extends Activity {

    private String carName;
    private String userName;
    private List<String> attributes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        carName = intent.getStringExtra("carName");
        userName = intent.getStringExtra("userName");
        setContentView(R.layout.detalii_masina);
        String putMessage;
        if(carName == null){
            putMessage = "Selectati o masina !";
        }
        else{
            putMessage = "Detalii despre masina " + carName;
        }
        TextView textView = findViewById(R.id.textViewDetaliiMasina);
        textView.append(putMessage);
        DataBase db = new DataBase(CarDetails.this);
        List<CarModel> allCars = db.getAllCars();

        if(allCars.size() > 1){

            for (CarModel car : allCars) {
                if (car.getModelAuto().equals(carName) && car.getUsername().equals(userName)) {
                    attributes.add(car.getNumePropietar() + " " + car.getPrenumePropietar());
                    attributes.add(String.valueOf(car.getAnFabricatie()));
                    attributes.add(String.valueOf(car.getCaiPutere()));
                    if(car.hasRCA() == 0){
                        attributes.add("Nu are asigurare valabila");
                    }
                }
            }
        }

        if(allCars.size() == 1){
            attributes.add(allCars.get(0).getNumePropietar() + " " + allCars.get(0).getPrenumePropietar());
            attributes.add(String.valueOf(allCars.get(0).getAnFabricatie()));
            attributes.add(String.valueOf(allCars.get(0).getCaiPutere()));
            if(allCars.get(0).hasRCA() == 0){
                attributes.add("Nu are asigurare Valabila");
            }
        }

        ArrayAdapter carInfoArrayAdapter = new ArrayAdapter<>(CarDetails.this, android.R.layout.simple_list_item_1, attributes);
        ListView listViewSelect = findViewById(R.id.listViewDetails);
        listViewSelect.setAdapter(carInfoArrayAdapter);
    }

}
