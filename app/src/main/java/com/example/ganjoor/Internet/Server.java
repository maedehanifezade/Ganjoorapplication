package com.example.ganjoor.Internet;



import com.example.ganjoor.Entity.faal.Fal;
import com.example.ganjoor.Entity.poets.Poet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Server {

    @GET("poets")
    Call<List<Poet>> getpoets();

    @GET("hafez/faal")
    Call<Fal> getfaal();




}
