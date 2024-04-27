package proyect.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import proyect.app.Model.Url;
import proyect.app.Repository.IUrlJpaRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UrlJpaRepositoryTest {

    @Autowired
    private IUrlJpaRepository repo;

    @Test
    public void saveUrl(){
        int total = repo.findAll().size();

        Url url1 = new Url("asdlhk", "https://www.linkedin.com/in/agustin");
        Url url2 = new Url("asdlhk", "https://www.linkedin.com/in/agustin2/");

        repo.save(url1);
        repo.save(url2);

        repo.flush();

        assertEquals(total + 2, repo.findAll().size(), "Correcto!");
    }

    @Test
    public void getUrlByRandomId(){
        String urlRequest = "62574e7a";
        try {
            Url url = repo.findByRandomId(urlRequest);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(url.getUrl());
            String urlJson = jsonNode.get("url").asText();

            assertEquals("https://www.instagram.com/aguusglz/", urlJson, "Correcto!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
