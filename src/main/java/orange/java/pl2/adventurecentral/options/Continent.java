package orange.java.pl2.adventurecentral.options;

import jakarta.persistence.*;

    @Entity
    @Table(name = "Continents")

public class Continent {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "Continent Name")
        private String continentName;

    }