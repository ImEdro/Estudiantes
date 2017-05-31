package BD;


import Modelo.Aeronave;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * CREATE TABLE Depto( id_depto integer, nom_depto varchar(40), PRIMARY
 * KEY(id_depto) );
 */
public class Obra_de_ArteDAO implements IBaseDatos<Aeronave> {
   
    public boolean agregar_Obra(Aeronave a) {
        boolean r = false;
        String query = " insert into Obra_de_arte (nombre,descripcion,estilo,valor,user)"
                + " values (?,?,?,?,?)";
        PreparedStatement preparedStmt = null;
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Obra_de_ArteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // create the mysql insert preparedstatement
            preparedStmt = connection.prepareStatement(query);
//            preparedStmt.setString(1, a.getIdAeronave());
//            preparedStmt.setString(2, a.getNombre());
            // execute the preparedstatement
            r = preparedStmt.execute();
              System.out.println("You made it, the insertion is ok!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

//    public Artista buscar_artista(String user) {
//        Artista a = null;
//        // if you only need a few columns, specify them by name instead of using "*"
//        String query = "select * from Artista where user = '" + user + "'";
//        PreparedStatement preparedStmt = null;
//        Connection connection = null;
//        try {
//            connection = Conexion.getConnection();
//        } catch (URISyntaxException ex) {
//            Logger.getLogger(Obra_de_ArteDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            // create the java statement
//            Statement st = connection.createStatement();
//            // execute the query, and get a java resultset
//            ResultSet rs = st.executeQuery(query);
//            // iterate through the java resultset
//            while (rs.next()) {
//                String user2 = rs.getString("user");
//                String nom = rs.getString("nombre");
//                String cur = rs.getString("curriculum");
//                String dis = rs.getString("distinciones");
//                a = new Artista(user2, nom, cur, dis);
//            }
//            st.close();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            System.out.println("Failed to make update!");
//            e.printStackTrace();
//        }
//        return a;
//    }

    @Override
    public List<Aeronave> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Aeronave t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Aeronave t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Aeronave t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
