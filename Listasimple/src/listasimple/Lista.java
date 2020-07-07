/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasimple;

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
                tama--;
            } else {
                Nodo aux3=aux.getSiguiente();
                aux2.setSiguiente(aux3);
                aux.setSiguiente(null);
                tama--;
            }
            }
        }else{
            System.out.println("lista vacia");
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
}
