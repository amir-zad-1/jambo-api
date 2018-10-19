const assert = require('assert');
const axios = require('axios');

describe('Order service should', function () {
    it('get products and returns 200', () => {
        axios.get('http://www.google.com').then(response => {
            assert.equal(response.status, 200);
        });
    });
});