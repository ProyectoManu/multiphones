package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import dao.ClienteDAO;
import dao.ClienteDAOJDBC;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Cliente;

/**
 * Servlet implementation class ClientesServlet
 */
@WebServlet("/insertarCliente")
public class ClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		PrintWriter out = response.getWriter();
		
		String tarifam = request.getParameter("tarifas_movil");
		if (tarifam ==null ) {
			tarifam="1";
		}
		String tarifaf = request.getParameter("tarifas_fibra");
		if (tarifaf ==null) {
			tarifaf="1";
		}
		String tarifamf = request.getParameter("tarifas_movilYfibra");
		if (tarifamf ==null) {
			tarifamf="1";
		}
		String tarifafi = request.getParameter("tarifas_fijo");
		if (tarifafi ==null) {
			tarifafi="1";
		}
		int tarifaMovil= Integer.parseInt(tarifam);
		int tarifaFibra= Integer.parseInt(tarifaf);
		int tarifaMovilYfibra= Integer.parseInt(tarifamf);
		int tarifaFijo=Integer.parseInt(tarifafi);
		
		

		
		String nombre=request.getParameter("nombre");
		String apellidos=request.getParameter("apellidos");
		String dni =request.getParameter("dni");
		String domicilio=request.getParameter("domicilio");
		String localidad=request.getParameter("localidad");
		String provincia=request.getParameter("provincia");
		String cod_postal=request.getParameter("cod_postal");
		String fecha_nacimiento = request.getParameter("fecha_nacimiento");
		String telefono_contacto=request.getParameter("telefono_contacto");
		String email=request.getParameter("email");
		String telefono_tarifa=request.getParameter("telefono_tarifa");
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Resumen</title>\r\n"
				+ "</head>\r\n"
				+ "<body>");
		out.println("<h1> Resumen de sus datos</h1>");
		
		out.println("<ul>");
		out.println("<li> Nombre: "+nombre+"</li>");
		out.println("<li> Apellidos: "+apellidos+"</li>");
		out.println("<li> Dni: "+dni+"</li>");
		out.println("<li> Domicilio: "+domicilio+"</li>");
		out.println("<li> localidad: "+localidad+"</li>");
		out.println("<li> Provincia: "+provincia+"</li>");
		out.println("<li> Codigo Postal: "+cod_postal+"</li>");
		out.println("<li> Fecha Nacimiento: "+fecha_nacimiento+"</li>");
		out.println("<li> Telefono de contacto: "+telefono_contacto+"</li>");
		out.println("<li> Email: "+email+"</li>");
		out.println("<li> Telefono Tarifa: "+telefono_tarifa+"</li>");
		out.println("</ul>");
		
		out.println("</body>\r\n"
				+ "</html>");

		Cliente cliente = new Cliente(nombre,apellidos, dni,
				   domicilio, localidad, provincia, cod_postal, fecha_nacimiento,
				   telefono_contacto, email, telefono_tarifa, tarifaMovil, tarifaFibra, tarifaMovilYfibra, tarifaFijo);
		
		ClienteDAO clienteDAO = new ClienteDAOJDBC();
		clienteDAO.insertarCliente(cliente);
		
		
	}

}
