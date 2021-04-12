package com.example.verificar.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.verificar.MainActivity;
import com.example.verificar.R;
import com.example.verificar.pages.AddCarPage;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class CustomerPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private String userName;
    private String carName;

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {
            case R.id.itemSelecteazaMasina:
                Intent intent3 = new Intent(this,SelectCarPage.class);
                intent3.putExtra("userName",userName);
                startActivity(intent3);
                break;

            case R.id.itemDetaliiMasina:
                Intent intent4 = new Intent(this,CarDetails.class);
                intent4.putExtra("carName",carName);
                intent4.putExtra("userName",userName);
                startActivity(intent4);
                break;

            case R.id.itemAdaugaMasina:
                Intent intent2 = new Intent(this, AddCarPage.class);
                intent2.putExtra("userName", userName);
                startActivity(intent2);
                break;

            case R.id.itemProgramarileMele:
                break;

            case R.id.itemLogOut:
                Intent intent5 = new Intent(this, MainActivity.class);
                startActivity(intent5);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            return;
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_page);
        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
        carName = intent.getStringExtra("carName");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }
}
