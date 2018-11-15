const chai = require("chai");
const assert = chai.assert;
const chaiHttp = require("chai-http");

chai.use(chaiHttp);


const API_BASE_URL = "http://localhost:8080/";
const API_PRODUCT_SERVICE_ENDPOINT = API_BASE_URL + "products";

const resetAPI = () => {
    return new Promise((resolve, reject) => {
        chai.request(API_BASE_URL).post("/reset").end((error, response) => {
            if (error) return reject(error);
            return resolve(response.body);
        });
    });
};

const addProduct = (data) => {
    return new Promise((resolve, reject) => {
        chai.request(API_PRODUCT_SERVICE_ENDPOINT).post("/").send(data).end((error, postResponse) => {
            if (error) return reject(error);
            return resolve(postResponse.body);
        });
    });

};

describe("Product service", () => {

    describe("at the beginning ", () => {

        beforeEach(done => {
            resetAPI().then(resetResponse => {
                assert.equal(resetResponse.ok, true);
                done();
            }).catch(error => done(error));
        });

        it("returns a list containing 1 product", done => {
            chai.request(API_PRODUCT_SERVICE_ENDPOINT).get("/").end((error, response) => {
                if (error) done(error);
                assert.equal(response.body.length, 1);
                done();
            });
        });

    });

    it("returns 404 error when non-existed product id is received", done => {
        const nonExistedId = 10;
        chai.request(API_PRODUCT_SERVICE_ENDPOINT).get("/" + nonExistedId).end((error, response) => {
            assert.equal(response.statusCode, 404);
            done();
        });
    });


    describe("adds a product and ", () => {

        const productData = {
            title: "sample product",
            description: "description of sample data",
            price: 10.01,
            imageUrl: 'imageUrl.com',
            supplierUrl: 'supplierLink.com'
        };
        let newProduct;

        beforeEach(done => {
            addProduct(productData).then(product => {
                newProduct = product;
                done();
            }).catch(error => done(error));
        });

        afterEach(done => {
            resetAPI().then(resetResponse => {
                assert.equal(resetResponse.ok, true);
                done();
            }).catch(error => done(error));
        });

        it("product list should return a list containing 2 products", done => {
            chai.request(API_PRODUCT_SERVICE_ENDPOINT).get("/").end((error, response) => {
                if (error) done(error);
                assert.equal(response.body.length, 2);
                done();
            });
        });

        it("product list should return a list containing 1 product", done => {
            chai.request(API_PRODUCT_SERVICE_ENDPOINT).get("/searchByTitle/sample product").end((error, response) => {
                if (error) done(error);
                assert.equal(response.body.length, 1);
                done();
            });
        });

        it("product list should return a list containing 1 product", done => {
            chai.request(API_PRODUCT_SERVICE_ENDPOINT).get("/searchByTitle/notExistsprduct").end((error, response) => {
                if (error) done(error);
                assert.equal(response.body.length, 0);
                done();
            });
        });

        it("the price of added product should be " + productData.price, done => {
            assert.equal(newProduct.price, productData.price);
            done();
        });

        it("update product price to 20.02 and the price of updated product should be 20.02", done => {
            const updateData = {
                id: newProduct.id,
                title: "sample product",
                description: "description of sample data",
                price: 20.02,
                imageUrl: 'imageUrl.com',
                supplierUrl: 'supplierLink.com'
            };
            chai.request(API_PRODUCT_SERVICE_ENDPOINT).put("/").send(updateData).end((error, putResponse) => {
                if (error) return done(error);
                assert.equal(putResponse.body.price, 20.02);
                done();
            });
        });

        it("delete product returns success with value of true", done => {
            chai.request(API_PRODUCT_SERVICE_ENDPOINT).delete("/" + newProduct.id).end((error, deleteResponse) => {
                if (error) return done(error);
                assert.isOk(deleteResponse.body.ok);
                done();
            });
        });

    });

});

	
