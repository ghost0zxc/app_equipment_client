package com.eq.app_equipment_client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.eq.app_equipment_client.domain.Equipment;
import com.eq.app_equipment_client.domain.Rresult;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowActivity extends AppCompatActivity {
    private TextView TV1,TV2,TV3,TV4;
    private ImageView IV1;
    private int eqid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        final Intent intent = getIntent();
        TV1 = findViewById(R.id.tv1);
        TV2 = findViewById(R.id.tv2);
        TV3 = findViewById(R.id.tv3);
        TV4 = findViewById(R.id.tv4);
        IV1 = findViewById(R.id.iv1);
        eqid = intent.getIntExtra("eqid", 0);

        API api =  RetrofitCreator.getInstance().getRetrofit().create(API.class);

        Call<ResponseBody> task = api.getJson3(eqid);
        task.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String result = response.body().string();
                    Gson gson = new Gson();
                    Equipment eq= gson.fromJson(result, Equipment.class);
                    Log.d("", "onResponse: "+eq.getData().getApparatus().toString());

                    TV1.setText(eq.getData().getApparatus().toString());
                    TV2.setText(eq.getData().getSynopsis());
                    if(eqid==3)
                    {     TV3.setText(R.string.method3);
                        TV4.setText(R.string.attention3);
                        Glide.with(ShowActivity.this)
                                .load("https://image2.cnpp.cn/upload/images/20190919/14072326337_430x430.jpg")
                                .into(IV1);
                    }
                    else { TV3.setText(R.string.method4);
                        TV4.setText(R.string.attention4);
                    Glide.with(ShowActivity.this)
                            .load("https://image.cnpp.cn/upload/images/20190919/14024510751_430x430.jpg")
                            .into(IV1);}
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }

    public void fix(View view) {

        API api =  RetrofitCreator.getInstance().getRetrofit().create(API.class);
//status  0:完好  1:需要维修   2:
        Call<ResponseBody> task = api.getJson4(eqid,1);
        task.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String result = response.body().string();
                    Gson gson = new Gson();
                    Rresult rr = gson.fromJson(result,Rresult.class);
                    if(rr.getResult()==1){
                        Toast.makeText(ShowActivity.this,"上报维修成功",Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
}
