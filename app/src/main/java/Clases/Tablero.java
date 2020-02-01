package Clases;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.SoundPool;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.example.miprueba.Activitys.FormActivity;
import com.example.miprueba.Activitys.MainActivity;
import com.example.miprueba.Activitys.Nivel1Activity;
import com.example.miprueba.Activitys.Nivel2Activity;
import com.example.miprueba.Activitys.Nivel3Activity;
import com.example.miprueba.Activitys.Nivel4Activity;
import com.example.miprueba.Activitys.Nivel5Activity;
import com.example.miprueba.Activitys.Nivel6Activity;
import com.example.miprueba.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ConcurrentNavigableMap;

import static androidx.core.content.ContextCompat.startActivity;
import static java.lang.StrictMath.abs;

public class Tablero  {

    private int row;
    private int col;
    private Button  [][] matBut;
    private int  [][]matInt;
    private int [][]matCompletados;
    private List <String>palabrasBus;
    private  List <String> palabrasEnc;
    private  List <String> palabrasNoEnc;
    private List PalabraSelec = new LinkedList();
    private List <Punto>Points = new LinkedList<Punto>();
    private int direccion=0;
    private  int iter = 0;
    private List<Punto> comienzoPalabras;
    private List<Puntos> direccionPalabras;
    private List Colors;


    public Tablero(){ }

    public Tablero(int row, int col, Button [][] matBut ){

        this.row = row;
        this.col = col;
        this.matBut = matBut;
        palabrasBus = new LinkedList<String>();
        palabrasEnc = new LinkedList<String>();
        palabrasNoEnc = new LinkedList<String>();
        comienzoPalabras = new LinkedList<Punto>();
        direccionPalabras = new LinkedList<Puntos>();
        Colors = new LinkedList();

        for(int i=1; i<17; i++) Colors.add(i);

        matInt = new int[row][col];
        matCompletados = new int [row][col];
        for(int i=0; i<row; i++)
            for(int j=0; j<row;j++){

                matInt[i][j]=0;
                matCompletados[i][j]=0;

            }
    }

