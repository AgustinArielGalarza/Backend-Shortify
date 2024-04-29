package proyect.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proyect.app.Model.Url;

/**
 * Interface responsible for providing the repository functionalities
 */
public interface IUrlJpaRepository extends JpaRepository<Url, String>{
   /**
    * Function that returns an Entity Url through the randomId
    */
    Url findByRandomId(String randomId);
}
