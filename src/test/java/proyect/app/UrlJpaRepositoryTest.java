package proyect.app;

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
        Url url1 = new Url("asdlhk", "https://www.linkedin.com/in/agustin");
        Url url2 = new Url("asdlhk", "https://www.linkedin.com/in/agustin2/");

        repo.save(url1);
        repo.save(url2);

        repo.flush();

        assertEquals(2, repo.findAll().size(), "Correcto!");
    }
}
