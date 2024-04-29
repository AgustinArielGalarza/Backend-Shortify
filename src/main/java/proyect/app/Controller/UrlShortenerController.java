package proyect.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyect.app.Handler.ResponseHandler;
import proyect.app.Service.ShortenerSerivice;

import java.util.logging.Logger;

/**
 * Controller in charge of providing the endpoints with functionalities carried out directly to shorten the url
 */
@RestController
public class UrlShortenerController {

    private static final Logger logger = Logger.getLogger(UrlShortenerController.class.getName());

    @Autowired
    ShortenerSerivice shortener;

    /**
     * Controller in charge of finding the long url through the randomId
     * @param id id random generado por el service de shortenUrl
     * @return responseEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getUrl(@PathVariable String id) {
        logger.info("UrlShortenerController - getUrl -  request: " + id);
        ResponseHandler<String> response = shortener.page(id);
        ResponseEntity<?> responseEntity = ResponseEntity.status(HttpStatus.OK).body(response);
        logger.info("UrlShortenerController - getUrl -  response: " + responseEntity);
        return responseEntity;
    }

     /** Controller in charge of shortening url
     * @param longUrl long url sent to be cut
     * @return responseEntity
     */
    @PostMapping("/shorten")
    public ResponseEntity<?> shortenUrl(@RequestBody String longUrl) {
        logger.info("UrlShortenerController - shortenUrl -  request: " + longUrl);
        ResponseHandler<String> response = shortener.shorten(longUrl);
        ResponseEntity<?> responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(response);
        logger.info("UrlShortenerController - shortenUrl -  request: " + responseEntity);
        return responseEntity;
    }

}
