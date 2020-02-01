package com.example.miprueba.Activitys;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miprueba.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Clases.Tablero;

public class Nivel1Activity extends AppCompatActivity {


    private TextView tv1;
    private TextView tv2;
    private Button bt1;
    private Button bt2;

    private Button a1,a2,a3,a4,a5,a6,a7,
            b1,b2,b3,b4,b5,b6,b7,
            c1,c2,c3,c4,c5,c6,c7,
            d1,d2,d3,d4,d5,d6,d7,
            e1,e2,e3,e4,e5,e6,e7,
            f1,f2,f3,f4,f5,f6,f7,
            g1,g2,g3,g4,g5,g6,g7;

    Tablero tablero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel1);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tv1 = (TextView)findViewById(R.id.nombre);
        tv2 = (TextView)findViewById(R.id.pos);
        bt1 = (Button)findViewById(R.id.button3);
        bt2 = (Button)findViewById(R.id.button2);

        /**Leyendo el nombre del Usuario**/
        try {
            InputStreamReader archivo = new InputStreamReader(openFileInput("usuario.txt"));
            BufferedReader br = new BufferedReader(archivo);
            tv1.setText(br.readLine());
            archivo.close();
        }catch (IOException e){}

        a1 = (Button)findViewById(R.id.a1);
        a2 = (Button)findViewById(R.id.a2);
        a3 = (Button)findViewById(R.id.a3);
        a4 = (Button)findViewById(R.id.a4);
        a5 = (Button)findViewById(R.id.a5);
        a6 = (Button)findViewById(R.id.a6);
        a7 = (Button)findViewById(R.id.a7);

        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);
        b5 = (Button)findViewById(R.id.b5);
        b6 = (Button)findViewById(R.id.b6);
        b7 = (Button)findViewById(R.id.b7);

        c1 = (Button)findViewById(R.id.c1);
        c2 = (Button)findViewById(R.id.c2);
        c3 = (Button)findViewById(R.id.c3);
        c4 = (Button)findViewById(R.id.c4);
        c5 = (Button)findViewById(R.id.c5);
        c6 = (Button)findViewById(R.id.c6);
        c7 = (Button)findViewById(R.id.c7);

        d1 = (Button)findViewById(R.id.d1);
        d2 = (Button)findViewById(R.id.d2);
        d3 = (Button)findViewById(R.id.d3);
        d4 = (Button)findViewById(R.id.d4);
        d5 = (Button)findViewById(R.id.d5);
        d6 = (Button)findViewById(R.id.d6);
        d7 = (Button)findViewById(R.id.d7);

        e1 = (Button)findViewById(R.id.e1);
        e2 = (Button)findViewById(R.id.e2);
        e3 = (Button)findViewById(R.id.e3);
        e4 = (Button)findViewById(R.id.e4);
        e5 = (Button)findViewById(R.id.e5);
        e6 = (Button)findViewById(R.id.e6);
        e7 = (Button)findViewById(R.id.e7);

        f1 = (Button)findViewById(R.id.f1);
        f2 = (Button)findViewById(R.id.f2);
        f3 = (Button)findViewById(R.id.f3);
        f4 = (Button)findViewById(R.id.f4);
        f5 = (Button)findViewById(R.id.f5);
        f6 = (Button)findViewById(R.id.f6);
        f7 = (Button)findViewById(R.id.f7);

        g1 = (Button)findViewById(R.id.g1);
        g2 = (Button)findViewById(R.id.g2);
        g3 = (Button)findViewById(R.id.g3);
        g4 = (Button)findViewById(R.id.g4);
        g5 = (Button)findViewById(R.id.g5);
        g6 = (Button)findViewById(R.id.g6);
        g7 = (Button)findViewById(R.id.g7);

        Button [][]mat = new Button[][]{{a1, a2, a3, a4, a5, a6, a7},
                {b1, b2, b3, b4, b5, b6, b7},
                {c1, c2, c3, c4, c5, c6, c7},
                {d1, d2, d3, d4, d5, d6, d7},
                {e1, e2, e3, e4, e5, e6, e7},
                {f1, f2, f3, f4, f5, f6, f7},
                {g1, g2, g3, g4, g5, g6, g7}};

        tablero = new Tablero(7,7,mat);
        tablero.generarTablero(this, 6, tv2);
        tablero.setOnTouch(this, tv2, Nivel1Activity.this);
        tablero.setOnClik(this,bt1,bt2,tv2,Nivel1Activity.this);
    }
}
