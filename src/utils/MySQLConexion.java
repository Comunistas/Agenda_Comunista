package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {

	public static Connection getConexion(String bd, Connection con) {
		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost/" + bd;
				String usr = "root";
				String psw = "mysql";
				con = DriverManager.getConnection(url, usr, psw);
			} catch (ClassNotFoundException ex) {
				System.out.println("No hay Driver!!");
			} catch (SQLException ex) {
				System.out.println("Error con la BD");
			}
		}
		return con;
	}

}
