package tiendaOnline;



import java.util.ArrayList;
import java.util.Map;

public class CrearTabla {

	public static String fabricarTabla(ArrayList<Producto> lista){
		
		String html="<table border=1px>";
		html+="<th>NOMBRE</th><th>PRECIO</th><th>STOCK</th><th>IMAGEN</th><th>COMPRAR</th>";
		for (int i = 0; i<lista.size(); i++){
			Producto p = lista.get(i);
			html+="<tr>";
			html+="<td>"+p.getNombre()+"</td>";
			html+="<td>"+p.getPrecio()+"</td>";
			html+="<td>"+p.getStock()+"</td>";
			html+="<td><img src='"+p.getUrlImagen()+"'></td>";
			html+="<td><input type='checkbox' name='comprar' value='"+p.getNombre()+"'></td>";
			html+="</tr>";
			
		}
		
		return html+="</table>";
		
	}
	
	public static String fabricarTablaSin(ArrayList<Producto> lista){
		
		String html="<table border=1px>";
		html+="<th>NOMBRE</th><th>PRECIO</th><th>STOCK</th><th>IMAGEN</th>";
		for (int i = 0; i<lista.size(); i++){
			Producto p = lista.get(i);
			html+="<tr>";
			html+="<td>"+p.getNombre()+"</td>";
			html+="<td>"+p.getPrecio()+"</td>";
			html+="<td><img src='"+p.getUrlImagen()+"'></td>";
			html+="</tr>";
			
		}
		
		return html+="</table>";
		
	}	
	

}

