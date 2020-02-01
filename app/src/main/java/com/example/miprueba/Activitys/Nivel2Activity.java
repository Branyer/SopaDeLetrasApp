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

public class Nivel2Activity extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private Button bt1;
    private Button bt2;

    private Button a1,a2,a3,a4,a5,a6,a7,a8,
            b1,b2,b3,b4,b5,b6,b7,b8,
            c1,c2,c3,c4,c5,c6,c7,c8,
            d1,d2,d3,d4,d5,d6,d7,d8,
            e1,e2,e3,e4,e5,e6,e7,e8,
            f1,f2,f3,f4,f5,f6,f7,f8,
            g1,g2,g3,g4,g5,g6,g7,g8,
            h1,h2,h3,h4,h5,h6,h7,h8;

    Tablero tablero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel2);

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

        a1 = (Button)findViewById(R.id.a1_1);
        a2 = (Button)findViewById(R.id.a2_1);
        a3 = (Button)findViewById(R.id.a3_1);
        a4 = (Button)findViewById(R.id.a4_1);
        a5 = (Button)findViewById(R.id.a5_1);
        a6 = (Button)findViewById(R.id.a6_1);
        a7 = (Button)findViewById(R.id.a7_1);
        a8 = (Button)findViewById(R.id.a8_1);

        b1 = (Button)findViewById(R.id.b1_1);
        b2 = (Button)findViewById(R.id.b2_1);
        b3 = (Button)findViewById(R.id.b3_1);
        b4 = (Button)findViewById(R.id.b4_1);
        b5 = (Button)findViewById(R.id.b5_1);
        b6 = (Button)findViewById(R.id.b6_1);
        b7 = (Button)findViewById(R.id.b7_1);
        b8 = (Button)findViewById(R.id.b8_1);

        c1 = (Button)findViewById(R.id.c1_1);
        c2 = (Button)findViewById(R.id.c2_1);
        c3 = (Button)findViewById(R.id.c3_1);
        c4 = (Button)findViewById(R.id.c4_1);
        c5 = (Button)findViewById(R.id.c5_1);
        c6 = (Button)findViewById(R.id.c6_1);
        c7 = (Button)findViewById(R.id.c7_1);
        c8 = (Button)findViewById(R.id.c8_1);

        d1 = (Button)findViewById(R.id.d1_1);
        d2 = (Button)findViewById(R.id.d2_1);
        d3 = (Button)findViewById(R.id.d3_1);
        d4 = (Button)findViewById(R.id.d4_1);
        d5 = (Button)findViewById(R.id.d5_1);
        d6 = (Button)findViewById(R.id.d6_1);
        d7 = (Button)findViewById(R.id.d7_1);
        d8 = (Button)findViewById(R.id.d8_1);

        e1 = (Button)findViewById(R.id.e1_1);
        e2 = (Button)findViewById(R.id.e2_1);
        e3 = (Button)findViewById(R.id.e3_1);
        e4 = (Button)findViewById(R.id.e4_1);
        e5 = (Button)findViewById(R.id.e5_1);
        e6 = (Button)findViewById(R.id.e6_1);
        e7 = (Button)findViewById(R.id.e7_1);
        e8 = (Button)findViewById(R.id.e8_1);

        f1 = (Button)findViewById(R.id.f1_1);
        f2 = (Button)findViewById(R.id.f2_1);
        f3 = (Button)findViewById(R.id.f3_1);
        f4 = (Button)findViewById(R.id.f4_1);
        f5 = (Button)findViewById(R.id.f5_1);
        f6 = (Button)findViewById(R.id.f6_1);
        f7 = (Button)findViewById(R.id.f7_1);
        f8 = (Button)findViewById(R.id.f8_1);

        g1 = (Button)findViewById(R.id.g1_1);
        g2 = (Button)findViewById(R.id.g2_1);
        g3 = (Button)findViewById(R.id.g3_1);
        g4 = (Button)findViewById(R.id.g4_1);
        g5 = (Button)findViewById(R.id.g5_1);
        g6 = (Button)findViewById(R.id.g6_1);
        g7 = (Button)findViewById(R.id.g7_1);
        g8 = (Button)findViewById(R.id.g8_1);

        h1 = (Button)findViewById(R.id.h1_1);
        h2 = (Button)findViewById(R.id.h2_1);
        h3 = (Button)findViewById(R.id.h3_1);
        h4 = (Button)findViewById(R.id.h4_1);
        h5 = (Button)findViewById(R.id.h5_1);
        h6 = (Button)findViewById(R.id.h6_1);
        h7 = (Button)findViewById(R.id.h7_1);
        h8 = (Button)findViewById(R.id.h8_1);

        Button [][]mat = new Button[][]{{a1, a2, a3, a4, a5, a6, a7,a8},
                {b1, b2, b3, b4, b5, b6, b7,b8},
                {c1, c2, c3, c4, c5, c6, c7,c8},
                {d1, d2, d3, d4, d5, d6, d7,d8},
                {e1, e2, e3, e4, e5, e6, e7,e8},
                {f1, f2, f3, f4, f5, f6, f7,f8},
                {g1, g2, g3, g4, g5, g6, g7,g8},
                {h1, h2, h3, h4, h5, h6, h7,h8}};


        tablero = new Tablero(8,8,mat);
        tablero.generarTablero(this, 8, tv2);
        tablero.setOnTouch(this, tv2, Nivel2Activity.this);
        tablero.setOnClik(this,bt1,bt2,tv2,Nivel2Activity.this);

    }
}
