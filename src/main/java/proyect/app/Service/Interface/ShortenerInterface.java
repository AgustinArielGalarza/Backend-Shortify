package proyect.app.Service.Interface;

import proyect.app.Handler.ResponseHandler;

public interface ShortenerInterface {
    public ResponseHandler<String> shorten(String urlRequest);
    public String page(String idUrl);
}
