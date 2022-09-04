<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="modelo.Tarifa_movil" %>
   <%@ page import="modelo.Tarifa_fijo" %>
   <%@ page import="modelo.Tarifa_fibra" %>
   <%@ page import="modelo.Tarifa_movilYfibra" %>
    <%@ page import="dao.Tarifa_movilDAO" %>
      <%@ page import="dao.Tarifa_fibraDAO" %>
        <%@ page import="dao.Tarifa_movilYfibraDAO" %>
       <%@ page import="dao.Tarifa_fijoDAO" %>
       <%@ page import="dao.Tarifa_movilDAOJDBC" %>
       <%@ page import="dao.Tarifa_fibraDAOJDBC" %>
       <%@ page import="dao.Tarifa_fijoDAOJDBC" %>
       <%@ page import="dao.Tarifa_movilYfibraDAOJDBC" %>
   <%@ page import ="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tarifas</title>
</head>
<body>
 <h1>Tarifas Multiphones</h1>
<h3>¿QUÉ NECESITA?</h3>
<form id="formulario" action="listadoTarifas.jsp" method="post">

		<div id="tarifa">
			<label for="tarifa"></label>
		
			<input type="radio" name="tarifa" id="movil" value="movil" onchange="muestraMovil()">
			<label for="movil">Móvil</label>

			<input type="radio" name="tarifa" id="fibra" value="fibra" onclick="muestraFibra()">
			<label for="fibra">Fibra</label>

			<input type="radio" name="tarifa" id="movilYfibra" value="movilYfibra" onclick="muestraMas()">
			<label for="movilYfibra">Móvil + Fibra</label>

			<input type="radio" name="tarifa" id="fijo" value="fijo" onclick="muestraMas()">
			<label for="fijo">Fijo</label>
		</div>
	
	<h3>¿CUÁNTOS GIGAS NECESITA?</h3>
		<div id="gigasnecesita" style="display : block;">
			
			<label for="gigas">GIGAS:</label>
			<input type="range" name="gigas" id="gigas" min="0" max="200" step="20"
			value="gigas" oninput="myFunction()">
			<p id="total"></p>

		</div>
	<script>
function myFunction() {
  var x = document.getElementById("gigas").value;
  document.getElementById("total").innerHTML = " " + x;
}

</script>
	<h3>¿CUÁNTOS MINUTOS NECESITA?</h3>
		<div id="minutosnecesita" style="display : block;">
			
			<label for="minutos">MINUTOS:</label>
			<input type="range" name="minutos" id="minutos" min="100" max="1000" step="100"
			value="minutos" oninput="myFunction2()">
			<p id="total2"></p>

		</div>
        <script>
            function myFunction2() {
              var x = document.getElementById("minutos").value;
              document.getElementById("total2").innerHTML = " " + x;
            }
            
            </script>
	<h3>¿CUÁNTA VELOCIDAD DE FIBRA NECESITA?</h3>
		<div id="velocidadnecesita" style="display : block;" >
			
			<label for="velocidad">VELOCIDAD FIBRA:</label>
			<input type="range" name="velocidad" id="velocidad" min="100" max="1000" step="100"
			value="velocidad" oninput="myFunction3()" onclick="muestraMas()">
			<p id="total3"></p>
		</div>
		<script>
            function myFunction3() {
              var x = document.getElementById("velocidad").value;
              document.getElementById("total3").innerHTML = " " + x;
            }
            </script>
<%
Tarifa_movilDAO tarifaMovilDAO = new Tarifa_movilDAOJDBC();
List<Tarifa_movil> listaTarifa_movil = tarifaMovilDAO.getTarifa_movil();

Tarifa_fibraDAO tarifaFibraDAO = new Tarifa_fibraDAOJDBC();
List<Tarifa_fibra> listaTarifa_fibra = tarifaFibraDAO.getTarifa_fibra();

Tarifa_movilYfibraDAO tarifaMovilYfibraDAO = new Tarifa_movilYfibraDAOJDBC();
List<Tarifa_movilYfibra> listaTarifa_movilYfibra = tarifaMovilYfibraDAO.getTarifa_movilYfibra();

Tarifa_fijoDAO tarifaFijoDAO = new Tarifa_fijoDAOJDBC();
List<Tarifa_fijo> listaTarifa_fijo = tarifaFijoDAO.getTarifa_fijo();


