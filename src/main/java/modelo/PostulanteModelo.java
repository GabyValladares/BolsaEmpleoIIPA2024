/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class PostulanteModelo extends PersonaModelo{
    private int idPostulantes;
    private String especialidad;
    private int experiencia;
    private boolean estado;
    private PersonaModelo idPersonas;
   // private int idPersonas; Las 2 maneras de referenciar la fk son correctas

    public PostulanteModelo() {
    }

    public PostulanteModelo(int idPostulantes, String especialidad, int experiencia, boolean estado, PersonaModelo idPersonas) {
        this.idPostulantes = idPostulantes;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
        this.estado = estado;
        this.idPersonas = idPersonas;
    }

    public PostulanteModelo(int idPostulantes, String especialidad, int experiencia, boolean estado, int idPersonas, String nombres, String apellidos, String cedula, String direccion, String correoElectronico, String fechaNacimiento) {
        super(idPersonas, nombres, apellidos, cedula, direccion, correoElectronico, fechaNacimiento);
        this.idPostulantes = idPostulantes;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
        this.estado = estado;    }

    
    
    
    public int getIdPostulantes() {
        return idPostulantes;
    }

    public void setIdPostulantes(int idPostulantes) {
        this.idPostulantes = idPostulantes;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

  
   
    public void setIdPersonas(PersonaModelo idPersonas) {
        this.idPersonas = idPersonas;
    }
    
    @Override
    public String toString() {
        return "DATOS PERSONALES\n"+
                "Nombres:"+getNombres()+"\n"+
                "Apellidos:"+getApellidos()+"\n"+
                "Cédula:"+getCedula()+"\n"+
                "Dirección:"+getDireccion()+"\n"+
                "Correo Electrónico:"+getCorreoElectronico()+"\n"+
                "Fecha de Nacimiento:"+getFechaNacimiento()+"\n"+
                "DATOS DEL POSTULANTE:\n"+
                "Especialidad:"+getEspecialidad()+"\n"+
                "Años de Experiencia:"+getExperiencia()+"\n"+
                "¿Actualmente está trabajando?:"+getEstado();                        }
    
    
    
    
}