    public void generarTablero( Context context, int pal, TextView tv2){

        try {

            InputStream fraw = leer_archivo(row-6, context);
            BufferedReader br = new BufferedReader(new InputStreamReader(fraw));

            String linea=br.readLine();
            List palabras  = new LinkedList();

            while(linea!=null){
                palabras.add(linea);
               linea =  br.readLine();
            }

            fraw.close();
            int n = 0;
            do{
                Random aleatorio = new Random(System.currentTimeMillis());
                int ram = aleatorio.nextInt(palabras.size());
                String cad = (String)palabras.get(ram);

                Vector <Puntos> posibilidades = new Vector<>();
                int contaux=0;
                int index = 0;
                for(int i=0; i<row; i++)
                   for(int j=0; j<col; j++){

                       String Caux = Character.toString(cad.charAt(0));

                       if(matBut[i][j].getText().toString().equals(" ") || matBut[i][j].getText().toString().equals(Caux)){

                           Puntos aux1 = new Puntos();
                           aux1.puntos = new Vector<>();
                           int cont = cad.length();
                           //Validar Arriba

                           int k=0;

                           do{

                               if(i-k<0) break;

                               if(matBut[i-k][j].getText().toString().equals(" ") || matBut[i-k][j].getText().toString().equals(Character.toString(cad.charAt(k)))){

                                   aux1.puntos.add(new Punto(i-k,j,Character.toString(cad.charAt(k)),"Arriba"));
                                   cont--;
                               }
                               else break;

                               k++;

                           }while(cont>0);

                           if(cont==0){


                                posibilidades.add(aux1);
                               // Toast.makeText(context, "i:" + aux.puntos.size(), Toast.LENGTH_LONG).show();
                                contaux++;

                           }

                           cont = cad.length();
                           //Validar Abajo

                           k=0;
                           Puntos aux2 = new Puntos();
                           aux2.puntos = new Vector<>();

                           do{

                               if(i+k==row) break;
                               if(matBut[i+k][j].getText().toString().equals(" ") || matBut[i+k][j].getText().toString().equals(Character.toString(cad.charAt(k)))){
                                   aux2.puntos.add(new Punto(i+k,j,Character.toString(cad.charAt(k)),"Abajo"));
                                   cont--;
                               }
                               else break;

                               k++;


                           }while(cont>0);

                           if(cont==0){
                               contaux++;
                               posibilidades.add(aux2);

                           }

                           cont = cad.length();
                           //Validar Izquierda
                           k=0;

                           Puntos aux3 = new Puntos();
                           aux3.puntos = new Vector<>();
                           do{

                               if(j-k<0) break;
                               if(matBut[i][j-k].getText().toString().equals(" ") || matBut[i][j-k].getText().toString().equals(Character.toString(cad.charAt(k)))){
                                  aux3.puntos.add(new Punto(i,j-k,Character.toString(cad.charAt(k)),"Izquierda"));
                                   cont--;
                               }
                               else break;

                               k++;

                           }while(cont>0);

                           if(cont==0){
                               contaux++;
                               posibilidades.add(aux3);

                           }

                           cont = cad.length();
                           //Validar Derecha
                           k=0;
                           Puntos aux4 = new Puntos();
                           aux4.puntos = new Vector<>();

                           do{
                               if(j+k==col) break;
                               if(matBut[i][j+k].getText().toString().equals(" ") || matBut[i][j+k].getText().toString().equals(Character.toString(cad.charAt(k)))) {
                                  aux4.puntos.add(new Punto(i,j+k,Character.toString(cad.charAt(k)),"Derecha"));
                                   cont--;
                               }
                               else break;
                               k++;
                           }while(cont>0);

                           if(cont==0){
                               contaux++;
                               posibilidades.add(aux4);
                           }

                           cont = cad.length();
                           //Validar Diagonal Arriba Izquierda
                           k=0;
                           Puntos aux5 = new Puntos();
                           aux5.puntos = new Vector<>();
                           do{

                               if(j-k<0 ||i-k<0) break;
                               if(matBut[i-k][j-k].getText().toString().equals(" ") || matBut[i-k][j-k].getText().toString().equals(Character.toString(cad.charAt(k)))) {
                                   aux5.puntos.add(new Punto(i-k,j-k,Character.toString(cad.charAt(k)),"Arriba Izquierda"));
                                   cont--;
                               }
                               else break;
                               k++;
                           }while(cont>0);

                           if(cont==0){
                               contaux++;
                              posibilidades.add(aux5);
                           }
                           cont = cad.length();
                           //Validar Diagonal Arriba Derecha
                           k=0;
                           Puntos aux6 = new Puntos();
                           aux6.puntos = new Vector<>();

                           do{
                               if(j+k>=col ||i-k<0) break;
                               if(matBut[i-k][j+k].getText().toString().equals(" ") || matBut[i-k][j+k].getText().toString().equals(Character.toString(cad.charAt(k)))){
                                   aux6.puntos.add(new Punto(i-k,j+k,Character.toString(cad.charAt(k)), "Arriba Dercha"));
                                   cont--;
                               }
                               else break;
                               k++;
                           }while(cont>0);

                           if(cont==0){
                               contaux++;
                               posibilidades.add(aux6);

                           }

                           cont = cad.length();
                           //Validar Diagonal Abajo Izquierda
                           Puntos aux7 = new Puntos();
                           aux7.puntos = new Vector<>();
                           k=0;

                           do{
                               if(j-k<0 ||i+k>=row) break;

                               if(matBut[i+k][j-k].getText().toString().equals(" ") || matBut[i+k][j-k].getText().toString().equals(Character.toString(cad.charAt(k)))){
                                  aux7.puntos.add(new Punto(i+k,j-k,Character.toString(cad.charAt(k)),"Abajo Izquierda"));
                                   cont--;
                               }
                               else break;
                               k++;
                           }while(cont>0);

                           if(cont==0){
                               contaux++;
                               posibilidades.add(aux7);
                           }

                           cont = cad.length();
                           //Validar Diagonal Abajo Derecha
                           Puntos aux8 = new Puntos();
                           aux8.puntos = new Vector<>();
                           k=0;

                           do{
                               if(j+k>=col ||i+k>=row) break;

                               if(matBut[i+k][j+k].getText().toString().equals(" ") || matBut[i+k][j+k].getText().toString().equals(Character.toString(cad.charAt(k)))) {
                                   aux8.puntos.add(new Punto(i+k,j+k,Character.toString(cad.charAt(k)), "Abajo Derecha"));
                                   cont--;
                               }
                               else break;
                               k++;
                           }while(cont>0);

                           if(cont==0) posibilidades.add(aux8);
                       }
                   }

                if (posibilidades.size() > 0) {

                    aleatorio.setSeed(System.currentTimeMillis());
                    int ramdom = aleatorio.nextInt(contaux);
                    comienzoPalabras.add(posibilidades.get(ramdom).puntos.get(0));
                    direccionPalabras.add(n,posibilidades.get(ramdom));

                    for (int i = 0; i < posibilidades.get(ramdom).puntos.size(); i++)
                        matBut[posibilidades.get(ramdom).puntos.get(i).geti()][posibilidades.get(ramdom).puntos.get(i).getj()].setText(posibilidades.get(ramdom).puntos.get(i).getLetra());

                    posibilidades.clear();
                    palabrasBus.add(n,(String)palabras.get(ram));
                    palabrasNoEnc.add(n,(String)palabras.get(ram));
                    tv2.setText(tv2.getText() + " " + (n+1) +". " + palabras.get(ram)+ " ");
                    if((n+1)%3==0) tv2.setText(tv2.getText()+ "\n");
                    palabras.remove(ram);
                    n++;
                }else palabras.remove(ram);
            }while(n<pal);

            Random aleatorio = new Random(System.currentTimeMillis());
            for(int i=0; i<row; i++)
                for(int j=0; j<col; j++)
                    if(matBut[i][j].getText().toString().equals(" ")){
                        int ram = aleatorio.nextInt(26);
                        matBut[i][j].setText(this.Abc(ram));
                    }


        }catch (IOException e){}
    }

