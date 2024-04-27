package proyect.app.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import proyect.app.Model.Url;
import proyect.app.Repository.IUrlJpaRepository;
import proyect.app.Service.Interface.ShortenerInterface;
import java.util.UUID;

@Service
public class ShortenerSerivice implements ShortenerInterface {

    @Autowired
    IUrlJpaRepository repo;

    @Value("${url.base.response}")
    private String urlBase;

    @Override
    public String shorten(String urlRequest) {
        String uniqueID = generateUniqueID();
        Url url = new Url(uniqueID, urlRequest);
        repo.save(url);
        return urlBase + uniqueID;
    }

    @Override
    public String page(String urlRequest) {
        Url url;
        String urlJson = "";
        try {
            url = repo.findByRandomId(urlRequest);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(url.getUrl());
            urlJson = jsonNode.get("url").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlJson;
    }

        private String generateUniqueID() {
            UUID uuid = UUID.randomUUID();
            return uuid.toString().replace("-", "").substring(0, 8);
        }
}

