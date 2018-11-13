const chai = require("chai");
const assert = chai.assert;
const chaiHttp = require("chai-http");

chai.use(chaiHttp);

const API_BASE_URL = "http://localhost:8080/";
const API_PRODUCTS_ENDPOINT = API_BASE_URL + "products";

const resetAPI = () => {
    return new Promise((resolve, reject) => {
        chai.request(API_BASE_URL).post("/reset").end((error, response) => {
            if (error) return reject(error);
            return resolve(response.body);
        });
    });
};

const addAProduct = (data) => {
    return new Promise((resolve, reject) => {
        chai.request(API_PRODUCTS_ENDPOINT).post("/").send(data).end((error, postResponse) => {
            if (error) return reject(error);
            return resolve(postResponse.body);
        });
    });

};