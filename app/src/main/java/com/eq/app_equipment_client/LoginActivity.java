package com.eq.app_equipment_client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.eq.app_equipment_client.domain.JsonResult;
import com.eq.app_equipment_client.domain.aa;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private EditText ETu,ETp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ETu= findViewById(R.id.username);
        ETp=findViewById(R.id.password);
    }
    public void getLogin(View view) {
        API api =  RetrofitCreator.getInstance().getRetrofit().create(API.class);

        Call<ResponseBody> task = api.getJson(ETu.getText().toString(),ETp.getText().toString());
        task.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //  Log.d(TAG, "onResponse: "+response.code());
                try {
                    String result1 = response.body().string();
                    Gson gson = new Gson();
                    JsonResult jr= gson.fromJson(result1, JsonResult.class);
                    if(jr.getParams().getResult().equals("success"))
                    {
                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast toast = Toast.makeText(LoginActivity.this,"密码错误，请重试",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.toString());

            }
        });
    }

    public void getRegister(View view) {

        API api =  RetrofitCreator.getInstance().getRetrofit().create(API.class);

        Call<ResponseBody> task = api.getJson2(ETu.getText().toString(),ETp.getText().toString());
        task.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG, "onResponse: " + response.code());
                try {
                    String result2 = response.body().string();
                    Gson gson = new Gson();
                    aa a = gson.fromJson(result2, aa.class);
                    if (a.get结果().getResult().equals("注册成功")) {
                        Toast toast = Toast.makeText(LoginActivity.this, "注册成功，请登录", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(LoginActivity.this, "用户已存在，请重试", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }}
        );}

}
