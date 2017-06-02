/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Modelo.Aeronave;
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
public class Aeronaves {

    PreparedStatement preparedStmt;
    Connection connection;
    String query;

    public Aeronaves() throws URISyntaxException {
        Conexion c=new Conexion();
        this.connection=c.getConnection();
    }

    public boolean agregar(Aeronave a) {
        boolean r = false;
        try {
            // the mysql insert statement
            query = " insert into Aeronave (idAeronave,nombre)"
                    + " values (?, ?)";
            // create the mysql insert preparedstatement
            preparedStmt = connection.prepareStatement(query);

            preparedStmt.setInt(1, a.getIdAeronave());
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

    public Aeronave buscar(int id) {
        Aeronave a = null;
        // if you only need a few columns, specify them by name instead of using "*"
        this.query = "select * from Aeronave where idAeronave = " + id;
        try {
            // create the java statement
            Statement st = this.connection.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(this.query);
            // iterate through the java resultset
            while (rs.next()) {
                int id2 = rs.getInt("idAeronave");
                String nom = rs.getString("nombre");
                a = new Aeronave(id2, nom.toCharArray());
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
            this.query = "delete from Aeronave where idAeronave = " + id;
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

    public boolean actualizar(Aeronave a) {
        boolean r = false;
        if (buscar(a.getIdAeronave()) != null) {
            try {
                //Update
                // create the java mysql update preparedstatement
                query = "update Aeronave set nombre = ? where idAeronave = ?";
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, String.copyValueOf(a.getNombre()));
                preparedStmt.setInt(2, a.getIdAeronave());
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
