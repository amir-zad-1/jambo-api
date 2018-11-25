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
    const id = request.params.id;
    const output = {};
    response.json(output);
});

router.post('/', (request, response) => {
    const output = {};
    console.log(request.body);
    response.status(201);
    response.json(output);
});

router.post('/:id/cancel', (request, response) => {
    const id = request.params.id;
    const output = {};
    response.json(output);
});

module.exports = router;