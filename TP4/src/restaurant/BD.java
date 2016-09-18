package restaurant;

import java.sql.*;

/**
 * @author Pablo Germone
 */
public class BD {
    private static String connectionString = "jdbc:h2:D:/paradigmas/restaurant;AUTO_SERVER=TRUE";

    /**
     * Ejecuta un SELET sobre la BD
     * @param command Comando SELECT que se quiere ejecutar
     * @return Devuelve un ResultSet con los datos leidos de la BD
     */
    public static ResultSet getResultSet(String command){
        try{
            Class.forName("org.h2.Driver");

            Connection con = DriverManager.getConnection(connectionString);
            Statement statement = con.createStatement();

            return statement.executeQuery(command);
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Ejecuta un comando para crear o modificar tablas en la BD
     * @param command Comando que se quiere ejecutar
     */
    public static void update(String command){
        try{
            Class.forName("org.h2.Driver");

            Connection con = DriverManager.getConnection(connectionString);
            Statement statement = con.createStatement();

            statement.executeUpdate(command);

        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Devuelve el ultimo ID de una tabla
     * @param nombreTabla Nombre de la tabla de la que se quiere obtener el ID
     * @return Devuelve el ID
     */
    public static Integer getUltimoID(String nombreTabla){
        try{
            Class.forName("org.h2.Driver");

            Connection con = DriverManager.getConnection(connectionString);
            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT IS NULL(MAX(" + nombreTabla.toLowerCase() + "_id), 0) FROM " + nombreTabla);

            resultSet.next();
            return resultSet.getInt(nombreTabla.toLowerCase() + "_id");

        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}

