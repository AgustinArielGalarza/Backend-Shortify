package proyect.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyect.app.Handler.ResponseHandler;
import proyect.app.Service.ShortenerSerivice;

@RestController
public class UrlShortenerController {

    @Autowired
    ShortenerSerivice shortener;

    @GetMapping("/{id}")
    public String getUrl(@PathVariable String id) {
        String response = shortener.page(id);
        System.out.println("response -> "+ response);
        return response;
    }

    @RestController
    public class ShortenController {

        @PostMapping("/shorten")
        public ResponseEntity<?> shortenUrl(@RequestBody String longUrl) {
            ResponseHandler<String> response = shortener.shorten(longUrl);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
    }
}