%>
	<div id="masTmovil" style="display : none;" >
		
		<label for="todastarifas">TARIFAS:</label>
		<select name="tarifas_movil" id="tarifas_movil">
			<%
				for (Tarifa_movil tm: listaTarifa_movil){
			%>
				<option value="<%=tm.getId_tarifa_movil()%>">TARIFA:<%=tm.getNombre_tarifa()%>
					<p>GIGAS: <%=tm.getGigas()%></p>
					<p>MINUTOS: <%=tm.getMinutos()%></p>
					<p>PRECIO: <%=tm.getPrecio()%></p>
					<p>PRECIO PROMOCIÓN: <%=tm.getPrecio_promocion()%></p>
					<p>PRECIO PACK: <%=tm.getPrecio_pack()%></p>
					</option>
				<%
				}
				%>
		</select>
		<label for="">*Precio pack: precio del pack al contratar con más servicios</label>
	</div>
	<div id="masTfibra" style="display : none;" >
		
		
		<select name="tarifas_fibra" id="tarifas_ibra">
			<%
				for (Tarifa_fibra tf: listaTarifa_fibra){
			%>
				<option value="<%=tf.getId_tarifa_fibra()%>">TARIFA:<%=tf.getNombre_tarifa()%>
					 <p>VELOCIDAD FIBRA: <%=tf.getVelocidad_fibra()%></p>
					<p>PRECIO: <%=tf.getPrecio()%></p>
					<p>PRECIO PROMOCIÓN: <%=tf.getPrecio_promocion()%></p>
					<p>PRECIO PACK: <%=tf.getPrecio_pack()%></p>
					</option>
				<%
				}
				%>
		</select>
		<label for="">*Precio pack: precio del pack al contratar con más servicios</label>
	</div>
	<div id="masTmovilYfibra" style="display : none;" >
		
		<select name="tarifas_movilYfibra" id="tarifas_movilYfibra">
			<%
				for (Tarifa_movilYfibra tmf: listaTarifa_movilYfibra){
			%>
				<option value="<%=tmf.getId_tarifa_movilYfibra()%>">TARIFA:<%=tmf.getNombre_tarifa()%>
					 <p>GIGAS: <%=tmf.getGigas()%></p>
					<p>MINUTOS: <%=tmf.getMinutos()%></p>
					<p>VELOCIDAD FIBRA: <%=tmf.getVelocidad_fibra()%></p>
					<p>PRECIO: <%=tmf.getPrecio()%></p>
					<p>PRECIO PROMOCIÓN: <%=tmf.getPrecio_promocion()%></p>
					<p>PRECIO PACK: <%=tmf.getPrecio_pack()%></p>
					</option>
				<%
				}
				%>
		</select>
		<label for="">*Precio pack: precio del pack al contratar con más servicios</label>
	</div>
	<div id="masTfijo" style="display : none;" >
		
		<select name="tarifas_fijo" id="tarifas_fijo">
			<%
				for (Tarifa_fijo tfi: listaTarifa_fijo){
			%>
				<option value="<%=tfi.getId_tarifa_fijo()%>">TARIFA:<%=tfi.getNombre_tarifa()%>
					 <p>MIN NACIONALES: <%=tfi.getMinutos_nacionales()%></p>
					<p>MIN INTERNACIONALES: <%=tfi.getMinutos_internacionales()%></p>
					<p>PRECIO: <%=tfi.getPrecio()%></p>
					<p>PRECIO PROMOCIÓN: <%=tfi.getPrecio_promocion()%></p>
					<p>PRECIO PACK: <%=tfi.getPrecio_pack()%></p>
					</option>
				<%
				}
				%>
		</select>
		<label for="">*Precio pack: precio del pack al contratar con más servicios</label>
	</div>
	</html>
	<script>
	function muestraMovil(){

		var movil =document.getElementsById("masTmovil");
		var velocidad=document.getElementsById("velocidadnecesita");
		movil.style.display="block";
		velocidad.style.display="none";
		
	}
	function muestraFibra(){

		var fibra =document.getElementsById("masTfibra");
		var minutos=document.getElementsById("minutosnecesita");
		var gigas = document.getElementsById("gigasnecesita");
		fibra.style.display="block";
		minutos.style.display="none";
		gigas.style.display="none";
	}
	</script>
 </div>


</form>
</body>
</html>


