/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductormusica;

/**
 *
 * @author PC
 */
public class ListaCircular{
    private NodoCancion PTR, FINAL, actual;

    public ListaCircular() {
        PTR = null;
        FINAL = null;
        actual= null;
    }

    public void agregar(Cancion cancion) {
        NodoCancion nodo = new NodoCancion(cancion);
        if(PTR == null){
            PTR = nodo;
            FINAL = nodo;
            actual = nodo;
        }else{
            FINAL.setSiguiente(nodo);
            nodo.setAnterior(FINAL);
            FINAL = nodo;
        }
    }
    
    public void avanzar() {
        if(actual == null){
            System.out.println("La lista de reproduccion esta vacía.");
            return;
        }
        System.out.println("Reproduciendo:"+actual.getCancion().getTitulo());
        if(actual.getSiguiente() == null){
            actual = PTR;
        }else{
            actual = actual.getSiguiente();
        }
    }

    
    public void retroceder() {
        if(actual == null){
            System.out.println("La lista de reproduccion esta vacía.");
            return;
        }
        System.out.println("Reproduciendo:"+actual.getCancion().getTitulo());
        if(actual.getAnterior()== null){
            actual = FINAL;
        }else{
            actual = actual.getAnterior();
        }
    }
}
