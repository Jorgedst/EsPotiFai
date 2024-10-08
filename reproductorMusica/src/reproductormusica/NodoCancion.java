/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductormusica;

/**
 *
 * @author PC
 */
public class NodoCancion {
    private Cancion cancion;
    private NodoCancion siguiente;
    private NodoCancion anterior;

    public NodoCancion(Cancion cancion) {
        this.cancion = cancion;
        this.siguiente= null;
        this.anterior = null;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public NodoCancion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCancion siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCancion getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCancion anterior) {
        this.anterior = anterior;
    }

    
    
    
}