    public String Abc(int i){

        String []abc = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        return abc[i];
    }


    public void setOnTouch(final Context context, final TextView tv2, final Activity activity){

        for(int i=0; i<row; i++){
            for(int j=0; j<row; j++){

                matBut[i][j].setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        Button aux = (Button)v;

                        if(event.getAction()==MotionEvent.ACTION_MOVE){

                            for(int i=0; i<row;i++){
                                for(int j=0; j<col; j++){

                                    Rect r = new Rect();
                                    matBut[i][j].getHitRect(r);

                                    int movValido = 1;
                                    int dir = 0;

                                    if(Points.size()==1) iter=0;

                                    if(r.contains((int)( event.getX()+aux.getX()), (int) (event.getY()+aux.getY())) ) {//You are in 2nd view

                                        if (Points.size() >= 2 && matInt[i][j] == 1) { //regresarme

                                            Punto auxPunto1 = Points.get(Points.size() - 2);
                                            Punto auxPunto2 = Points.get(Points.size() - 1);

                                            if ((auxPunto1.geti() == i && auxPunto1.getj() == j)) {

                                                borrarPunto(auxPunto2, Points.size() - 1);
                                                if (Points.size() == 1) direccion = 0;

                                                break;
                                            }
                                        }

                                        if (Points.size() > 0) {

                                            Punto auxPunto0 = Points.get(Points.size() - 1);
                                            int iAux = i - auxPunto0.geti();
                                            int jAux = j - auxPunto0.getj();

                                            if (iAux == 1 && jAux == 0) dir = 1;  //abajo
                                            else if (iAux == -1 && jAux == 0) dir = 2;//arriba
                                            else if (iAux == 0 && jAux == 1)  dir = 3; // derecha
                                            else if (iAux == 0 && jAux == -1)  dir = 4;//izquierda
                                            else if (iAux == 1 && jAux == 1) { //abajo derecha
                                                dir = 5;
                                                if(Points.size()==1){
                                                    direccion=5;
                                                    iter++;
                                                }
                                            } else if (iAux == 1 && jAux == -1) { //abajo izquierda
                                                dir = 6;
                                                if(Points.size()==1){
                                                    direccion=6;
                                                    iter++;
                                                }
                                            } else if (iAux == -1 && jAux == 1) {//arriba derecha
                                                dir = 7;
                                                if(Points.size()==1){
                                                    direccion=7;
                                                    iter++;
                                                }
                                            } else if (iAux == -1 && jAux == -1) {//arriba izquierda
                                                dir = 8;
                                                if(Points.size()==1){
                                                    direccion=8;
                                                    iter++;
                                                }
                                            } else movValido = 0;
                                        }

                                        if (iter>0 && direccion != dir) movValido = 0;

                                        if (movValido == 1) {

                                            if (matInt[i][j] <= 0) { //avanzar

                                                agregarPunto(new Punto(i,j));
                                                if (Points.size() == 3 && iter == 0) { //definiendo la direccion del movimiento

                                                    Punto auxPunto0 = Points.get(Points.size() - 1);
                                                    Punto auxPunto3 = Points.get(0);
                                                    int iAux = auxPunto0.geti() - auxPunto3.geti();
                                                    int jAux = auxPunto0.getj() - auxPunto3.getj();

                                                    if (iAux == 2 && jAux == 0) { //abajo
                                                        direccion = 1;
                                                        iter++;
                                                    } else if (iAux == -2 && jAux == 0) {//arriba
                                                        direccion = 2;
                                                        iter++;
                                                    } else if (iAux == 0 && jAux== 2) { // derecha
                                                        direccion = 3;
                                                        iter++;
                                                    } else if (iAux == 0 && jAux == -2) { //izquierda
                                                        direccion = 4;
                                                        iter++;
                                                    } else if (iAux == 1 && jAux == 1) { //abajo derecha
                                                        borrarPunto(Points.get(1), 1);
                                                        iter++;
                                                        direccion = 5;
                                                    } else if (iAux == 1 && jAux == -1) { //abajo izquierda
                                                        borrarPunto(Points.get(1), 1);
                                                        iter++;
                                                        direccion = 6;
                                                    } else if (iAux == -1 && jAux == 1) {//arriba derecha
                                                        borrarPunto(Points.get(1), 1);
                                                        iter++;
                                                        direccion = 7;
                                                    } else if (iAux == -1 && jAux == -1) {//arriba izquierda
                                                        borrarPunto(Points.get(1), 1);
                                                        iter++;
                                                        direccion = 8;
                                                    }else if ((abs(iAux)==2 && abs(jAux)==1) || (abs(iAux)==1 && abs(jAux)==2)){
                                                        borrarPunto(Points.get(2),Points.size() - 1);
                                                        direccion=0;
                                                        iter=0;
                                                    }
                                                }
                                                //if points == 3
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }else if(event.getAction()==MotionEvent.ACTION_UP){
                            String palabra1 = "";
                            int enc=0;
                            int yaEsta = 0;
                            String palabra2 = "";

                            for(int i=0; i<PalabraSelec.size(); i++)palabra1+=PalabraSelec.get(i);
                            for(int i=PalabraSelec.size()-1; i>=0; i--) palabra2+=PalabraSelec.get(i);

                            for(int i=0; i<palabrasEnc.size(); i++)
                                if(palabrasEnc.get(i).equals(palabra1)||palabrasEnc.get(i).equals(palabra2)) yaEsta=1;

                            for(int j=0; j<palabrasBus.size() && yaEsta==0 ; j++){

                                if(palabrasBus.get(j).equals(palabra1) ||palabrasBus.get(j).equals(palabra2)){
                                    enc=1;
                                    palabrasEnc.add(palabrasBus.get(j));
                                    Toast.makeText(context, "Encontraste la palabra: " + palabrasBus.get(j), Toast.LENGTH_SHORT).show();
                                    tv2.setText("");
                                    palabrasNoEnc.remove(palabrasBus.get(j));
                                    int encBus=0;
                                    for(int m=0; m<palabrasBus.size(); m++){
                                        encBus=0;
                                        for(int k=0; k<palabrasEnc.size(); k++){
                                            if(palabrasBus.get(m).equals(palabrasEnc.get(k))){
                                                encBus=1;
                                                break;
                                            }
                                        }
                                        if(encBus==0)tv2.setText(tv2.getText() + " "+ (m+1) + "." + palabrasBus.get(m));
                                        if((m+1)%3==0)tv2.setText(tv2.getText() + "\n");
                                    }
                                    if(palabrasEnc.size()==palabrasBus.size()){
                                        Toast.makeText(context, "Completaste el nivel " + (row-6), Toast.LENGTH_LONG).show();
                                        cambiar_nivel((row-6), activity);

                                    }
                                    break;
                                }
                            }
                            int tam = Points.size();
                            if(enc==0) for(int i=0; i<tam; i++){
                                Punto pt = Points.get(i);
                                matInt[pt.geti()][pt.getj()] = 0;
                                setColor(pt);
                            } else {

                                Random aleatorio = new Random(System.currentTimeMillis());
                                int ram = aleatorio.nextInt(Colors.size());

                                for(int i=0; i<Points.size(); i++){
                                    matCompletados[Points.get(i).geti()][Points.get(i).getj()]=(int)Colors.get(ram);//aca hay que poner un random del 1 al 16
                                    matInt[Points.get(i).geti()][Points.get(i).getj()] = 0;
                                    setColor(Points.get(i));
                                }
                                Colors.remove(ram);
                            }
                            iter=0;
                            direccion=0;
                            Points.clear();
                            PalabraSelec.clear();
                        }
                        return true;
                    }
                });
            }
        }
    }


    public void borrarPunto(Punto pt, int index){
        matInt[pt.geti()][pt.getj()] = 0;
        setColor(pt);
        Points.remove(index);
        PalabraSelec.remove(index);
    }

    public void agregarPunto(Punto pt){
        PalabraSelec.add(matBut[pt.geti()][pt.getj()].getText());
        matInt[pt.geti()][pt.getj()] = 1;
        matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.touch);
        matBut[pt.geti()][pt.getj()].setTextColor(Color.WHITE);
        Points.add(pt);
    }

    public void  setColor(Punto pt){

        switch (matCompletados[pt.geti()][pt.getj()]){

            case 0: //color blanco estandar
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.esferas);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.BLACK);
                break;
            case 1: //color naranja palenc
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.naranja);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.BLACK);
                break;
            case 2://color vinotinto palenc
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.vinotinto);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.WHITE);
                break;
            case 3://color verde palenc
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.verde);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.WHITE);
                break;
            case 4://color lila palenc
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.lila);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.BLACK);
                break;
            case 5://color gris palenc
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.gris);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.WHITE);
                break;
            case 6://color amarillo palenc
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.amarillo);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.BLACK);
                break;
            case 7://color verde oscuro palenc
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.verde_oscuro);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.WHITE);
                break;
            case 8: //color gris claro palenc
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.gris_claro);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.BLACK);
                break;
            case 9://color gris claro palenc
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.marron);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.WHITE);
                break;
            case 10://color rosado palido claro palenc
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.rosado_palido);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.BLACK);
                break;
            case 11://color rosado palido claro palenc
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.mostaza);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.WHITE);
                break;
            case 12://color fosforesente claro palenc
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.fosforesente);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.BLACK);
                break;
            case 13://color rosado intenso claro palenc
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.rosado_intenso);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.WHITE);
                break;
            case 14://color azul verdoso claro palenc
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.azul_verdoso);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.BLACK);
                break;
            case 15://color azul oscuro claro palenc
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.azul_oscuro);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.WHITE);
                break;
            case 16://color azul oscuro claro palenc
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.azul_claro);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.BLACK);
                break;
            case 17:
                //color morado pista palabra completa
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.morado);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.WHITE);
                break;
            case 18:
                //color azul una sola
                matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.azul);
                matBut[pt.geti()][pt.getj()].setTextColor(Color.YELLOW);
                break;

        }
    }

    public  void cambiar_nivel(int i, Activity activity){

        switch (i){

            case 1:
                Intent a = new Intent(activity, Nivel2Activity.class);
                activity.startActivity(a);
                activity.finish();
                try {
                    OutputStreamWriter archivo = new OutputStreamWriter(activity.openFileOutput("nivel.txt", Activity.MODE_PRIVATE));
                    archivo.write("2");
                    archivo.flush();
                    archivo.close();
                }catch (IOException e){
                }
                break;
            case 2:
                Intent b = new Intent(activity, Nivel3Activity.class);
                activity.startActivity(b);
                activity.finish();
                try {
                    OutputStreamWriter archivo = new OutputStreamWriter(activity.openFileOutput("nivel.txt", Activity.MODE_PRIVATE));
                    archivo.write("3");
                    archivo.flush();
                    archivo.close();
                }catch (IOException e){
                }
                break;
            case 3:
                Intent d = new Intent(activity, Nivel4Activity.class);
                activity.startActivity(d);
                activity.finish();
                try {
                    OutputStreamWriter archivo = new OutputStreamWriter(activity.openFileOutput("nivel.txt", Activity.MODE_PRIVATE));
                    archivo.write("4");
                    archivo.flush();
                    archivo.close();
                }catch (IOException e){
                }
                break;
            case 4:
                Intent e = new Intent(activity, Nivel5Activity.class);
                activity.startActivity(e);
                activity.finish();
                try {
                    OutputStreamWriter archivo = new OutputStreamWriter(activity.openFileOutput("nivel.txt", Activity.MODE_PRIVATE));
                    archivo.write("5");
                    archivo.flush();
                    archivo.close();
                }catch (IOException x){
                }
                break;
            case 5:
                Intent f = new Intent(activity, Nivel6Activity.class);
                activity.startActivity(f);
                activity.finish();
                try {
                    OutputStreamWriter archivo = new OutputStreamWriter(activity.openFileOutput("nivel.txt", Activity.MODE_PRIVATE));
                    archivo.write("6");
                    archivo.flush();
                    archivo.close();
                }catch (IOException x){
                }
                break;
            case 6:
                Intent c = new Intent(activity, MainActivity.class);
                activity.startActivity(c);
                activity.finish();
                break;



        }
    }

    public  InputStream leer_archivo(int i, Context context){

        switch (i){

            case 1:
               return context.getResources().openRawResource(R.raw.nivel1);
            case 2:
                return context.getResources().openRawResource(R.raw.nivel2);
            case 3:
                return context.getResources().openRawResource(R.raw.nivel3);
            case 4:
                return context.getResources().openRawResource(R.raw.nivel4);
            case 5:
                return context.getResources().openRawResource(R.raw.nivel5);
            case 6:
                return context.getResources().openRawResource(R.raw.nivel6);


        }

return  new InputStream() {
    @Override
    public int read() throws IOException {
        return 0;
    }
};
    }



    public void setOnClik(final Context context, final Button bt1, final Button bt2, final TextView tv2, final Activity activity){

        bt1.setOnClickListener(new View.OnClickListener() { //descubrir una palabra completa
            @Override
            public void onClick(View v) {

                int ram = 0;
                Random aleatorio = new Random(System.currentTimeMillis());
                ram = aleatorio.nextInt(palabrasNoEnc.size());
                String aux = "";
                Puntos pts = new Puntos();
                int index = 0;
                for(int i=0; i<direccionPalabras.size(); i++){
                            aux="";
                    for(int j=0; j<direccionPalabras.get(i).puntos.size(); j++){
                        Punto pt  =direccionPalabras.get(i).puntos.get(j);
                        aux += pt.getLetra();
                    }
                    if(aux.equals(palabrasNoEnc.get(ram))){
                        index = i;
                        pts = direccionPalabras.get(i);
                        i=direccionPalabras.size();
                    }
                }
                for(int i=0; i<direccionPalabras.get(index).puntos.size(); i++){
                    Punto pt  =pts.puntos.get(i);
                    matCompletados[pt.geti()][pt.getj()]=17;
                    matInt[pt.geti()][pt.getj()] = 0;
                    matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.morado);
                    matBut[pt.geti()][pt.getj()].setTextColor(Color.WHITE);
                }
                tv2.setText("");
                int encBus;
                palabrasEnc.add(aux);
                palabrasNoEnc.remove(aux);

                for(int m=0; m<palabrasBus.size(); m++){
                    encBus=0;
                    for(int k=0; k<palabrasEnc.size(); k++){

                        if(palabrasBus.get(m).equals(palabrasEnc.get(k))){
                            encBus=1;
                            break;
                        }
                    }
                    if(encBus==0)tv2.setText(tv2.getText() + " "+ (m+1) + "." + palabrasBus.get(m));
                    if((m+1)%3==0)tv2.setText(tv2.getText() + "\n");
                }

                if(palabrasEnc.size()==palabrasBus.size()){
                    Toast.makeText(context, "Completaste el nivel " + (row-6), Toast.LENGTH_LONG).show();
                    cambiar_nivel(row-6, activity);
                }
                bt1.setVisibility(View.INVISIBLE);
            }
        });


       bt2.setOnClickListener(new View.OnClickListener() { //descubrir la primera letra
           @Override
           public void onClick(View v) {

               int ram = 0;
               Random aleatorio = new Random(System.currentTimeMillis());
               ram = aleatorio.nextInt(palabrasNoEnc.size());

               String aux = "";
               Puntos pts = new Puntos();
               int index = 0;
               for(int i=0; i<direccionPalabras.size(); i++){
                   aux="";
                   for(int j=0; j<direccionPalabras.get(i).puntos.size(); j++){
                       Punto pt  =direccionPalabras.get(i).puntos.get(j);
                       aux += pt.getLetra();
                   }

                   if(aux.equals(palabrasNoEnc.get(ram))){
                       index = i;
                       pts = direccionPalabras.get(i);
                       i=direccionPalabras.size();
                   }
               }
               Punto pt  =pts.puntos.get(0);
               matCompletados[pt.geti()][pt.getj()]=18;
               matInt[pt.geti()][pt.getj()] = 0;
               matBut[pt.geti()][pt.getj()].setBackgroundResource(R.drawable.azul);
               matBut[pt.geti()][pt.getj()].setTextColor(Color.YELLOW);
           }
       });
    }
}


