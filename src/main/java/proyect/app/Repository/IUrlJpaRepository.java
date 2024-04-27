package proyect.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proyect.app.Model.Url;


public interface IUrlJpaRepository extends JpaRepository<Url, Long>{
    Url findByUrl(String randomId);
}
