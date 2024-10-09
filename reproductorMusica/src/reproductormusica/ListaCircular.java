/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductormusica;

import ddf.minim.*;
import java.io.FileInputStream;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 *
 * @author PC
 */
public class ListaCircular {

    private NodoCancion PTR, FINAL, actual;

    private AdvancedPlayer reproductor;
    private FileInputStream fileInputStream;
    private Thread thread;
    private int totalBytes;
    private int bytesReproducidos;

    public ListaCircular() {
        PTR = null;
        FINAL = null;
        actual = null;
    }

    public void agregar(Cancion cancion) {
        NodoCancion nodo = new NodoCancion(cancion);
        if (PTR == null) {
            PTR = nodo;
            FINAL = nodo;
            actual = nodo;
            PTR.setSiguiente(FINAL);
            FINAL.setAnterior(PTR);
        } else {
            FINAL.setSiguiente(nodo);
            nodo.setAnterior(FINAL);
            FINAL = nodo;
            FINAL.setSiguiente(PTR);
            PTR.setAnterior(FINAL);
        }
    }

    public void avanzar() {
        if (actual == null) {
            System.out.println("La lista de reproduccion esta vacía.");
            return;
        }
        actual = actual.getSiguiente(); // Avanza en la lista circular
        System.out.println("Cancion Actual: " + actual.getCancion().getTitulo());
    }

    public void retroceder() {
        if (actual == null) {
            System.out.println("La lista de reproduccion esta vacía.");
            return;
        }
        actual = actual.getAnterior(); 
        System.out.println("Cancion Actual: " + actual.getCancion().getTitulo());
    }

    public NodoCancion buscarCancion(String tituloCancion) {
        NodoCancion cancion = PTR;
        if (cancion == null) {
            return null; 
        }
        do {
            System.out.println("Buscando: " + cancion.getCancion().getTitulo());
            if (cancion.getCancion().getTitulo().equalsIgnoreCase(tituloCancion)) {
                setActual(cancion);
                System.out.println("CANCION ENCONTRADA");
                return cancion;
            }
            cancion = cancion.getSiguiente();
        } while (cancion != PTR); // Se detiene cuando vuelve al inicio de la lista

        return null;
    }

    public void reproducir(String rutaCancion) {
        thread = new Thread(() -> {
            try {
                fileInputStream = new FileInputStream(rutaCancion);
                totalBytes = fileInputStream.available();  // Obtener el tamaño total del archivo
                reproductor = new AdvancedPlayer(fileInputStream);
                reproductor.play();  // Reproducir el archivo MP3
            } catch (JavaLayerException | IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();  // Iniciar la reproducción en un hilo separado
    }

    public void pausar() {
        try {
            bytesReproducidos = totalBytes - fileInputStream.available();  // Guardar la posición actual
            reproductor.close();  // Detener la reproducción
            thread.interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reanudar(String rutaCancion) {
        thread = new Thread(() -> {
            try {
                fileInputStream = new FileInputStream(rutaCancion);
                fileInputStream.skip(bytesReproducidos);  // Saltar a la posición anterior
                reproductor = new AdvancedPlayer(fileInputStream);
                reproductor.play();  // Continuar la reproducción
            } catch (JavaLayerException | IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();  // Reanudar la reproducción en un nuevo hilo
    }

    public void cerrarCancion(String rutaCancion) {
        reproductor.close();// Detener la reproducción
    }

    public NodoCancion getPTR() {
        return PTR;
    }

    public void setPTR(NodoCancion PTR) {
        this.PTR = PTR;
    }

    public NodoCancion getFINAL() {
        return FINAL;
    }

    public void setFINAL(NodoCancion FINAL) {
        this.FINAL = FINAL;
    }

    public NodoCancion getActual() {
        return actual;
    }

    public void setActual(NodoCancion actual) {
        this.actual = actual;
    }

}
