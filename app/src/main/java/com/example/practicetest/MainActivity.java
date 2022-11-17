package com.example.practicetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextView tPageName, tSubject;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tPageName = findViewById(R.id.tPageName);
        tSubject = findViewById(R.id.tSubject);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext();
            }
        });
    }

    private void goNext() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        startActivity(intent);
    }

    public void saveIS(View v) {
        String name = tPageName.getText().toString();
        String section = tSubject.getText().toString();
        String data = name + " " + section;

        FileOutputStream fos = null;
        try {
            fos = openFileOutput( "savedIS.txt", Context.MODE_PRIVATE);
            fos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "note has been saved", Toast.LENGTH_SHORT).show();
    }
    public void saveIC(View v) {
        String name = tPageName.getText().toString();
        String section = tSubject.getText().toString();
        String data = name + " " + section;
        FileOutputStream fos = null;
        try {
            File folder;
            folder = getCacheDir();
            File file = new File(folder, "savedIC.txt");
            fos = new FileOutputStream(file);
            fos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "saved the data...", Toast.LENGTH_SHORT).show();
    }
    public void saveEC(View v) {
        String name = tPageName.getText().toString();
        String section = tSubject.getText().toString();
        String data = name + " " + section;
        FileOutputStream fos = null;
        try {
            File folder;
            folder = getExternalCacheDir();
            File file = new File(folder, "savedEC.txt");
            fos = new FileOutputStream(file);
            fos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "saved the data...", Toast.LENGTH_SHORT).show();
    }
    public void saveES (View v){
        String name = tPageName.getText().toString();
        String section = tSubject.getText().toString();
        String data = name + " " + section;
        FileOutputStream fos = null;
        try {
            File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(path, "savedES.txt");


            fos.write(data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "saved the data...", Toast.LENGTH_SHORT).show();
    }
}