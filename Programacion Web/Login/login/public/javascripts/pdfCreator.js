var pdf = require('pdfkit');
var fs = require('fs');
var myDoc = new pdf;

myDoc.pipe(fs.createWriteStream('nombreArchivo'+'nombrePaquete'+'fecha'+'.pdf'));

myDoc.font('Times-Roman')
  .fontSize(48)
  .text('Confirmacion de Compra de Paquete', 100, 100);

myDoc.end();
