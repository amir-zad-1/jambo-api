package com.hypbox.jambo.model.dto;

public class ProductDeleteResponse {

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    private boolean ok;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public ProductDeleteResponse(Boolean ok) {
        this.setOk(ok);
        if (ok) {
            this.setMessage("The product removed successfully");
        } else {
            this.setMessage("Product remove failed");
        }
    }



}
