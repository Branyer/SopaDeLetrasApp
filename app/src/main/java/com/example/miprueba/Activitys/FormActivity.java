package com.example.miprueba.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miprueba.R;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class FormActivity extends AppCompatActivity {

    private EditText et1;
    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        et1 = (EditText)findViewById(R.id.dato_nombre);
        bt1 = (Button)findViewById(R.id.comenzar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("usuario.txt", Activity.MODE_PRIVATE));
                    archivo.write(et1.getText().toString());
                    archivo.flush();
                    archivo.close();
                }catch (IOException e){

                }

                try {
                    OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("nivel.txt", Activity.MODE_PRIVATE));
                    archivo.write("1");
                    archivo.flush();
                    archivo.close();
                }catch (IOException e){

                }

                Intent i = new Intent(FormActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}
