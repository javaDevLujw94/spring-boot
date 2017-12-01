package top.lujianwei.boot.springboot.model;

public class LujwResponse {

    private String responseMessage;

    public LujwResponse(){};

    public LujwResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
