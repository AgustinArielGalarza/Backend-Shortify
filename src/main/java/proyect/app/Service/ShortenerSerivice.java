package proyect.app.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import proyect.app.Handler.ResponseHandler;
import proyect.app.Model.Url;
import proyect.app.Repository.IUrlJpaRepository;
import proyect.app.Service.Interface.ShortenerInterface;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * Service where the main logic occurs implementing ShortenerInterface
 */
@Service
public class ShortenerSerivice implements ShortenerInterface {

    private static final Logger logger = Logger.getLogger(ShortenerSerivice.class.getName());

    @Autowired
    IUrlJpaRepository repo;

    @Value("${url.base.response}")
    private String urlBase;


    @Override
    public ResponseHandler<String> shorten(String urlRequest) {
        logger.info("ShortenerSerivice - shorten -  request: " + urlRequest);
        String uniqueID = generateUniqueID();
        Url url = new Url(uniqueID, urlRequest);
        repo.save(url);
        ResponseHandler<String> responseHandler = new ResponseHandler<>(HttpStatus.CREATED.value(), "URL acortada correctamente",urlBase + uniqueID, 1);
        logger.info("ShortenerSerivice - shorten -  response: " + responseHandler);
        return responseHandler;
    }

    @Override
    public ResponseHandler<String> page(String urlRequest) {
        logger.info("ShortenerSerivice - page -  request: " + urlRequest);
        Url url;
        String urlJson = "";
        try {
            url = repo.findByRandomId(urlRequest);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(url.getUrl());
            urlJson = jsonNode.get("url").asText();
        } catch (Exception e) {
            logger.severe("Error al obtener el url: " + e.getMessage());
            return new ResponseHandler<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al obtener el url: " + e.getMessage());
        }
        ResponseHandler<String> responseHandler = new ResponseHandler<>(HttpStatus.CREATED.value(), "URL encontrada", urlJson, 1);
        logger.info("ShortenerSerivice - page -  response: " + responseHandler);
        return responseHandler;
    }

        /**
        * This function returns a short random string that will be used as the id
        */
        private String generateUniqueID() {
            UUID uuid = UUID.randomUUID();
            return uuid.toString().replace("-", "").substring(0, 8);
        }
}

