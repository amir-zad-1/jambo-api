const express = require('express');
const router = express.Router();
const axios = require('axios');

const utility = require('../utility/utility');

const API_BASE_URL = "http://localhost:8081/";
const API_PRODUCT_SERVICE_ENDPOINT = API_BASE_URL + "products";

router.get('/', (request, response) => {
    axios.get(API_PRODUCT_SERVICE_ENDPOINT + "/").then(getResponse => {
        return response.send(getResponse.data);
    }).catch(error => {
        return utility.handleError(response, error);
    });
    // todo: filters
});

router.get('/:id', (request, response) => {
    const productId = request.params.id;
    axios.get(API_PRODUCT_SERVICE_ENDPOINT + "/" + productId).then(getResponse => {
        return response.send(getResponse.data);
    }).catch(error => {
        return utility.handleError(response, error);
    });
});

router.post('/', (request, response) => {
    const postData = request.body;
    axios.post(API_PRODUCT_SERVICE_ENDPOINT + "/", postData).then(postResponse => {
        return response.status(201).send(postResponse.data);
    }).catch(error => {
        return utility.handleError(response, error);
    });

});

router.put('/', (request, response) => {
    const putData = request.body;
    axios.put(API_PRODUCT_SERVICE_ENDPOINT + "/", putData).then(putResponse => {
        return response.status(202).send(putResponse.data);
    }).catch(error => {
        return utility.handleError(response, error);
    });
});

router.delete('/:id', (request, response) => {
    const productId = request.params.id;
    axios.delete(API_PRODUCT_SERVICE_ENDPOINT + "/" + productId).then(deleteResponse => {
        return response.status(204).send(deleteResponse.data);
    }).catch(error => {
        return utility.handleError(response, error);
    });
});

module.exports = router;
