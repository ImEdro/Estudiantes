/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Modelo.Aeronave;
import Modelo.Equipo;
import Modelo.Fabricante;
import java.io.FileNotFoundException;
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
public class Equipos {

    PreparedStatement preparedStmt;
    Connection connection;
    String query;

    public Equipos() {
          connection=(Connection) new Conexion();
    }

    public boolean agregar(Equipo a) {
        boolean r = false;
        try {
            // the mysql insert statement
            query = " insert into Equipo (numSerie,numParte,nombre,Fabricante,Aeronave)"
                    + " values (?, ?,?,?,?)";
            // create the mysql insert preparedstatement
            preparedStmt = connection.prepareStatement(query);

            preparedStmt.setInt(1, a.getNumSerie());
            preparedStmt.setInt(2, a.getNumParte());
            preparedStmt.setString(3, String.copyValueOf(a.getNombre()).trim());
            preparedStmt.setInt(4, a.getFabricante().getIdFabricante());
            preparedStmt.setInt(5, a.getAeronave().getIdAeronave());
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

    public Equipo buscar(int id) {
        Equipo a = null;
        // if you only need a few columns, specify them by name instead of using "*"
        this.query = "select * from Equipo where numSerie = " + id;
        try {
            // create the java statement
            Statement st = this.connection.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(this.query);
            // iterate through the java resultset
            while (rs.next()) {
                int serie = rs.getInt("numSerie");
                int parte = rs.getInt("numParte");
                String nom = rs.getString("nombre");
                int f = rs.getInt("Fabricante");
                int aer = rs.getInt("Aeronave");
                Fabricantes fa = new Fabricantes();
                Fabricante fabr = fa.buscar(f);
                Aeronaves ae = new Aeronaves();
                Aeronave ae2 = ae.buscar(aer);
                a = new Equipo(serie, parte, nom.toCharArray(), fabr, ae2);
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
            this.query = "delete from Equipo where numSerie = " + id;
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

    public boolean actualizar(Equipo a) {
        boolean r = false;
        if (buscar(a.getNumSerie()) != null) {
            try {
                //Update
                // create the java mysql update preparedstatement
                query = "update Equipo set numParte = ?, nombre = ?,Fabricante=?,Aeronave=? where numSerie = ?";
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt(1, a.getNumParte());
                preparedStmt.setString(2, String.copyValueOf(a.getNombre()));
                preparedStmt.setInt(3, a.getFabricante().getIdFabricante());
                preparedStmt.setInt(4, a.getAeronave().getIdAeronave());
                preparedStmt.setInt(5, a.getNumSerie());
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
