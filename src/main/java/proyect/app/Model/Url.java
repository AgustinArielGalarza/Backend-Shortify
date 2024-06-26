package proyect.app.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

/**
 *Entity used with hibernate to generate the table and apply ORM.
 */
@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 25, nullable = false)
    private String randomId;
    @Column(columnDefinition = "TEXT")
    private String url;

    public Url(String randomId, String url) {
        this.randomId = randomId;
        this.url = url;
    }

    public Url(Long id, String randomId, String url) {
        this.id = id;
        this.randomId = randomId;
        this.url = url;
    }

    public Url() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRandomId() {
        return randomId;
    }

    public void setRandomId(String randomId) {
        this.randomId = randomId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", randomId='" + randomId + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Url url1 = (Url) o;
        return id == url1.id && Objects.equals(randomId, url1.randomId) && Objects.equals(url, url1.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, randomId, url);
    }
}
