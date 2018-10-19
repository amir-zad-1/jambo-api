const express = require('express');
const cookieParser = require('cookie-parser');
const bodyParser = require('body-parser');
const logger = require('morgan');

const indexRouter = require('./routes/index');
const productsRouter = require('./routes/products');
const ordersRouter = require('./routes/orders');

const app = express();


app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({extended: false}));
app.use(cookieParser());
app.use(bodyParser.json());

app.use('/', indexRouter);
app.use('/products/', productsRouter);
app.use('/orders/', ordersRouter);


// error handler
app.use(function (error, request, response, next) {
    // set locals, only providing error in development
    response.locals.message = error.message;
    response.locals.error = request.app.get('env') === 'development' ? error : {};

    // render the error page
    response.status(error.status || 500);
    response.render('error');
});

module.exports = app;
