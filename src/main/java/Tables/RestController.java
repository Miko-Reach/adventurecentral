package Tables;


import jakarta.persistence.EntityManager;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final EntityManager em;

    public RestController( EntityManager em) {
        this.em = em;
    }
}
