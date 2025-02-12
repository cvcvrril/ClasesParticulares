package model.errors;

public class ErrorObject {

    private String message;
    private int numError;

    public ErrorObject(String message, int numError) {
        this.message = message;
        this.numError = numError;
    }
}
