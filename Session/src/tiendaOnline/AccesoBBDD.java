package tiendaOnline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class AccesoBBDD {
	
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/tienda?serverTimezone=UTC";
	static String urs = "root";
	
	public static boolean buscarUsuario(String usuario, String password) {
		
		boolean respuesta = false;
		
		try {
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url,urs,"");
			Statement sentencia = con.createStatement();
			ResultSet rs=sentencia.executeQuery("SELECT * FROM control WHERE control.usuario='"+usuario+"' AND control.password='"+password+"'");
			
			while (rs.next()) {
				
				String usuarioEncontrado = rs.getString("usuario");
				String passwordEncontrado = rs.getString("password");
				if(usuarioEncontrado.equals(usuario) && passwordEncontrado.equals(password)) {
					respuesta=true;
				}else {
					respuesta=false;
				}
			}
			
			
		} catch (SQLException | ClassNotFoundException e) {			
			e.printStackTrace();
		}
		
		return respuesta;
		
	}
	
	public static ArrayList <Producto> listarProductos() {
		
		ArrayList <Producto> listaProductos = new ArrayList <Producto>();
		
		try {
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url,urs,"");
			Statement sentencia = con.createStatement();
			ResultSet rs=sentencia.executeQuery("SELECT * FROM productos");
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				String nombre = rs.getString("Nombre");
				double precio = rs.getDouble("Precio");
				int stock =rs.getInt("Stock");
				String urlImagen = rs.getString("Imagen");
				
				Producto p = new Producto (id, nombre, precio, stock, urlImagen); 
				listaProductos.add(p);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaProductos;
				
	}
	
	public static ArrayList <Producto> actualizarProducto(String[] valores){
		
		ArrayList <Producto> listaProductos = new ArrayList <Producto>();
		
		try {
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,urs,"");
			Statement sentencia = con.createStatement();
			Statement sentencia1 = con.createStatement();
			
			for(int i=0;i<valores.length;i++) {
				
				ResultSet rs=sentencia.executeQuery("SELECT * FROM productos WHERE Nombre='"+valores[i]+"'");
			
					while (rs.next()) {
						int id = rs.getInt("ID");
						String nombre = rs.getString("Nombre");
						Double precio = rs.getDouble("Precio");
						int stock = rs.getInt("Stock");
						String imagen = rs.getString("Imagen");
						
						stock=stock-1;
						sentencia1.executeUpdate("UPDATE productos SET Stock='"+stock+"' WHERE Nombre='"+nombre+"'");
						
						Producto p = new Producto(id, nombre,precio,stock,imagen);
						listaProductos.add(p);

					}	
					rs.close();
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listaProductos;
	
	}
	
}
