package com.example.pert6_alarmmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    RecyclerView recyclerView;
    String s1[],s2[],s3[];
    int images[] = {R.drawable.sdont,R.drawable.seight,R.drawable.stuck};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dl = (DrawerLayout)findViewById(R.id.dl);
        abdt = new
                ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view =
                (NavigationView)findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_home){
                    Intent a = new Intent(MainActivity.this, MainActivity.class);startActivity(a);
                }else if (id == R.id.nav_search){
                    Intent a = new Intent(MainActivity.this, MainActivity2.class);startActivity(a);
                }
                else if (id == R.id.nav_collections){
                    Intent a = new Intent(MainActivity.this, MainActivity3.class);startActivity(a);
                }else if (id == R.id.nav_alarm){
                    Intent a = new Intent(MainActivity.this, MainActivity4.class);startActivity(a);
                }
                return true;
            }
        });
        recyclerView = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.lagu);
        s2 = getResources().getStringArray(R.array.artis);
        s3 = getResources().getStringArray(R.array.star);

        LaguAdapter appAdapter = new LaguAdapter(
                this,s1,s2,s3,images
        );

        recyclerView.setAdapter(appAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this,LinearLayoutManager.HORIZONTAL,false
        );

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}