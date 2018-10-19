const express = require('express');
const router = express.Router();


router.get('/', function (request, response, next) {
    const testResponse = {ok: true, message: "JAMBO API GATEWAY"};
    response.json(testResponse);
});

module.exports = router;
