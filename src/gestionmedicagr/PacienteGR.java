/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionmedicagr;

/**
 *
 * @author USER
 */
public class PacienteGR extends PersonaGR {
    private String nroHistorialGR;
    private String EnfermedadGR;

    public PacienteGR(String nroHistorialGR, String EnfermedadGR, String NombreGR, String DireccionGR, Integer EdadGR) {
        super(NombreGR, DireccionGR, EdadGR);
        this.nroHistorialGR = nroHistorialGR;
        this.EnfermedadGR = EnfermedadGR;
    }

    public String getNroHistorialGR() {
        return nroHistorialGR;
    }

    public void setNroHistorialGR(String nroHistorialGR) {
        this.nroHistorialGR = nroHistorialGR;
    }

    public String getEnfermedadGR() {
        return EnfermedadGR;
    }

    public void setEnfermedadGR(String EnfermedadGR) {
        this.EnfermedadGR = EnfermedadGR;
    }
    
    
    
}
