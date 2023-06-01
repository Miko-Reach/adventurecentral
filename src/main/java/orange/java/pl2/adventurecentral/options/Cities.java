package orange.java.pl2.adventurecentral.options;

import jakarta.persistence.*;

@Entity
@Table(name = "Cities")

public class Cities extends Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "City Name")
    private String cityName;
}
