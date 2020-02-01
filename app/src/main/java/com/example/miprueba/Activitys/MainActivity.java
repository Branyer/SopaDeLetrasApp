package com.example.miprueba.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.miprueba.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private Button continuar, juego_nuevo, salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        continuar = (Button)findViewById(R.id.continuar);

        continuar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    InputStreamReader archivo2 = new InputStreamReader(openFileInput("nivel.txt"));
                    BufferedReader br2 = new BufferedReader(archivo2);
                    int act = Integer.parseInt(br2.readLine());
                    switch (act){

                        case 1:
                            Intent i = new Intent(MainActivity.this, Nivel1Activity.class);
                            startActivity(i);
                            finish();
                            break;
                        case  2:
                            Intent b = new Intent(MainActivity.this, Nivel2Activity.class);
                            startActivity(b);
                            finish();
                           break;
                        case 3:
                            Intent c = new Intent(MainActivity.this, Nivel3Activity.class);
                            startActivity(c);
                            finish();
                            break;
                        case 4:
                            Intent d = new Intent(MainActivity.this, Nivel4Activity.class);
                            startActivity(d);
                            finish();
                         break;
                        case 5:
                            Intent e = new Intent(MainActivity.this, Nivel5Activity.class);
                            startActivity(e);
                            finish();
                            break;
                        case 6:
                            Intent f = new Intent(MainActivity.this, Nivel6Activity.class);
                            startActivity(f);
                            finish();
                            break;

                    }

                }catch (IOException E){

                    try {
                        OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("nivel.txt", Activity.MODE_PRIVATE));
                        archivo.write("1");
                        archivo.flush();
                        archivo.close();
                    }catch (IOException e){

                    }
                }
            }
        });



        salir = (Button)findViewById(R.id.salir);
        salir.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        juego_nuevo = (Button)findViewById(R.id.juego_nuevo);
        juego_nuevo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {



           Intent i = new Intent(MainActivity.this, FormActivity.class);




           startActivity(i);
           finish();
            }
        });

        String archivos[] = fileList();

         if(ArchivoExiste(archivos, "usuario.txt")){

             try {
                 InputStreamReader archivo = new InputStreamReader(openFileInput("usuario.txt"));
                 BufferedReader br = new BufferedReader(archivo);
                 InputStreamReader archivo2 = new InputStreamReader(openFileInput("nivel.txt"));
                 BufferedReader br2 = new BufferedReader(archivo2);
                 continuar.setText("Continuar: " + br.readLine() + "( Nivel " + br2.readLine() + " )");
                 continuar.setVisibility(View.VISIBLE);
                 archivo.close();

             }catch (IOException e){

             }

         }else continuar.setVisibility(View.INVISIBLE);


    }


    private boolean ArchivoExiste(String archivos[], String archivo){

        for(int i=0; i<archivos.length; i++)
            if(archivo.equals((archivos[i])))
                return true;
            return false;
    }








}
