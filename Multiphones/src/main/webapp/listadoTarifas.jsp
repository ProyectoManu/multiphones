<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="modelo.Tarifa_movil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<h3>TARIFAS:</h3>
		
		<%	String tarifas = request.getParameter("tarifa");
		
		if (tarifas.equals("movil")){
		
		//Tarifa_movil.getNombre_tarifa();
					
				
			
			}
		
		
		%>
		<div>
		<label for="todastarifas"></label>
		<input type="text" name="todastarifas" id="todastarifas" value="">	
	
			
		</div>
		<div>
		<label for="precio">PRECIO:</label>
		<input type="text" name="precio" id="precio" value="precio">
		</div>
		<div>
			<label for="preciopromo">PRECIO PROMOCIÓN: </label>
			<input type="text" name="preciopromo" id="preciopromo" value="preciopromo">
			<label for="duracion">Duración promoción:</label>
			<input type="text" name="duracion" id="duracion" value="duracion">
		</div>
		<div>
			<label for="preciopack">PRECIO PACK:</label>
			<input type="text" name="preciopack" id="preciopack" value="preciopack">
		</div>
		<div>
			<label for="">*Precio pack: precio del pack al contratar Fibra con Móvil</label>
		</div>
 

</body>
</html>