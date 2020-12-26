module.exports= {
  index : function(req, res, next){
    //renderizo la vistas de la carpeta views-->
    res.render('home', {
      isAuthenticated: req.isAuthenticated(),
      user: req.user 
    });
  }
}
