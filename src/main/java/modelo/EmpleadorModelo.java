/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class EmpleadorModelo extends PersonaModelo {
    private int idEmpleador;
    private String empresa;
    private String cargo;
    private PersonaModelo idpersona;

    public EmpleadorModelo() {
    }

    public EmpleadorModelo(int idEmpleador, String empresa, String cargo, PersonaModelo idpersona) {
        this.idEmpleador = idEmpleador;
        this.empresa = empresa;
        this.cargo = cargo;
        this.idpersona = idpersona;
    }

    public EmpleadorModelo(int idEmpleador, String empresa, String cargo, PersonaModelo idpersona, int idPersonas, String nombres, String apellidos, String cedula, String direccion, String correoElectronico, String fechaNacimiento) {
        super(idPersonas, nombres, apellidos, cedula, direccion, correoElectronico, fechaNacimiento);
        this.idEmpleador = idEmpleador;
        this.empresa = empresa;
        this.cargo = cargo;
        this.idpersona = idpersona;
    }

    public int getIdEmpleador() {
        return idEmpleador;
    }

    public void setIdEmpleador(int idEmpleador) {
        this.idEmpleador = idEmpleador;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public PersonaModelo getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(PersonaModelo idpersona) {
        this.idpersona = idpersona;
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
                "DATOS DEL EMPLEADOR:\n"+
                "Empresa:"+getEmpresa()+"\n"+
                "Cargo:"+getCargo()+"\n";  }
    
    
    
    
}
