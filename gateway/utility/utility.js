exports.handleError = (response, error) => {
    console.log("[x] ", error);
    return response.status(500)
};