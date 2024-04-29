package proyect.app.Handler;

/**
 * Class developed to customize the type of response
 * @param <T> String by url
 */
public class ResponseHandler<T> {
    private int status;
    private String message;
    private T data;
    private int total;


    public ResponseHandler() {
    }

    public ResponseHandler(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseHandler(int status, String message, T data, int total) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.total = total;

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
