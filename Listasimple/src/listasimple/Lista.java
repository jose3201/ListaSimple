/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasimple;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author jdol
 */
public class Lista {
    private Nodo primero;
    private Nodo ultimo;
    private int tama;
    public  Lista(){
    this.primero=null;
    this.ultimo=null;
    this.tama=0;
    }

    public int getTama() {
        return tama;
    }

    public void setTama(int tama) {
        this.tama = tama;
    }
    
    public void InsertarUltimo(int d){
        Nodo nuevo=new Nodo(d);
        if (primero==null) {
            primero=nuevo;
            tama++;
        }else if (tama==1) {
            ultimo=nuevo;
            primero.setSiguiente(ultimo);
            tama++;
        }else {
            Nodo aux=ultimo;
            ultimo=nuevo;
            aux.setSiguiente(ultimo);
            tama++;
        }
    }
    
    public boolean Buscar(int d){
        Nodo aux =primero;
        while (aux!=null) {            
            if (aux.getDato()==d) {
                return true;
            }
            aux=aux.getSiguiente();
        }
        return false;
    }
    public void Eliminar(int d){
        Nodo aux=primero;
        if (Buscar(d)) {
            if (aux.getDato()==d) {
                primero=primero.getSiguiente();
                tama--;
            }else{
              Nodo aux2=new Nodo();
            while (aux!=null && aux.getDato()!=d) {                
                aux2=aux;
                aux=aux.getSiguiente();
            }
            if (aux.getSiguiente()==null) {
                aux2.setSiguiente(null);
                ultimo=aux2;
                tama--;
            } else {
                Nodo aux3=aux.getSiguiente();
                aux2.setSiguiente(aux3);
                aux.setSiguiente(null);
                tama--;
            }
            }
        }else{
            System.out.println("lista vacia o no se encontro dato");
        }
    }
    public void imprimir(){
    Nodo aux=primero;
        if (aux!=null) {
            while (aux!=null) {                
                System.out.print("Dato: "+aux.getDato()+" -> ");
                aux=aux.getSiguiente();
            }
            System.out.println("");
            System.out.println("tamaño: "+tama);
        }else{
        System.out.println("lista vacia");
        }
    }
    public void GenerarGraphyz(){
        try {
            //escribir dot
            FileWriter codigo = new FileWriter("listasimple" + ".dot");
            PrintWriter documento = new PrintWriter(codigo);
            documento.println("digraph G {\n");
            documento.println("node[shape=box];\n");
            documento.println("\t\t//generar lista simple\n");
            documento.println(Gcodigo());

            documento.println("}");
            codigo.close();

            //compilar dot y generar imagen
            File miDir = new File(".");
            String ruta = miDir.getCanonicalPath() + "/";//ruta actual
            String salida = "dot -Tpng " + ruta + "listasimple" + ".dot -o " + ruta + "listasimple" + ".png";
            Runtime rt = Runtime.getRuntime();
            rt.exec(salida);
            //abrir imagen
            miDir = new File(ruta +"listasimple" + ".png");
            Desktop.getDesktop().open(miDir);

        } catch (IOException e) {
            System.out.println(e);
        }

    }
    private String Gcodigo(){
     String codigo = "";
        if (primero != null) {
            Nodo aux = primero;
            String rank1 = "";

            //==============================================crecacion de nodos  nodos=================================
            int contador1 = 0;
            while (aux!=null) {
                codigo = codigo + "RR" + contador1 + "[label=\"Dato: " + aux.getDato()+"\",color=\"burlywood\"];\n";
                aux = aux.getSiguiente();
                contador1++;
            }
            //=============================================================== conexcion de nodos==========================================
            contador1 = 0;
            while (contador1 < tama) {
                if (contador1==0) {
                    rank1 = rank1 + "RR" + contador1;
                } else {
                    rank1 = rank1 + "->" + "RR" + contador1;
                }
                contador1++;
            }
            codigo = codigo + "{rank=same; " + rank1 +";};\n";
            return codigo;
        } else {
            return codigo = "RR[label = \"Lista vacia\"   width = 1.5 style = filled,shape=box,style=filled,color=\"red\"]; \n";
        }
    }
}
