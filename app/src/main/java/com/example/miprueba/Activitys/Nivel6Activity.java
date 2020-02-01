package com.example.miprueba.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.miprueba.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Clases.Tablero;

public class Nivel6Activity extends AppCompatActivity {


    private TextView tv1;
    private TextView tv2;
    private Button bt1;
    private Button bt2;

    private Button a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,
            b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,
            c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,
            d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,
            e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,
            f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,
            g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g12,
            h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12,
            i1,i2,i3,i4,i5,i6,i7,i8,i9, i10,i11,i12,
            j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11,j12,
            k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11,k12,
            l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;

    Tablero tablero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel6);


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
        a8 = (Button)findViewById(R.id.a8);
        a9 = (Button)findViewById(R.id.a9);
        a10 = (Button)findViewById(R.id.a10);
        a11 = (Button)findViewById(R.id.a11);
        a12 = (Button)findViewById(R.id.a12);

        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);
        b5 = (Button)findViewById(R.id.b5);
        b6 = (Button)findViewById(R.id.b6);
        b7 = (Button)findViewById(R.id.b7);
        b8 = (Button)findViewById(R.id.b8);
        b9 = (Button)findViewById(R.id.b9);
        b10 = (Button)findViewById(R.id.b10);
        b11 = (Button)findViewById(R.id.b11);
        b12 = (Button)findViewById(R.id.b12);

        c1 = (Button)findViewById(R.id.c1);
        c2 = (Button)findViewById(R.id.c2);
        c3 = (Button)findViewById(R.id.c3);
        c4 = (Button)findViewById(R.id.c4);
        c5 = (Button)findViewById(R.id.c5);
        c6 = (Button)findViewById(R.id.c6);
        c7 = (Button)findViewById(R.id.c7);
        c8 = (Button)findViewById(R.id.c8);
        c9 = (Button)findViewById(R.id.c9);
        c10 = (Button)findViewById(R.id.c10);
        c11 = (Button)findViewById(R.id.c11);
        c12 = (Button)findViewById(R.id.c12);

        d1 = (Button)findViewById(R.id.d1);
        d2 = (Button)findViewById(R.id.d2);
        d3 = (Button)findViewById(R.id.d3);
        d4 = (Button)findViewById(R.id.d4);
        d5 = (Button)findViewById(R.id.d5);
        d6 = (Button)findViewById(R.id.d6);
        d7 = (Button)findViewById(R.id.d7);
        d8 = (Button)findViewById(R.id.d8);
        d9 = (Button)findViewById(R.id.d9);
        d10 = (Button)findViewById(R.id.d10);
        d11 = (Button)findViewById(R.id.d11);
        d12 = (Button)findViewById(R.id.d12);

        e1 = (Button)findViewById(R.id.e1);
        e2 = (Button)findViewById(R.id.e2);
        e3 = (Button)findViewById(R.id.e3);
        e4 = (Button)findViewById(R.id.e4);
        e5 = (Button)findViewById(R.id.e5);
        e6 = (Button)findViewById(R.id.e6);
        e7 = (Button)findViewById(R.id.e7);
        e8 = (Button)findViewById(R.id.e8);
        e9 = (Button)findViewById(R.id.e9);
        e10 = (Button)findViewById(R.id.e10);
        e11 = (Button)findViewById(R.id.e11);
        e12 = (Button)findViewById(R.id.e12);

        f1 = (Button)findViewById(R.id.f1);
        f2 = (Button)findViewById(R.id.f2);
        f3 = (Button)findViewById(R.id.f3);
        f4 = (Button)findViewById(R.id.f4);
        f5 = (Button)findViewById(R.id.f5);
        f6 = (Button)findViewById(R.id.f6);
        f7 = (Button)findViewById(R.id.f7);
        f8 = (Button)findViewById(R.id.f8);
        f9 = (Button)findViewById(R.id.f9);
        f10 = (Button)findViewById(R.id.f10);
        f11 = (Button)findViewById(R.id.f11);
        f12 = (Button)findViewById(R.id.f12);

        g1 = (Button)findViewById(R.id.g1);
        g2 = (Button)findViewById(R.id.g2);
        g3 = (Button)findViewById(R.id.g3);
        g4 = (Button)findViewById(R.id.g4);
        g5 = (Button)findViewById(R.id.g5);
        g6 = (Button)findViewById(R.id.g6);
        g7 = (Button)findViewById(R.id.g7);
        g8 = (Button)findViewById(R.id.g8);
        g9 = (Button)findViewById(R.id.g9);
        g10 = (Button)findViewById(R.id.g10);
        g11 = (Button)findViewById(R.id.g11);
        g12 = (Button)findViewById(R.id.g12);

        h1 = (Button)findViewById(R.id.h1);
        h2 = (Button)findViewById(R.id.h2);
        h3 = (Button)findViewById(R.id.h3);
        h4 = (Button)findViewById(R.id.h4);
        h5 = (Button)findViewById(R.id.h5);
        h6 = (Button)findViewById(R.id.h6);
        h7 = (Button)findViewById(R.id.h7);
        h8 = (Button)findViewById(R.id.h8);
        h9 = (Button)findViewById(R.id.h9);
        h10 = (Button)findViewById(R.id.h10);
        h11 = (Button)findViewById(R.id.h11);
        h12 = (Button)findViewById(R.id.h12);

        i1 = (Button)findViewById(R.id.i1);
        i2 = (Button)findViewById(R.id.i2);
        i3 = (Button)findViewById(R.id.i3);
        i4 = (Button)findViewById(R.id.i4);
        i5 = (Button)findViewById(R.id.i5);
        i6 = (Button)findViewById(R.id.i6);
        i7 = (Button)findViewById(R.id.i7);
        i8 = (Button)findViewById(R.id.i8);
        i9 = (Button)findViewById(R.id.i9);
        i10 = (Button)findViewById(R.id.i10);
        i11 = (Button)findViewById(R.id.i11);
        i12 = (Button)findViewById(R.id.i12);

        j1 = (Button)findViewById(R.id.j1);
        j2 = (Button)findViewById(R.id.j2);
        j3 = (Button)findViewById(R.id.j3);
        j4 = (Button)findViewById(R.id.j4);
        j5 = (Button)findViewById(R.id.j5);
        j6 = (Button)findViewById(R.id.j6);
        j7 = (Button)findViewById(R.id.j7);
        j8 = (Button)findViewById(R.id.j8);
        j9 = (Button)findViewById(R.id.j9);
        j10 = (Button)findViewById(R.id.j10);
        j11 = (Button)findViewById(R.id.j11);
        j12 = (Button)findViewById(R.id.j12);

        k1 = (Button)findViewById(R.id.k1);
        k2 = (Button)findViewById(R.id.k2);
        k3 = (Button)findViewById(R.id.k3);
        k4 = (Button)findViewById(R.id.k4);
        k5 = (Button)findViewById(R.id.k5);
        k6 = (Button)findViewById(R.id.k6);
        k7 = (Button)findViewById(R.id.k7);
        k8 = (Button)findViewById(R.id.k8);
        k9 = (Button)findViewById(R.id.k9);
        k10 = (Button)findViewById(R.id.k10);
        k11 = (Button)findViewById(R.id.k11);
        k12 = (Button)findViewById(R.id.k12);

        l1 = (Button)findViewById(R.id.l1);
        l2 = (Button)findViewById(R.id.l2);
        l3 = (Button)findViewById(R.id.l3);
        l4 = (Button)findViewById(R.id.l4);
        l5 = (Button)findViewById(R.id.l5);
        l6 = (Button)findViewById(R.id.l6);
        l7 = (Button)findViewById(R.id.l7);
        l8 = (Button)findViewById(R.id.l8);
        l9 = (Button)findViewById(R.id.l9);
        l10 = (Button)findViewById(R.id.l10);
        l11 = (Button)findViewById(R.id.l11);
        l12 = (Button)findViewById(R.id.l12);





        Button [][]mat = new Button[][]{{a1, a2, a3, a4, a5, a6, a7,a8,a9,a10,a11,a12},
                {b1, b2, b3, b4, b5, b6, b7,b8,b9,b10,b11,b12},
                {c1, c2, c3, c4, c5, c6, c7,c8,c9,c10,c11,c12},
                {d1, d2, d3, d4, d5, d6, d7,d8,d9,d10,d11,d12},
                {e1, e2, e3, e4, e5, e6, e7,e8,e9,e10,e11,e12},
                {f1, f2, f3, f4, f5, f6, f7,f8,f9,f10,f11,f12},
                {g1, g2, g3, g4, g5, g6, g7,g8,g9,g10,g11,g12},
                {h1, h2, h3, h4, h5, h6, h7,h8,h9,h10,h11,h12},
                {i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,},
                {j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11,j12},
                {k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11,k12},
                {l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12}};

        tablero = new Tablero(12,12,mat);
        tablero.generarTablero(this, 16, tv2);
        tablero.setOnTouch(this, tv2, Nivel6Activity.this);
        tablero.setOnClik(this,bt1,bt2,tv2,Nivel6Activity.this);
    }
}
