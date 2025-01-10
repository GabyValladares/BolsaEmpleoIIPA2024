/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.EmpleadorModelo;


/**
 *
 * @author Usuario
 */
public class EmpleadorControlador {

    //INSTANCIO UN OBJETO DEL MODELO A INSERTAR
    private EmpleadorModelo p;
    //INSTANCIAR LA CONEXIÓN A LA BASE DE DATOS
    ConexionBDD conectar = new ConexionBDD();
    //CLASE QUE ME PERMITA CONECTARME DIRECTAMENTE A MYSQL
    Connection conectado = (Connection) conectar.conectar();
    //CLASE QUE ME PERMITE EJECUTAR MI SENTENCIA SQL
    PreparedStatement ejecutar;
    //OBTENER RESULTADOS DE LA CONSULTA
    ResultSet resultado;

    //MÉTODOS DE TRANSACCIONABILIDAD
    public void insertarEmpleador(EmpleadorModelo p) {
        //1.- UTILIZAR EXCEPCIÓN
        try {//LANZAR TESTEAR UN CONJUNTO DE CÓDIGO 
            String sentenciaSQL = "call sp_insertar_Empleadores('"+p.getNombres()+"','"+p.getApellidos()+"','"+p.getCedula()+"','"+p.getDireccion()+"','"+p.getCorreoElectronico()+"','"+p.getFechaNacimiento()+"','"+p.getEmpresa()+"','"+p.getCargo()+"');";
            ejecutar = conectado.prepareCall(sentenciaSQL);
            //TODA INSERCIÓN DEVUELVE UN ESTADO >0 CUANDO FUE FAVORABLE Y MENOR A O CUANDO NO SE REALIZÓ 
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null,"Empleador Creado con éxito");
                ejecutar.close();
            }else{
                JOptionPane.showMessageDialog(null,"El Empleador no ha sido creado,"
                        + " revise que los datos ingresados sean correctos");
            }

        } catch (SQLException e) {
            //CAPTURAR PARA DARLE UN TRATAMIENTO 
            JOptionPane.showMessageDialog(null,"Comuniquese con el Administrador para solicitar ayuda");
                
        }

    }

}
