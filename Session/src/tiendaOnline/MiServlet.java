package tiendaOnline;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MiServlet")
public class MiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MiServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String accion = request.getParameter("accion");
		
			if(accion.equals("entrar")) {
				
				boolean respuesta = AccesoBBDD.buscarUsuario(usuario, password);
				
				if(respuesta==true) {
					
					request.getSession().setAttribute("usuario", usuario);
					ArrayList<Producto> listaProductos = AccesoBBDD.listarProductos();
					request.setAttribute("listaProductos", listaProductos);
					request.getRequestDispatcher("Tabla.jsp").forward(request, response);
					
				}else {
					
					request.getRequestDispatcher("Indice.jsp").forward(request, response);
					
				}	
					
			}else if(accion.equals("comprar")) {
				
				String[] valores = request.getParameterValues("comprar");
				ArrayList<Producto> listaProductosComprados = AccesoBBDD.actualizarProducto(valores);
				request.getSession().setAttribute("usuario", usuario);
				request.setAttribute("listaProductosComprados", listaProductosComprados);
				request.getRequestDispatcher("Carrito.jsp").forward(request, response);
				
			}else if(accion.equals("volverTabla")) {
				
				ArrayList<Producto> listaProductos = AccesoBBDD.listarProductos();
				request.setAttribute("listaProductos", listaProductos);
				request.getSession().setAttribute("usuario", usuario);
				request.getRequestDispatcher("Tabla.jsp").forward(request, response);
				
			}
			
		
		
		
	}

}
