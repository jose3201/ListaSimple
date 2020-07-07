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
public class Listasimple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista n= new Lista();
        n.InsertarUltimo(20);
        n.InsertarUltimo(10);
        n.InsertarUltimo(50);
        n.InsertarUltimo(8);
        n.InsertarUltimo(1);
        n.InsertarUltimo(2);
        n.imprimir();
        
        n.Eliminar(50);
        n.imprimir();
        n.GenerarGraphyz();
    }
    
}
