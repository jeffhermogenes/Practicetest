package com.example.practicetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    TextView tPageName, tSubject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tPageName = findViewById(R.id.tPageName2);
        tSubject = findViewById(R.id.tSubject2);
    }

    public void goBack(View v){
        Intent intent9 = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent9);


    }

    public void readIS(View v){
        try {
            FileInputStream fis = openFileInput("savedIS.txt");
            int readByte = -1;
            StringBuffer readData = new StringBuffer();
            while ((readByte=fis.read()) != -1){
                readData.append((char)readByte);
            }
            String page = readData.substring(0, readData.indexOf(" "));
            String subject = readData.substring(readData.indexOf(" ") + 1);
            tPageName.setText(page);
            tSubject.setText(subject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}