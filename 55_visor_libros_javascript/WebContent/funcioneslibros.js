var arrayLibros;
var con;
var url="http://localhost:8080/47_libros_WS/";
var resultado;

function cargarTemas(){
	con=new XMLHttpRequest();
    con.open("GET",url,true); 
    con.onreadystatechange=procesarRespuesta;
    con.send(null); 
}
function procesarRespuesta(){
      if(con.readyState==4){
          var lista=document.getElementById("listaTemas");
          arrayLibros=JSON.parse(con.responseText);
          arrayTemas=crearArrayTemas();
          /* nueva manera, en JS v6
			arrayTemas=arrayLibros
				.map(libro=>libro.tematica);
            arrayTemas = [...new Set(arrayTemas)]; como los Set no admiten duplicados..
			evitamos las funciones existe y crearArrayTemas
		  */
          for (var tema of arrayTemas){ 
              var opcion=document.createElement("option");
              opcion.value=tema;
              opcion.text=tema;
              lista.appendChild(opcion);
          }
      }
}
function crearArrayTemas(){
	var temas=[];
	for (var libro of arrayLibros){
		if(!existe(libro.tematica,temas)){
			temas.push(libro.tematica);
		}
	}
	return temas;
}
// comprueba si el tema está en el array
function existe(tematica,temas){
	for (n of temas){
		if(n==tematica){
			return true;
		}		
	}
	return false;
}
function mostrarLibrosTema(){
        var temaSeleccionado=document.getElementById("listaTemas").value;
        resultado=document.getElementById("datosLibro");
        var html="";
        for (var libro of arrayLibros){        	
        	if(libro.tematica==temaSeleccionado){            	
                html+="<p>Libro: "+libro.titulo+" </p>";
                html+="<p>Autor: "+libro.autor+" </p>";
                html+="<p>Precio: "+libro.precio+" </p>";
                html+="----------------------";
            }            
        }
        resultado.innerHTML=html;
}