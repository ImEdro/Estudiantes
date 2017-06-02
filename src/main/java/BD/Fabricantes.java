/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Modelo.Fabricante;
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
public class Fabricantes {

    PreparedStatement preparedStmt;
    Connection connection;
    String query;

    public Fabricantes() {
         connection=(Connection) new Conexion();

    }

    public boolean agregar(Fabricante a) {
        boolean r = false;
        try {
            // the mysql insert statement
            query = " insert into Fabricante (idFabricante,nombre)"
                    + " values (?, ?)";
            // create the mysql insert preparedstatement
            preparedStmt = connection.prepareStatement(query);

            preparedStmt.setInt(1, a.getIdFabricante());
            preparedStmt.setString(2, String.copyValueOf(a.getNombre()).trim());
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

    public Fabricante buscar(int id) {
        Fabricante a = null;
        // if you only need a few columns, specify them by name instead of using "*"
        this.query = "select * from Fabricante where idFabricante = " + id;
        try {
            // create the java statement
            Statement st = this.connection.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(this.query);
            // iterate through the java resultset
            while (rs.next()) {
                int id2 = rs.getInt("idFabricante");
                String nom = rs.getString("nombre");
                a = new Fabricante(id2, nom.toCharArray());
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
            this.query = "delete from Fabricante where idFabricante = " + id;
            this.preparedStmt = this.connection.prepareStatement(this.query);
            this.preparedStmt.execute();
            System.out.println(" se borro correctamente \n\n ");
            r = true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }

        return r;
    }

    public boolean actualizar(Fabricante a) {
        boolean r = false;
        if (buscar(a.getIdFabricante()) != null) {
            try {
                //Update
                // create the java mysql update preparedstatement
                query = "update Fabricante set nombre = ? where idFabricante = ?";
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, String.copyValueOf(a.getNombre()));
                preparedStmt.setInt(2, a.getIdFabricante());
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
