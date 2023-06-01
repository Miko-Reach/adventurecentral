package orange.java.pl2.adventurecentral.options;

import jakarta.persistence.*;

 @Entity
    @Table(name = "Hotels")

    public class Countries extends Continent {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;


        @Column(name = "Country Name")
        private String countryName;

}