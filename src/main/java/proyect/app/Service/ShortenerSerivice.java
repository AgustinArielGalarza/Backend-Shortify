package proyect.app.Service;

import org.springframework.stereotype.Service;
import proyect.app.Service.Interface.ShortenerInterface;
import java.util.UUID;

@Service
public class ShortenerSerivice implements ShortenerInterface {

    @Override
    public String shorten(String text) {
        String uniqueID = generateUniqueID();
        System.out.println("uniqueID -> " + uniqueID);
        return "Success";
        }

        private String generateUniqueID() {
            UUID uuid = UUID.randomUUID();
            return uuid.toString().replace("-", "").substring(0, 8); // Obtener los primeros 8 caracteres del UUID
        }
}

