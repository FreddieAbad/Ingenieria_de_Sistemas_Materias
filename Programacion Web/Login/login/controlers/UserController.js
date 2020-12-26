var mysql= require('mysql');
var bcrypt=require('bcryptjs');
const request = require('request');

module.exports={
  getSignUp : function (req, res, next){
    return res.render('users/signup');
  },
  postSignUp: function(req, res, next){
    var salt=bcrypt.genSaltSync(10);
    var password = bcrypt.hashSync(req.body.password,salt);

    var user={
      email:req.body.email,
      nombre:req.body.nombre,
      password:password
    };
    var config=require('../database/config');
    var db=mysql.createConnection(config);
    db.connect();
    db.query('INSERT INTO users SET ?', user, function(err,rows,fields){
      if(err) throw err;

      db.end();
    });
    //muestro mensaje flash
    req.flash('info','Se ha registrado el mensaje correctamente, ya puede iniciar sesion');//lo llamo como info
    return res.redirect('/users/signin');
  },


  getSignIn: function(req,res, next){
    return res.render('users/signin', {message: req.flash('info'), authmessage : req.flash('authmessage')});//mensaje que se mostrara es info, message es como identifico en la vista cuando lo renderizo

  },

  logout : function(req, res, next){
    req.logout();
    res.redirect('/users/signin');
  },

  getUserPanel: function(req, res, next){
    res.render('users/panel', {
      isAuthenticated: req.isAuthenticated(),
      user: req.user
    });
  },

  getAdminPanel: function(req, res, next){
    return res.render('users/panelAdmin', {
      isAuthenticated: req.isAuthenticated(),
      user: req.user
    });
  },

  getUserPnl: function(req, res, next){
    return res.render('users/pnlUsuarios', {
      isAuthenticated: req.isAuthenticated(),
      user: req.user
    });
  },
  getBusqueda: function(req, res, next){
    return res.render('users/busqueda', {
      isAuthenticated: req.isAuthenticated(),
      user: req.user
    });
  },
  //postBusqueda
  postBusqueda: function(req, res){
    const autor = req.body.autor;
    const cantidad = req.body.cantidad;

    const apikey="AIzaSyDpVa5DQPqJnzc45k6YQa0CMmPEQL2bODE";
    const cox="005416834225651398663:east8tfzz1k";
    // Obtener la info
    let urlWiki = "https://es.wikipedia.org/w/api.php?action=opensearch&format=json&search=" + autor;
    let urlGoogleBooks = "https://www.googleapis.com/books/v1/volumes?q="+autor+"&inauthor&maxResults="+cantidad
    let urlGooglCustom = "https://www.googleapis.com/customsearch/v1?key="+apikey+"&cx="+cox+"&searchType:\"image\"&q="+autor;

    request.get(urlWiki, (err, resp, wikipedia) => {
      if(err) console.log(err);
      if(resp.statusCode == 200){

        request.get(urlGoogleBooks, (err2, resp2, books) => {
          if(err2) console.log(err2);
          if(resp2.statusCode == 200){

            request.get(urlGooglCustom, (err3, resp3, image) => {
              if(err3) console.log(err3);
              if(resp3.statusCode == 200){
                return res.render('users/resultadoBusqueda', {
                  isAuthenticated: req.isAuthenticated(),
                  user: req.user,
                  wikipedia: JSON.parse(wikipedia),
                  books: JSON.parse(books),
                  image: JSON.parse(image)
                });
              }
            });
          }
    });
  }})},
  getbookDet:function(req, res, next){
    return res.render('users/bookDet', {
      isAuthenticated: req.isAuthenticated(),
      user: req.user
    });
  },
  getPnlRes: function(req, res, next){
    return res.render('users/panelReserva', {
      isAuthenticated: req.isAuthenticated(),
      user: req.user
    });
  },

  postIngPaq: function(req, res, next){
    console.log(req.body);

    var user= {
      nomP : req.body.nombrePaqueteI,
      costo : req.body.costoI,
      cupos : req.body.nCupoI,
      categoria: String(req.body.categoriaI),//getElementById('categoriaI').selectedIndex,
      infoAdicional: req.body.infoadicionalI//getElementById("infoadicionalI").value
    };
    //console.log(user);
    var config=require('../database/config');
    var db=mysql.createConnection(config);
    db.connect();
    db.query('INSERT INTO paq SET ?', user, function(err,rows,fields){
      if(err) throw err;

      db.end();
    });
    //muestro mensaje flash
    req.flash('info','Se ha registrado el mensaje correctamente, ya puede iniciar sesion');//lo llamo como info
    return res.redirect('/users/panelAdmin');
  },
  postUpdPaq: function(req, res, next){
    console.log(req.body);
    var user = {
      nomP : req.body.nombrePaqueteU,
      costo : req.body.costoU,
      cupos : req.body.nCupoU,
      categoria: String(req.body.categoriaU),//getElementById('categoriaI').selectedIndex,
      infoAdicional: req.body.infoadicionalU//getElementById("infoadicionalI").value
    };
    console.log(user);
    var config=require('../database/config');
    var db=mysql.createConnection(config);
    db.connect();
    db.query('UPDATE paq SET ? WHERE id = '+ req.body.nombrePaqueteU, user, function(err,rows,fields){
      if(err) throw err;

      db.end();
    });
    //muestro mensaje flash
    req.flash('info','Se ha actualizado el mensaje correctamente, ya puede iniciar sesion');//lo llamo como info
    return res.redirect('/users/panelAdmin');
  }
};
