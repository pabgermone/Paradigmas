package restaurant;

import java.sql.*;

/**
 * @author Pablo Germone
 */
public class BD {

    /**
     * Ejecuta un SELET sobre la BD
     * @param command Comando SELECT que se quiere ejecutar
     * @return Devuelve un ResultSet con los datos leidos de la BD
     */
    public static ResultSet getResultSet(String command){
        try{
            Class.forName("org.h2.Driver");

            Connection con = DriverManager.getConnection("jdbc:h2:D:/paradigmas/restaurant", "sa", "");
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

            Connection con = DriverManager.getConnection("jdbc:h2:D:/paradigmas/restaurant", "sa", "");
            Statement statement = con.createStatement();

            statement.executeUpdate(command);

            statement.close();
            con.close();

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

            Connection con = DriverManager.getConnection("jdbc:h2:D:/paradigmas/restaurant", "sa", "");
            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT ISNULL(MAX(" + nombreTabla.toUpperCase() + "_ID), 0) "
                                                       + "FROM " + nombreTabla.toUpperCase() + ";");

            resultSet.next();
            return resultSet.getInt(1);

        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void clear(String nombreTabla){
        try{
            Class.forName("org.h2.Driver");

            Connection con = DriverManager.getConnection("jdbc:h2:D:/paradigmas/restaurant", "sa", "");
            Statement statement = con.createStatement();

            statement.executeUpdate("DELETE FROM " + nombreTabla.toUpperCase() + " WHERE " + nombreTabla.toUpperCase() + "_ID >= 0;");

            statement.close();
            con.close();

        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

