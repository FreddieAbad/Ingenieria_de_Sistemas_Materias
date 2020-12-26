const request = require('request');


module.exports= {
  detalle : function(req, res, next){
    //renderizo la vistas de la carpeta views-->
    const id = req.params.id;
    const url = "https://www.googleapis.com/books/v1/volumes?q=id:" + id;


    request.get(url, (err, resp, libro) => {
      if(err) console.log(err);
      if(resp.statusCode == 200){
        const tituloLibro = JSON.parse(libro).items[0].volumeInfo.title;
        console.log(libro)
        //console.log(tituloLibro);
        /*LLAMA A LA API DE EBAY*/
        const idC="EdissonS-booksear-PRD-18bb074f4-bbaf4fe2";
        const urlEbay = "http://open.api.ebay.com/shopping?version=515&appid="+idC+"&callname=FindItems&responseencoding=JSON&QueryKeywords="+tituloLibro+"&ItemSort=BestMatch";
        //console.log(urlEbay);
        request.get(urlEbay, (err2, resp2, ebay) => {
          if(err2) console.log(err2);
          if(resp2.statusCode == 200){
            /*console.log(JSON.parse(ebay))
            console.log(ebay)*/
            //console.log(libro)
            /*console.log(JSON.parse(libro.saleInfo.listPrice.amount))*/

            res.render('users/detalleLibro', {libro: JSON.parse(libro).items[0], ebay: JSON.parse(ebay)});

          }
        })
      }
    });


  }
}
