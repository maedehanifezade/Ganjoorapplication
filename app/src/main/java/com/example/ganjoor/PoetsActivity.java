package com.example.ganjoor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.ganjoor.Entity.poets.Poet;
import com.example.ganjoor.Internet.Repository;
import com.example.ganjoor.Internet.Server;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PoetsActivity extends AppCompatActivity {
    Server server;
    Call<List<Poet>> list;

    Adapterlist adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poets);
        setTitle("بیوگرافی شاعران");
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        server = Repository.getApiclient().create(Server.class);

        list = server.getpoets();
        list.enqueue(new Callback<List<Poet>>() {
            @Override
            public void onResponse(Call<List<Poet>> call, Response<List<Poet>> response) {
                if (response.isSuccessful()) {
                    Log.e("BiooT", "onResponse: " + response.body());


                    adapter = new Adapterlist(PoetsActivity.this, response.body());

                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Poet>> call, Throwable t) {
                Log.i("Example", "onError: " + t.getMessage());

            }
        });
    }
}