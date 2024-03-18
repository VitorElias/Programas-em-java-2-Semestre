/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vitor
 */
public class Computador {
    
    
    private static String marca = "Vitor Elias";
    private int hd;
    private String processador;
    private int id;
    
    public Computador() {
        
    }
    
    public Computador(int hd, String proc, int id) {
       this.id = id;
       this.hd = hd;
       this.processador = proc;
    }
    
    public Computador(String proc, int hd) {
        this.processador = proc;
        this.hd = hd;
    }
    
 
    public static String getMarca() {
        return marca;
    }

    public static void setMarca(String marca) {
        Computador.marca = marca;
    }

    public int getHd() {
        return hd;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
