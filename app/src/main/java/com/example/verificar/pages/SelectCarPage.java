package com.example.verificar.pages;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.verificar.R;
import com.example.verificar.db.DataBase;
import com.example.verificar.models.CarModel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class SelectCarPage extends Activity {
    private String userName;
    private String carName;
    private List<String> listCars = new ArrayList<String>();
    List<CarModel> allCars = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
        setContentView(R.layout.selecteaza_masina);
        DataBase db = new DataBase(SelectCarPage.this);
        allCars = db.getAllCars();
        for(CarModel car : allCars){
            if(car.getUsername().equals(userName)){
                listCars.add(car.getModelAuto());
            }
        }

        ArrayAdapter carArrayAdapter = new ArrayAdapter<>(SelectCarPage.this, android.R.layout.simple_list_item_1, listCars);
        ListView listViewSelect = findViewById(R.id.listViewSelect);
        listViewSelect.setAdapter(carArrayAdapter);

        listViewSelect.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SelectCarPage.this, CustomerPage.class);
                carName = listCars.get(position);
                intent.putExtra("carName",carName);
                intent.putExtra("userName",userName);
                startActivity(intent);
            }
        });

    }

}
