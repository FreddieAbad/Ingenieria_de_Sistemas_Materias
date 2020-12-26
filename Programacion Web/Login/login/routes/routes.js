var express = require('express');
var router = express.Router();
var controllers=require('.././controlers');
var passport=require('passport');
var AuthMiddleware=require('.././middleware/auth');
router.get('/', controllers.HomeControler.index);
//rutas de usuario
router.get('/users/signup', controllers.UserController.getSignUp);
router.post('/users/signup', controllers.UserController.postSignUp);
router.get('/users/signin', controllers.UserController.getSignIn);
router.post('/users/signin', passport.authenticate('local',{
  //cuando autentificacion es correcta entra sino a otras
  successRedirect:'/users/panel',
  failureRedirect: '/users/signin',
  failureFlash: true //mensaje cuando fallas
}));
// Rutas de LIBROS
//router.get('/detalle', controllers.bookController.detalle);
router.get('/detalle/:id', controllers.bookController.detalle);

router.get('/users/logout', controllers.UserController.logout);
router.get('/users/panel', AuthMiddleware.isLogged,controllers.UserController.getUserPanel);  //AuthMiddleware es  para ver si esta autenticado el usuario
//a todas las urls protegidas debo agregar AuthMiddleware.isLogged
router.get('/users/panelAdmin', controllers.UserController.getAdminPanel);
router.get('/users/pnlUsuarios', controllers.UserController.getUserPnl);
router.get('/users/busqueda', controllers.UserController.getBusqueda);
router.post('/users/busqueda', controllers.UserController.postBusqueda);
router.get('/users/bookDet', controllers.UserController.getbookDet);

// router.get('/users/subPnlAdminPaquetes', controllers.UserController.getAdminPanel);
router.post('/users/panelAdmin', controllers.UserController.postIngPaq);
router.get('/users/panelReserva', controllers.UserController.getPnlRes);
router.put('/users/panelAdmin', controllers.UserController.postUpdPaq);
//router.get('/users/subPnlAdminUsuarios', controllers.UserController.getAdminPanel);

module.exports = router;
