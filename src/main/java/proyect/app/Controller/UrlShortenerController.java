package proyect.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyect.app.Service.ShortenerSerivice;

@RestController
public class UrlShortenerController {

    @Autowired
    ShortenerSerivice shortener;

    @GetMapping("/{id}")
    public String getUrl(@PathVariable String id) {return ""; }

    @PostMapping("/shorten")
    public String crate(@RequestBody String longUrl) {

        String response = shortener.shorten(longUrl);

        return "Success";
    }
}
