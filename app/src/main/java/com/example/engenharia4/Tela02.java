package com.example.engenharia4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class Tela02 extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigation;
    private LinearLayout layout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela02);

        drawer = findViewById(R.id.main1);
        navigation = findViewById(R.id.nav1);
        layout = findViewById(R.id.id_layout);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.id_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
           v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Toast.makeText(Tela02.this, "Back pressionado",
                        Toast.LENGTH_SHORT).show();
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(Tela02.this, Tela03.class));
                    }
                }, 2000);
            }
        });
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(
                Tela02.this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(toogle);
        toogle.syncState();

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()== R.id.id_item1){
                    Toast.makeText(Tela02.this, "Opção1", Toast.LENGTH_SHORT).show();
                }
                if(menuItem.getItemId()== R.id.id_item2){
                    Toast.makeText(Tela02.this, "Opção2", Toast.LENGTH_SHORT).show();
                }
                if(menuItem.getItemId()== R.id.id_item3){
                    Toast.makeText(Tela02.this, "Opção3", Toast.LENGTH_SHORT).show();
                }
                if(menuItem.getItemId()== R.id.id_item4){
                    Toast.makeText(Tela02.this, "Opção4", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            startActivity(new Intent(this, Tela03.class));
            finish();
        }
        if (id == R.id.idA) {
            Toast.makeText(Tela02.this, "Opçao A",
                    Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.idB) {
            Toast.makeText(Tela02.this, "Opçao B",
                    Toast.LENGTH_SHORT).show();
        }
        return true;
        }



}