package com.example.ganjoor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.ganjoor.Internet.Server;
import com.example.ganjoor.Internet.Repository;
import com.example.ganjoor.Entity.faal.Fal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {


    Server request;
    TextView title, content ,again ,BACK;
    Call<Fal> call;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("فال");

        title =findViewById(R.id.textView2);
        content =findViewById(R.id.textView3);
        again =findViewById(R.id.textView4);
        BACK =findViewById(R.id.textView5);
        request = Repository.getApiclient().create(Server.class);
        call = request.getfaal();
        call.enqueue(new Callback<Fal>() {
            @Override
            public void onResponse(Call<Fal> call, Response<Fal> response) {
                if (response.isSuccessful()) {
                    Log.i("Example", "onResponse: " + response.body());
                    title.setText(response.body().getFullTitle().replace("","").replace("غزلیات",""));
                    content.setText(response.body().getPlainText());



                }
            }

            @Override
            public void onFailure(Call<Fal> call, Throwable t) {
                Log.i("Example", "onError: " + t.getMessage());

            }
        });

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call = request.getfaal();
                call.enqueue(new Callback<Fal>() {
                    @Override
                    public void onResponse(Call<Fal> call, Response<Fal> response) {
                        if (response.isSuccessful()) {
                            title.setText(response.body().getFullTitle().replace("","").replace("غزلیات",""));
                            content.setText(response.body().getPlainText());






                        }
                    }

                    @Override
                    public void onFailure(Call<Fal> call, Throwable t) {

                    }
                });


            }
        });



        BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }
}