var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
var indexRouter = require('./routes/routes');
var flash = require('connect-flash');
//express-session es para no guardar la sesion, es decir sin cookie
//var session=require('express-session');
//cookie session es para usar cookies
var cookieSession=require('cookie-session');

var passport = require('passport');
require('./passport/passport')(passport);

//var usersRouter = require('./routes/users');

var app = express();

app.use(cookieParser());
//secret es cuando quiero recuperar variables de sesion, porque sino otras aplicaciones verian mis datos, solo el servidor sabe y compara clave secreta
//Cambio
/*app.use(session({
  secret: 'secret',
  resave: false,
  saveUninitialized: false,
}));*/
app.use(cookieSession({
  name: "session",
  keys: ["llave-1","llave-2"]
}));
//inicializo modulo  flash con middleware use
app.use(flash());


// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public')));
app.use(express.static(path.join(__dirname, 'js')));

//creo middleware que connecta passport con las aplicaicones
app.use(passport.initialize());
app.use(passport.session());

app.use('/', indexRouter);
//app.use('/users', usersRouter);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
