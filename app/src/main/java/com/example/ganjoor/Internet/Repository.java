package com.example.ganjoor.Internet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private static Retrofit retrofit = null;

    private Repository() {
    }

    public static Retrofit getApiclient() {

        if (retrofit == null) {
            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder().baseUrl("https://ganjgah.ir/api/ganjoor/").addConverterFactory(GsonConverterFactory.create(gson)).build();
        }

        return retrofit;
    }
}
