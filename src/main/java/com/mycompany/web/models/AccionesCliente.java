package com.mycompany.web.models;
import com.mycompany.web.models.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccionesCliente {
   // insertar registro 
public static int registrarCliente(Cliente c){
    int estado = 0;

    try {
        Class.forName("com.mysql.jdbc.Driver"); //OJO!!!EN CADA CONECCION DEBEREMOS CARGAR LA CLASE PRIMERO PARA PODER IDENTIFICAR AL DRIVER Y CONECTARNOS A LA BBDD
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/irina","root","Baruyo.2024");

        String query = "INSERT INTO clientes (Nombre,Apellido,Correo) VALUES (?,?,?)";

        
        String nombre = c.getNombre();
        String apellido = c.getApellido();
        String correo = c.getCorreo();
       

        PreparedStatement pst = conexion.prepareStatement(query);
        
        pst.setString(1, nombre);
        pst.setString(2, apellido);
        pst.setString(3, correo);

        estado = pst.executeUpdate();

        conexion.close();


    } catch (Exception e){
        System.out.println(e);
        System.out.println("uppsss algo salio mal");
    }

    return estado;
}

//actualizar registro

//  public static int actualizarCliente(Cliente c){
//  int estado = 0;

//     try {
//          Class.forName("com.mysql.jdbc.Driver");
//         Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpofinal","root","Baruyo.2024");

//         String query = "UPDATE vouchers SET Nombre=?,Apellido=?,Correo=? WHERE Id=?";

//          int id = c.getId();        
//          String nombre = c.getNombre();
//          String apellido = c.getApellido();
      

//       PreparedStatement pst = conexion.prepareStatement(query);
        
//        pst.setString(1, nombre);
//        pst.setString(2, apellido);
//        pst.setInt(4, id);

//         estado = pst.executeUpdate();

//         conexion.close();


//     } catch (Exception e){
//         System.out.println("uppsss algo salio mal");
//     }

//     return estado;
// }  

// consultar registro por id

public static Cliente verCliente(int idAConsultar){
    Cliente clienteADevolver = new Cliente();

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/irina","root","Baruyo.2024");

        String query = "SELECT * FROM clientes WHERE Id=?";

        PreparedStatement pst = conexion.prepareStatement(query);
        
        pst.setInt(1, idAConsultar);

        ResultSet consultaCliente = pst.executeQuery();

        if (consultaCliente.next()){
            clienteADevolver.setId( consultaCliente.getInt(1));
            clienteADevolver.setNombre( consultaCliente.getString(2));
            clienteADevolver.setApellido( consultaCliente.getString(3));
            clienteADevolver.setCorreo( consultaCliente.getString(4));
            conexion.close();
        }
    } catch (Exception e){
        System.out.println(e);
        System.out.println("uppsss algo salio mal");
    }

    return clienteADevolver;
}    

//consultar todos los registros de una tabla

// public static List<Cliente> verTodosClientes(){
//     List<Cliente> listaClientesADevolver = new ArrayList<Cliente>();
    

//     try {
//         Class.forName("com.mysql.jdbc.Driver");
//         Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/irina","root","Baruyo.2024");

//         String query = "SELECT * FROM clientes";

//         PreparedStatement pst = conexion.prepareStatement(query);

//         ResultSet consultaCliente = pst.executeQuery();

//         while (consultaCliente.next()){
//             Cliente clienteADevolver = new Cliente(); //EN CADA VUELTA NECESITAREMOS INSTANCIAR UN NUEVO OBJETO
//             clienteADevolver.setId( consultaCliente.getInt(1));
//             clienteADevolver.setNombre( consultaCliente.getString(2));
//             clienteADevolver.setApellido( consultaCliente.getString(3));
//             clienteADevolver.setCorreo( consultaCliente.getString(4));
//             listaClientesADevolver.add(clienteADevolver);
//         }
//         conexion.close();
//     } catch (Exception e){
//         System.out.println(e);
//         System.out.println("uppsss algo salio mal");
//     }

//     return listaClientesADevolver;
// } 

//consultar ventas por id

//public static VentasVouchers verVentas(int idAConsultar){
    //VentasVouchers idAdevolver = new id();

    //try {
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpofinal/vouchers","root","Baruyo.2024");

        //String sqlquery = "SELECT * FROM ventasVouchers WHERE id_cliente=?";

        //PreparedStatement pst = conexion.prepareStatement(sqlquery);
        
        //pst.setInt(1, idAConsultar);

        //ResultSet consultaVentas = pst.executeQuery();

        //if (consultaVentas.next()){
           // ventasAdevolver.setId( consultaVentas.getInt(1));
           // ventasAdevolver.setNombre( consultaVentas.getString(2));
           // ventasAdevolver.setApellido( consultaVentas.getString(3));
           // ventasAdevolver.setCorreo( consultaVentas.getString(4));
           // ventasAdevolver.setCant( consultaVentas.getInt(5));
           // ventasAdevolver.setServicio( consultaVentas.getString(6));
           // ventasAdevolver.setCosto ( consultaVentas.getDouble(7));
           // conexion.close();
       // }
    //} catch (Exception e){
        //System.out.println(e);
        //System.out.println("uppsss algo salio mal");
    //}

   // return ventasAdevolver;
//}    
}

