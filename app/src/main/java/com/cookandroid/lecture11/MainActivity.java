package com.cookandroid.lecture11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<Integer, Class> runMap = new HashMap<Integer, Class>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnChecked(View v){
        try {openIntent(runMap.get(v.getId()));}
        catch (Exception e){
            Toast.makeText(getApplication(), "오류 발생. :" + e.toString(), Toast.LENGTH_LONG).show();}
    }

    public void openIntent(Class openJava){
        Intent intent = new Intent(getApplicationContext(), openJava);
        startActivity(intent);
    }
}