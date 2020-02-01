package com.example.miprueba.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.miprueba.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Clases.Tablero;

public class Nivel3Activity extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private Button bt1;
    private Button bt2;

    private Button a1,a2,a3,a4,a5,a6,a7,a8,a9,
            b1,b2,b3,b4,b5,b6,b7,b8,b9,
            c1,c2,c3,c4,c5,c6,c7,c8,c9,
            d1,d2,d3,d4,d5,d6,d7,d8,d9,
            e1,e2,e3,e4,e5,e6,e7,e8,e9,
            f1,f2,f3,f4,f5,f6,f7,f8,f9,
            g1,g2,g3,g4,g5,g6,g7,g8,g9,
            h1,h2,h3,h4,h5,h6,h7,h8,h9,
            i1,i2,i3,i4,i5,i6,i7,i8,i9;

    Tablero tablero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel3);

        tv1 = (TextView)findViewById(R.id.nombre);
        tv2 = (TextView)findViewById(R.id.pos);
        bt1 = (Button)findViewById(R.id.button3);
        bt2 = (Button)findViewById(R.id.button2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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
        a8 = (Button)findViewById(R.id.a8);
        a9 = (Button)findViewById(R.id.a9);

        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);
        b5 = (Button)findViewById(R.id.b5);
        b6 = (Button)findViewById(R.id.b6);
        b7 = (Button)findViewById(R.id.b7);
        b8 = (Button)findViewById(R.id.b8);
        b9 = (Button)findViewById(R.id.b9);

        c1 = (Button)findViewById(R.id.c1);
        c2 = (Button)findViewById(R.id.c2);
        c3 = (Button)findViewById(R.id.c3);
        c4 = (Button)findViewById(R.id.c4);
        c5 = (Button)findViewById(R.id.c5);
        c6 = (Button)findViewById(R.id.c6);
        c7 = (Button)findViewById(R.id.c7);
        c8 = (Button)findViewById(R.id.c8);
        c9 = (Button)findViewById(R.id.c9);

        d1 = (Button)findViewById(R.id.d1);
        d2 = (Button)findViewById(R.id.d2);
        d3 = (Button)findViewById(R.id.d3);
        d4 = (Button)findViewById(R.id.d4);
        d5 = (Button)findViewById(R.id.d5);
        d6 = (Button)findViewById(R.id.d6);
        d7 = (Button)findViewById(R.id.d7);
        d8 = (Button)findViewById(R.id.d8);
        d9 = (Button)findViewById(R.id.d9);

        e1 = (Button)findViewById(R.id.e1);
        e2 = (Button)findViewById(R.id.e2);
        e3 = (Button)findViewById(R.id.e3);
        e4 = (Button)findViewById(R.id.e4);
        e5 = (Button)findViewById(R.id.e5);
        e6 = (Button)findViewById(R.id.e6);
        e7 = (Button)findViewById(R.id.e7);
        e8 = (Button)findViewById(R.id.e8);
        e9 = (Button)findViewById(R.id.e9);

        f1 = (Button)findViewById(R.id.f1);
        f2 = (Button)findViewById(R.id.f2);
        f3 = (Button)findViewById(R.id.f3);
        f4 = (Button)findViewById(R.id.f4);
        f5 = (Button)findViewById(R.id.f5);
        f6 = (Button)findViewById(R.id.f6);
        f7 = (Button)findViewById(R.id.f7);
        f8 = (Button)findViewById(R.id.f8);
        f9 = (Button)findViewById(R.id.f9);

        g1 = (Button)findViewById(R.id.g1);
        g2 = (Button)findViewById(R.id.g2);
        g3 = (Button)findViewById(R.id.g3);
        g4 = (Button)findViewById(R.id.g4);
        g5 = (Button)findViewById(R.id.g5);
        g6 = (Button)findViewById(R.id.g6);
        g7 = (Button)findViewById(R.id.g7);
        g8 = (Button)findViewById(R.id.g8);
        g9 = (Button)findViewById(R.id.g9);

        h1 = (Button)findViewById(R.id.h1);
        h2 = (Button)findViewById(R.id.h2);
        h3 = (Button)findViewById(R.id.h3);
        h4 = (Button)findViewById(R.id.h4);
        h5 = (Button)findViewById(R.id.h5);
        h6 = (Button)findViewById(R.id.h6);
        h7 = (Button)findViewById(R.id.h7);
        h8 = (Button)findViewById(R.id.h8);
        h9 = (Button)findViewById(R.id.h9);

        i1 = (Button)findViewById(R.id.i1);
        i2 = (Button)findViewById(R.id.i2);
        i3 = (Button)findViewById(R.id.i3);
        i4 = (Button)findViewById(R.id.i4);
        i5 = (Button)findViewById(R.id.i5);
        i6 = (Button)findViewById(R.id.i6);
        i7 = (Button)findViewById(R.id.i7);
        i8 = (Button)findViewById(R.id.i8);
        i9 = (Button)findViewById(R.id.i9);

        Button [][]mat = new Button[][]{{a1, a2, a3, a4, a5, a6, a7,a8,a9},
                {b1, b2, b3, b4, b5, b6, b7,b8,b9},
                {c1, c2, c3, c4, c5, c6, c7,c8,c9},
                {d1, d2, d3, d4, d5, d6, d7,d8,d9},
                {e1, e2, e3, e4, e5, e6, e7,e8,e9},
                {f1, f2, f3, f4, f5, f6, f7,f8,f9},
                {g1, g2, g3, g4, g5, g6, g7,g8,g9},
                {h1, h2, h3, h4, h5, h6, h7,h8,h9},
                {i1,i2,i3,i4,i5,i6,i7,i8,i9}};


        tablero = new Tablero(9,9,mat);
        tablero.generarTablero(this, 10, tv2);
        tablero.setOnTouch(this, tv2, Nivel3Activity.this);
        tablero.setOnClik(this,bt1,bt2,tv2,Nivel3Activity.this);


    }
}
