<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1> Introduzca sus datos</h1>

    <form action="altacliente" method="post">

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
        <input type="checkbox" name="telefono_tarifa" id="telefono_tarifa">
    </div>
    <div>  
    <input type="submit" value="Aceptar">
    
    </div>
    
    </form>
 

</body>
</html>