package Clases;

public class Punto {

    private int i;
    private int j;
    private String letra;
    private String dir;

    public Punto(){}

    public Punto(int i, int j, String letra, String dir){
        this.i = i;
        this.j = j;
        this.letra = letra;
        this.dir = dir;
    }

    public Punto(int i, int j){
        this.i = i;
        this.j = j;
    }

    public int geti(){
        return this.i;
    }

    public int getj(){
        return this.j;
    }

    public String getLetra(){
        return this.letra;
    }

    public String getDir(){return this.dir;}

}
