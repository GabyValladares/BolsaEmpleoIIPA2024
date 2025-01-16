/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.PostulanteModelo;

/**
 *
 * @author Usuario
 */
public class PostulanteControlador {

    //INSTANCIO UN OBJETO DEL MODELO A INSERTAR
    private PostulanteModelo p;
    //INSTANCIAR LA CONEXIÓN A LA BASE DE DATOS
    ConexionBDD conectar = new ConexionBDD();
    //CLASE QUE ME PERMITA CONECTARME DIRECTAMENTE A MYSQL
    Connection conectado = (Connection) conectar.conectar();
    //CLASE QUE ME PERMITE EJECUTAR MI SENTENCIA SQL
    PreparedStatement ejecutar;
    //OBTENER RESULTADOS DE LA CONSULTA
    ResultSet res;

    //MÉTODOS DE TRANSACCIONABILIDAD
    public void insertarPostulante(PostulanteModelo p) {
        //1.- UTILIZAR EXCEPCIÓN
        try {//LANZAR TESTEAR UN CONJUNTO DE CÓDIGO 
            String sentenciaSQL = "call sp_InsertarPostulante('" + p.getNombres() + "','" + p.getApellidos() + "','" + p.getCedula() + "','" + p.getDireccion() + "','" + p.getCorreoElectronico() + "','" + p.getFechaNacimiento() + "','" + p.getEspecialidad() + "','" + p.getExperiencia() + "','" + p.getEstado() + "');";
            ejecutar = conectado.prepareCall(sentenciaSQL);
            //TODA INSERCIÓN DEVUELVE UN ESTADO >0 CUANDO FUE FAVORABLE Y MENOR A O CUANDO NO SE REALIZÓ 
            int resu = ejecutar.executeUpdate();
            if (resu > 0) {
                JOptionPane.showMessageDialog(null,"Postulante Creado con éxito");
                ejecutar.close();
            }else{
                JOptionPane.showMessageDialog(null,"El Postulante no ha sido creado,"
                        + " revise que los datos ingresados sean correctos");
            }

        } catch (SQLException e) {
            //CAPTURAR PARA DARLE UN TRATAMIENTO 
            JOptionPane.showMessageDialog(null,"Comuniquese con el Administrador para solicitar ayuda");
                
        }

    }
    
        public ArrayList<Object[]> buscarPostulante(String cedula) {
            ArrayList<Object[]> listaObject=new ArrayList<>();
        try {
            String sql = "call sp_BuscarPostulante('%"+cedula+"%');";
            ejecutar = (PreparedStatement) conectado.prepareCall(sql);
            res = ejecutar.executeQuery();
            int cont = 1;
            while (res.next()) {
                Object[] obpostulante = new Object[6];
                for (int i = 0; i < 6; i++) {
                    obpostulante[i] = res.getObject(i+1);
                }
                obpostulante[0]=cont;
                listaObject.add(obpostulante);
                cont++;
            }
            ejecutar.close();
            return listaObject;
           
        } catch (SQLException e) {
            System.out.println("ERROR SQL"+e);
        }
        return null;
    }

    public ArrayList<Object[]> datosPostulante() {
        ArrayList<Object[]> listaObject=new ArrayList<>();
        
        try {
            String sql = "call sp_listaPostulante();";
            ejecutar = (PreparedStatement) conectado.prepareCall(sql);
            res = ejecutar.executeQuery();
            int cont = 1;
            while (res.next()) {
                Object[]  obpostulante = new Object[6];
                for (int i = 1; i < 6; i++) {
                    obpostulante[i] = res.getObject(i+1);
                }
                 obpostulante[0]=cont;
                listaObject.add( obpostulante);
                cont++;
            }
            ejecutar.close();
            return listaObject;

        } catch (SQLException e) {
            System.out.println("ERROR SQL CARGA POSTULANTE");

        }

        return null;
    }
    public void actualizarPostulante(PostulanteModelo p) {
        try {
            String sentenciaSQL = "call sp_InsertarPostulante('" + p.getNombres() + "','" + p.getApellidos() + "','" + p.getCedula() + "','" + p.getDireccion() + "','" + p.getCorreoElectronico() + "','" + p.getFechaNacimiento() + "','" + p.getEspecialidad() + "','" + p.getExperiencia() + "','" + p.getEstado() + "');";
            ejecutar = (PreparedStatement) conectado.prepareCall(sentenciaSQL);
            int resultado = ejecutar.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Postulante Actualizado con Éxito");
            
                ejecutar.close();
            } else {
                JOptionPane.showMessageDialog(null, "Revise los datos ingresados");
              
            }
        } catch (SQLException e) {
            System.out.println("ERROR SQL");
        }
    }
    public void eliminarPostulante(String cedula) {
        try {
            String sql = "call sp_EliminarPostulante(" + cedula + ");";
            ejecutar = (PreparedStatement) conectado.prepareCall(sql);
            int resultado = ejecutar.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Postulante Eliminado con éxito");
 
                ejecutar.close();
            } else {
                JOptionPane.showMessageDialog(null, "Revise los datos ingresados");
      
            }
        } catch (SQLException e) {
            System.out.println("ERROR SQL"+e);
        }
    }
    

}
