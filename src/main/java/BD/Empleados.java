/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Modelo.Empleado;
import static java.lang.System.out;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/**
 *
 * @author
 */
public class Empleados {

    PreparedStatement preparedStmt;
    Connection connection;
    String query;

    public Empleados() throws URISyntaxException {
        Conexion c = new Conexion();
        this.connection = c.getConnection();
    }

    public boolean agregar(Empleado a) {
        boolean r = false;
        try {
            // the mysql insert statement
            query = " insert into Empleado (idEmpleado,nombre ,seccion ,CantEquiReparados,email,password,rol,disponible)"
                    + " values (?,?,?,?,?,?,?,?)";
            // create the mysql insert preparedstatement
            preparedStmt = connection.prepareStatement(query);

            preparedStmt.setInt(1, a.getIdEmpleado());
            preparedStmt.setString(2, String.copyValueOf(a.getNombre()).trim());
            preparedStmt.setInt(3, a.getSeccion());
            preparedStmt.setInt(4, a.getCantEquiReparados());
            preparedStmt.setString(5, a.getEmail());
            preparedStmt.setString(6, a.getPassword());
            preparedStmt.setString(7, String.copyValueOf(a.getRol()));
            preparedStmt.setBoolean(8, a.isDisponible());
            // execute the preparedstatement
            preparedStmt.execute();
            System.out.println("You made it, the insertion is ok!");
            r = true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make insertion!");
            e.printStackTrace();
        }
        return r;
    }

    public Empleado buscar(int id) {
        Empleado a = null;
        // if you only need a few columns, specify them by name instead of using "*"
        this.query = "select * from Empleado where  = " + id;
        try {
            // create the java statement
            Statement st = this.connection.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(this.query);
            // iterate through the java resultset
            while (rs.next()) {
                int id2 = rs.getInt("idEmpleado");
                String nom = rs.getString("nombre");
                int sec = rs.getInt("seccion");
                int cant = rs.getInt("CantEquiReparados");
                String nomu = rs.getString("email");
                String cont = rs.getString("password");
                String rol = rs.getString("rol");
                boolean dispinible = rs.getBoolean("disponible");
                a = new Empleado(id2, sec, cant, nom.toCharArray(), nomu, cont, rol.toCharArray(), dispinible);
            }
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }
        return a;
    }

    public boolean eliminar(int id) {
        boolean r = false;
        try {
            this.query = "delete from Empleado where idEmpleado = " + id;
            this.preparedStmt = this.connection.prepareStatement(this.query);
            this.preparedStmt.execute();
            System.out.println(" se borro corectamente \n\n ");
            r = true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }

        return r;
    }

    public boolean actualizar(Empleado a) {
        boolean r = false;
        if (buscar(a.getIdEmpleado()) != null) {
            try {
                //Update
                // create the java mysql update preparedstatement
                query = "update Empleado set nombre=? ,seccion=? ,CantEquiReparados=?,email=?,password=?,rol=?,disponible=?  where idEmpleado = ?";
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, String.copyValueOf(a.getNombre()));
                preparedStmt.setInt(2, a.getSeccion());
                preparedStmt.setInt(3, a.getCantEquiReparados());
                preparedStmt.setString(4, a.getEmail());
                preparedStmt.setString(5, a.getPassword());
                preparedStmt.setString(6, String.copyValueOf(a.getRol()));
                preparedStmt.setBoolean(7, a.isDisponible());
                preparedStmt.setInt(8, a.getIdEmpleado());
                // execute the java preparedstatement
                preparedStmt.executeUpdate();
                r = true;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("Failed to make update!");
                e.printStackTrace();
            }
        }
        return r;
    }

    public void disconect() throws SQLException {
        this.connection.close();
    }

    public PreparedStatement getPreparedStmt() {
        return preparedStmt;
    }

    public Connection getConnection() {
        return connection;
    }

}
