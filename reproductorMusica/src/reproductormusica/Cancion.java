/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductormusica;

import javax.swing.ImageIcon;

/**
 *
 * @author PC
 */
public class Cancion {
    private String titulo;
    private String autor;
    private String rutaCancion;
    private String rutaImagenPortada;

    public Cancion(String titulo, String autor, String rutaCancion, String rutaImagenPortada) {
        this.titulo = titulo;
        this.autor = autor;
        this.rutaCancion = rutaCancion;
        this.rutaImagenPortada = rutaImagenPortada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRutaCancion() {
        return rutaCancion;
    }

    public void setRutaCancion(String rutaCancion) {
        this.rutaCancion = rutaCancion;
    }

    public ImageIcon getImagenPortada() {
        ImageIcon iconoCancion = new ImageIcon(rutaImagenPortada);
        return iconoCancion;
    }

    public void setRutaImagenPortada(String rutaImagenPortada) {
        this.rutaImagenPortada = rutaImagenPortada;
    }
    
    
}
