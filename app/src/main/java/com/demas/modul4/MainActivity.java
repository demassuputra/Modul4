package com.demas.modul4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    static RecyclerView recyclerView;
    private RecyclerviewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<User> userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        setupRecyclerView();

        try{
            Intent intent = getIntent();
            String status = intent.getExtras().getString("status");


            if (status.equals("add")) {
                Toast.makeText(this, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
            } else if (status.equals("edit")) {
                Toast.makeText(this, "Data Berhasil Diubah", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            if (userList.isEmpty()) {
                Toast.makeText(this, "Klik fab untuk menambah User", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Klik User untuk opsi lain", Toast.LENGTH_SHORT).show();
            }
        }


        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }


    static void setupRecyclerView(Context context, List<User> userList, RecyclerView recyclerView) {
        DataHelper db = new DataHelper(context);
        userList = db.selectUserData();

        // Meng set adapter Recycler View nya
        RecyclerviewAdapter adapter = new RecyclerviewAdapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    private void setupRecyclerView() {
        DataHelper db = new DataHelper(this);
        userList = db.selectUserData();

        adapter = new RecyclerviewAdapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Selamat datang", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Halo", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Jangan lupa kembali lagi", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Sampai berjumpa lagi nanti", Toast.LENGTH_LONG).show();
    }
}