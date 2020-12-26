$(document).ready(function(){
    obtenerValores();
});

function obtenerValores(){
    var url = document.location.href;
    //console.log(url);
    //console.log(url.indexOf('?'));
    var getString = url.split('?')[1];
    //console.log(getString);
    var id = getString.split('=')[1];
    //console.log(getid);
    //$("#contMed").append("<p>"+id+"</p>");

    /*LLAMA API DE GOOGLE BOOKS PARA CARGAR LOS LIBROS*/

    var title;

    $.get("https://www.googleapis.com/books/v1/volumes?q=id:"+id, function(response){
        console.log(response);

        //carga datos libro
        title = response.items[0].volumeInfo.title;
        console.log(title);
        $("#datLib").append("<p><b>Libro: </b>"+response.items[0].volumeInfo.title+"</p>");
        $("#datLib").append("<p><b>Autor: </b>"+response.items[0].volumeInfo.authors+"</p>");
        $("#datLib").append("<p><b>Editorial: </b>"+response.items[0].volumeInfo.publisher+"</p>");
        $("#datLib").append("<p><b>ISBN: </b>"+response.items[0].volumeInfo.industryIdentifiers[0].identifier+"</p>");
        $("#datLib").append("<p><b>Fecha Publicación: </b>"+response.items[0].volumeInfo.publishedDate+"</p>");
        $("#datLib").append("<p><b>Cantidad de Páginas: </b>"+response.items[0].volumeInfo.pageCount+" páginas</p>");
        $("#datLib").append("<p><b>Categoría: </b>"+response.items[0].volumeInfo.categories+"</p>");
        $("#datLib").append("<p><b>Calificación: </b>"+response.items[0].volumeInfo.averageRating+"</p>");

        //carga imagen libro
        $("#imgLib").append("<img src='"+response.items[0].volumeInfo.imageLinks.thumbnail+"'><br>");

        //carga descripcion libro
        $("#contMed").append("<h4>Descripción</h4>");
        $("#contMed").append("<p>"+response.items[0].volumeInfo.description+"</p>");

        //cargar ver/leer en Google Books
        $("#verLib").append("<a href ='"+response.items[0].volumeInfo.previewLink+"' target='_blank'><button>Ver en Google Books</button></a>");
        $("#verLib").append("<a href ='"+response.items[0].accessInfo.webReaderLink+"' target='_blank'><button>Leer Online</button></a>");

        //cargar comprar en google books
        var link=response.items[0].saleInfo.buyLink;
        var precio=response.items[0].saleInfo.listPrice.amount;
        var moneda=response.items[0].saleInfo.listPrice.currencyCode;
        if (link.localeCompare("undefined")==0) {
            link="";
            precio="";
            moneda="";
        }
        $("#compLib").append("<a href ='"+link+"' target='_blank'><button>Compra por Google Play "+precio+" "+moneda+" </button></a>");



        /*LLAMA A LA API DE EBAY*/
        var idC="EdissonS-booksear-PRD-18bb074f4-bbaf4fe2";

        $.get("http://open.api.ebay.com/shopping?version=515&appid="+idC+"&callname=FindItems&responseencoding=XML&QueryKeywords="+title+"&ItemSort=BestMatch", function(resp) {
            console.log(resp);

            var op1=resp.getElementsByTagName('ViewItemURLForNaturalSearch')[0].childNodes[0].nodeValue;
            var p_op1=resp.getElementsByTagName('ConvertedCurrentPrice')[0].childNodes[0].nodeValue;
            var op2=resp.getElementsByTagName('ViewItemURLForNaturalSearch')[1].childNodes[0].nodeValue;
            var p_op2=resp.getElementsByTagName('ConvertedCurrentPrice')[1].childNodes[0].nodeValue;
            console.log(op1);
            console.log(p_op1);
            console.log(op2);
            console.log(p_op2);

            //carga compra en google books
            $("#compLib").append("<a href ='"+op1+"' target='_blank'><button>Compra por eBay 1 "+p_op1+" USD </button></a>");
            $("#compLib").append("<a href ='"+op2+"' target='_blank'><button>Compra por eBay 2 "+p_op2+" USD </button></a>");
        });




    });

}
