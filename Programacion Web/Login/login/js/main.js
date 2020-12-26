$(document).ready(function(){

    $("#boton").click(function(){

        /*RECUPERAR CADENA DE BUSQUEDA*/
        var search = $("#search").val();
        var cantRes = $("#cantRes").val();
        console.log(search);
        //console.log(cantRes);

        document.getElementById('resultados').innerHTML="";

        /*LLAMA API WIKIPEDIA PARA RECUPERAR INFORMACION*/
        $.get("https://es.wikipedia.org/w/api.php?action=opensearch&format=json&search="+search, function(respue){
            console.log(respue);
            $("#resultados").append("<div class='contDatEsc' id='contDatEsc'></div>");
            $("#contDatEsc").append("<div class='biog' id='biog'></div>");
            $("#contDatEsc").append("<div class='enlac' id='enlac'></div>");
            $("#biog").append("<b>"+ respue[1][0] +"</b>");
            $("#biog").append("<p>"+ respue[2][0] +"</p>");
            $("#enlac").append("<a href ='"+respue[3][0]+"' target='_blank'><button>Ver en Wikipedia</button></a> <br/>");


        });


        /*LLAMA API DE GOOGLE BOOKS PARA CARGAR LOS LIBROS*/
        $.get("https://www.googleapis.com/books/v1/volumes?q="+search+"&inauthor&maxResults="+cantRes, function(response){
            console.log(response);

            for (j=0; j<response.items.length; j++) {
                $("#resultados").append("<div class='contenedorGeneral' id='contGen"+j+"'>"+
                                            "<div class='contenedorSuperior'>"+
                                                "<div class='contenedorDatosLibro'>"+
                                                    "<p><b>Libro: </b>"+ response.items[j].volumeInfo.title +"</p>"+
                                                    "<p><b>Autor: </b>"+ response.items[j].volumeInfo.authors +"</p>"+
                                                    "<p><b>Editorial: </b>"+ response.items[j].volumeInfo.publisher +"</p>"+
                                                    "<p><b>Fecha de Publicación: </b>"+ response.items[j].volumeInfo.publishedDate +"</p>"+
                                                "</div>"+
                                                "<div class='contenedorImagenLibro'>"+
                                                    "<img src='"+response.items[j].volumeInfo.imageLinks.thumbnail+"'><br>"+
                                                "</div>"+
                                            "</div>"+
                                            "<div class='contenedorInferior' id='contInf'>"+
                                                "<button onclick='mostrar(\""+ response.items[j].id +"\")'>Ver información detallada</button>"+
                                            "</div>"+
                                       "</div>");
            }
        });


        return false;

    });

});
