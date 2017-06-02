/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Modelo.Aeronave;
import Modelo.Empleado;
import Modelo.Equipo;
import Modelo.Registro;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

public class Registros {

    PreparedStatement preparedStmt;
    Connection connection;
    String query;

    public Registros() {
          connection=(Connection) new Conexion();
    }

    public boolean agregar(Registro a) {
        boolean r = false;
        try {
            // the mysql insert statement
            query = " insert into Registro (idRegistro,fechaIngreso,fechaSalida,equipo"
                    + ",descripcion,aeronave,EmpleadoTrabajo,EmpleadoReceptor)"
                    + " values (?,?,?,?,?,?,?,?)";
            // create the mysql insert preparedstatement
            preparedStmt = connection.prepareStatement(query);

            preparedStmt.setInt(1, a.getIdRegistro());
            preparedStmt.setString(2, "" + a.getFechaIngreso().getYear() + "-" + a.getFechaIngreso().getMonth() + "-"
                    + a.getFechaIngreso().getDate());
            preparedStmt.setString(3, "" + a.getFechaSalida().getYear() + "-" + a.getFechaSalida().getMonth() + "-"
                    + a.getFechaSalida().getDate());
            preparedStmt.setInt(4, a.getEquipo().getNumSerie());
            preparedStmt.setString(5, String.copyValueOf(a.getDescripcion()));
            preparedStmt.setInt(6, a.getAeronave().getIdAeronave());
            preparedStmt.setInt(7, a.getEmpleadoTrabajo().getIdEmpleado());
            preparedStmt.setInt(8, a.getEmpleadoReceptor().getIdEmpleado());
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

    public Registro buscar(int id) {
        Registro a = null;
        // if you only need a few columns, specify them by name instead of using "*"
        this.query = "select * from Registro where  = " + id;
        try {
            // create the java statement
            Statement st = this.connection.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(this.query);
            // iterate through the java resultset
            while (rs.next()) {
                int id2 = rs.getInt("idRegistro");
                Date fechaIn = rs.getDate("fechaIngreso");
                Date fechaSa = rs.getDate("fechaSalida");
                int equipo = rs.getInt("equipo");
                String descripcion = rs.getString("descripcion");
                int aeronave = rs.getInt("aeronave ");
                int EmpleadoTrabajo = rs.getInt("EmpleadoTrabajo");
                int EmpleadoReceptor = rs.getInt("EmpleadoReceptor");
                Equipo e = new Equipos().buscar(equipo);
                Aeronave ae = new Aeronaves().buscar(aeronave);
                Empleado et = new Empleados().buscar(EmpleadoTrabajo);
                Empleado er = new Empleados().buscar(EmpleadoReceptor);
                a = new Registro(id2, fechaIn, fechaSa, e, descripcion.toCharArray(), ae, et, er);
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
            this.query = "delete from Registro where idRegistro = " + id;
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

    public boolean actualizar(Registro a) {
        boolean r = false;
        if (buscar(a.getIdRegistro()) != null) {
            try {
                //Update
                // create the java mysql update preparedstatement
                query = "update Registro set fechaIngreso=? ,fechaSalida=?,equipo=?"
                        + ",descripcion=?,aeronave=?,EmpleadoTrabajo=?,EmpleadoReceptor=?"
                        + " where idRegistro = ?";
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, "" + a.getFechaIngreso().getYear() + "-" + a.getFechaIngreso().getMonth() + "-"
                        + a.getFechaIngreso().getDate());
                preparedStmt.setString(2, "" + a.getFechaSalida().getYear() + "-" + a.getFechaSalida().getMonth() + "-"
                        + a.getFechaSalida().getDate());
                preparedStmt.setInt(3, a.getEquipo().getNumSerie());
                preparedStmt.setString(4, String.copyValueOf(a.getDescripcion()));
                preparedStmt.setInt(5, a.getAeronave().getIdAeronave());
                preparedStmt.setInt(6, a.getEmpleadoTrabajo().getIdEmpleado());
                preparedStmt.setInt(7, a.getEmpleadoReceptor().getIdEmpleado());
                preparedStmt.setInt(8, a.getIdRegistro());
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
