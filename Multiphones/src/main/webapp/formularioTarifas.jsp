<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="modelo.Tarifa_movil" %>
   <%@ page import="modelo.Tarifa_fijo" %>
   <%@ page import="modelo.Tarifa_fibra" %>
   <%@ page import="modelo.Tarifa_movilYfibra" %>
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
		
			<input type="radio" name="tarifa" id="movil" value="movil" onchange="muestraMas()">
			<label for="movil">Móvil</label>

			<input type="radio" name="tarifa" id="fibra" value="fibra" onclick="muestraMas()">
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
List<Tarifa_movil> listaTarifa_movil = (List<Tarifa_movil>)request.getAttibute("listaTarifa_movil");
List<Tarifa_fibra> listaTarifa_fibra = (List<Tarifa_fibra>)request.getAttibute("listaTarifa_fibra");
List<Tarifa_movilYfibra> listaTarifa_movilYfibra = (List<Tarifa_movilYfibra>)request.getAttibute("listaTarifa_movilYfibra");
List<Tarifa_fijo> listaTarifa_fijo = (List<Tarifa_fijo>)request.getAttibute("listaTarifa_fijo");
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
	function muestraMas(){

		var var1=document.getElementsById("tarifa").value;
		
		var var2=document.getElementById("masTmovil");
		var var3=document.getElementById("velocidadnecesita");
		if(var1=="movil"){
			var2.style.display="block";
			var3.style.display="none"
		}
		else{
			var2.style.display="none";
		}
	}
	</script>
 </div>


</form>
</body>
</html>


