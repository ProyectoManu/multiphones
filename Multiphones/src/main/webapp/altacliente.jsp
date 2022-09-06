<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Datos cliente</title>
</head>
<body>
 <h1> Introduzca sus datos</h1>
 
          
 
<%String tarifam=null;
 String tarifaf=null;
 String tarifav=null;
 String tarifaj=null;
 
 
 if ( request.getParameter("tarifas_movil").equals("1")){
 		tarifam="-";
 }else{
	 tarifam=request.getParameter("tarifas_movil");
 }
 if (request.getParameter("tarifas_fibra").equals("1")){
 		tarifaf="-";
 }else{
	 tarifaf=request.getParameter("tarifas_fibra");
 }
 if (request.getParameter("tarifas_movilYfibra").equals("1")){
 		tarifav="-";	
 }else{
	 tarifav=request.getParameter("tarifas_movilYfibra");
 }
 if (request.getParameter("tarifas_fijo").equals("1")){
		tarifaj="-";	
 }else{
	 tarifaj=request.getParameter("tarifas_fijo");
 }
 %>
 
  <div>
  	<label for="tarifaelegida">TARIFA ELEGIDA:<%=tarifam %><%=tarifaf %><%=tarifav %><%=tarifaj %></label>
  </div>
 
    
    <form action="insertarCliente" method="post">

    <div>
        <label for="nombre"> NOMBRE: </label>
        <input type="text" name="nombre" id="nombre">
    </div>
    <div>
        <label for="apellidos"> APELLIDOS: </label>
        <input type="text" name="apellidos" id="apellidos">
    </div>
    <div>
        <label for="dni"> DNI: </label>
        <input type="text" name="dni" id="dni"
        pattern="[0-9]{1,8}[A-Za-z]{1}" required>
    </div>
    <div>
        <label for="domicilio"> DOMICILIO: </label>
        <input type="text" name="domicilio" id="domicilio">
    </div>
    <div>
        <label for="localidad"> LOCALIDAD: </label>
        <input type="text" name="localidad" id="localidad">
    </div>
    <div>
        <label for="provincia"> PROVINCIA: </label>
        <input type="text" name="provincia" id="provincia">
    </div>
    <div>
        <label for="cod_postal"> COD POSTAL: </label>
        <input type="text" name="cod_postal" id="cod_postal">
    </div>
    <div>
        <label for="fecha_nacimiento">  FECHA NACIMIENTO: </label>
        <input type="date" name="fecha_nacimiento" id="fecha_nacimiento">
    </div>
    <div>
        <label for="telefono_contacto"> TELEFONO CONTACTO: </label>
        <input type="text" name="telefono_contacto" id="telefono_contacto">
    </div>
    <div>
        <label for="email"> EMAIL: </label>
        <input type="email" name="email" id="email">
    </div>
    <div>
        <label for="telefono_tarifa"> TELEFONO TARIFA: </label>
        <input type="text" name="telefono_tarifa" id="telefono_tarifa">
    </div>
    <div>  
    <input type="submit" value="Aceptar">
     <a href="http://localhost:8080/Multiphones/formularioTarifas.jsp">
     	<input type="button" value="Atrás"> 
     </a>
     
    
    </div>
    
    </form>
 

</body>
</html>