package proyect.app.Service.Interface;

import proyect.app.Handler.ResponseHandler;

/**
 * Interface in charge of providing functionalities directly related to shortening the url
 */
public interface ShortenerInterface {
   /**
    * Service responsible for saving the long url and returning a shorter one
    * @param urlRequest long url to cut
    * @return ResponseHandler
    */
    public ResponseHandler<String> shorten(String urlRequest);

    /**
     * Service responsible for returning the original url through idrandom
     * @param urlRequest short url to cut
     * @return ResponseHandler
     */
    public ResponseHandler<String> page(String urlRequest);
}
