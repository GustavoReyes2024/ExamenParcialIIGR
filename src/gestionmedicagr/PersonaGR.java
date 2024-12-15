/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionmedicagr;

/**
 *
 * @author USER
 */
public class PersonaGR {
    private String NombreGR;
    private String DireccionGR;
    private Integer EdadGR;

    public PersonaGR(String NombreGR, String DireccionGR, Integer EdadGR) {
        this.NombreGR = NombreGR;
        this.DireccionGR = DireccionGR;
        this.EdadGR = EdadGR;
    }

    public String getNombreGR() {
        return NombreGR;
    }

    public void setNombreGR(String NombreGR) {
        this.NombreGR = NombreGR;
    }

    public String getDireccionGR() {
        return DireccionGR;
    }

    public void setDireccionGR(String DireccionGR) {
        this.DireccionGR = DireccionGR;
    }

    public Integer getEdadGR() {
        return EdadGR;
    }

    public void setEdadGR(Integer EdadGR) {
        this.EdadGR = EdadGR;
    }

    
}
