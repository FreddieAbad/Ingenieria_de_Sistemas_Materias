//middleware de autentificacion
module.exports={
  isLogged : function(req, res, next){
    if(req.isAuthenticated()){
      next(); //siguiente preticion
    }else{
      res.redirect('/users/signin');
    }
  }
}
