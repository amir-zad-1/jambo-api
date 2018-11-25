const express = require('express');
const router = express.Router();
const axios = require('axios');

const API_ORDER_BASE_URL = "http://order-api:8080/ordering/";
const API_ORDER_SERVICE_ENDPOINT = API_ORDER_BASE_URL + "orders";


router.get('/', (request, response) => {
    axios.get(API_ORDER_SERVICE_ENDPOINT + "/").then(getResponse => {
        return response.send(getResponse.data);
    }).catch(error => {
        return utility.handleError(response, error);
    });
});

router.get('/:id', (request, response) => {
    const orderId = request.params.id;
    axios.get(API_ORDER_SERVICE_ENDPOINT + "/" + orderId).then(getResponse => {
        return response.send(getResponse.data);
    }).catch(error => {
        return utility.handleError(response, error);
    });
});

router.post('/', (request, response) => {
    const output = {};
    console.log(request.body);
    response.status(201);
    response.json(output);
});

router.get('/:id/cancel', (request, response) => {
    const orderId = request.params.id;
    axios.get(API_ORDER_SERVICE_ENDPOINT + "/" + orderId + "/cancel").then(getResponse => {
        return response.send(getResponse.data);
    }).catch(error => {
        return utility.handleError(response, error);
    });
});

module.exports = router;