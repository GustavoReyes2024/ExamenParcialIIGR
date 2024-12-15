/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionmedicagr;

/**
 *
 * @author USER
 */
public class MedicoGR extends PersonaGR{
    private String EspecialidadGR;
    private Integer anios_experiencia;

    public MedicoGR(String EspecialidadGR, Integer anios_experiencia, String NombreGR, String DireccionGR, Integer EdadGR) {
        super(NombreGR, DireccionGR, EdadGR);
        this.EspecialidadGR = EspecialidadGR;
        this.anios_experiencia = anios_experiencia;
    }

    public String getEspecialidadGR() {
        return EspecialidadGR;
    }

    public void setEspecialidadGR(String EspecialidadGR) {
        this.EspecialidadGR = EspecialidadGR;
    }

    public Integer getAnios_experiencia() {
        return anios_experiencia;
    }

    public void setAnios_experiencia(Integer anios_experiencia) {
        this.anios_experiencia = anios_experiencia;
    }
    
}
