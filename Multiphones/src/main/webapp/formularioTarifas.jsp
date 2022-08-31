<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tarifas</title>
</head>
<body>
 <h1>Tarifas Multiphones</h1>
<h3>¿QUÉ NECESITA?</h3>
<form id="formulario" action="altacliente.jsp" method="post">
		<div>
		<label for="tarifa"></label>
		
		<input type="radio" name="tarifa" id="movil" value="movil">
		<label for="movil">Móvil</label>

		<input type="radio" name="tarifa" id="fibra" value="fibra">
		<label for="fibra">Fibra</label>

		<input type="radio" name="tarifa" id="movilYfibra" value="movilYfibra">
		<label for="movilYfibra">Móvil + Fibra</label>

		<input type="radio" name="tarifa" id="fijo" value="fijo">
		<label for="fijo">Fijo</label>
		</div>
	
	<h3>¿CUÁNTOS GIGAS NECESITA?</h3>
		<div>
			
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
		<div>
			
			<label for="minutos">MINUTOS:</label>
			<input type="range" name="minutos" id="minutos" min="100" max="1000" step="100"
			value="minutos" oninput="myFunction2()">>
			<p id="total2"></p>

		</div>
        <script>
            function myFunction2() {
              var x = document.getElementById("minutos").value;
              document.getElementById("total2").innerHTML = " " + x;
            }
            
            </script>
	<h3>¿CUÁNTA VELOCIDAD DE FIBRA NECESITA?</h3>
		<div>
			
			<label for="velocidad">VELOCIDAD FIBRA:</label>
			<input type="range" name="velocidad" id="velocidad" min="100" max="1000" step="100"
			value="velocidad" oninput="myFunction3()">
			<p id="total3"></p>
		</div>
		<script>
            function myFunction3() {
              var x = document.getElementById("velocidad").value;
              document.getElementById("total3").innerHTML = " " + x;
            }
            </script>
	<div id="masElementos" style="display : none;">
		
		<label for="todastarifas">TARIFAS:</label>
		<input type="text" name="todastarifas" id="todastarifas" value="todastarifas">	
		
		<label for="precio">PRECIO:</label>
		<input type="text" name="precio" id="precio" value="precio">
		
		<label for="preciopromo">PRECIO PROMOCIÓN: </label>
		<input type="text" name="preciopromo" id="preciopromo" value="preciopromo">

		<label for="duracion">Duración promoción:</label>
		<input type="text" name="duracion" id="duracion" value="duracion">
	
		<label for="preciopack">PRECIO PACK:</label>
		<input type="text" name="preciopack" id="preciopack" value="preciopack">
		
		<label for="">*Precio pack: precio del pack al contratar Fibra con Móvil</label>
	
 </div>
<div>
	<input type="submit" value="CONTRATAR">
</div>

</form>
</body>
<script>
	function muestraMas(){
		var var1=document.getElementById('movil').value;
		var var2=document.getElementById('fibra').value;
		var var3=document.getElementById('movilYfibra').value;
		var var4=document.getElementById('fijo').value;
		var var5=document.getElementById('masElementos');
		if(var1=='movil' || var2=='fibra' || var3=='movilYfibra' || var4=='fijo'){
			var5.style.display="block";
		}
		else{
			var5.style.display="none";
		}
	}
</script>
</html>


