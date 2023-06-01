package orange.java.pl2.adventurecentral.options;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

public class Countries {

    @Entity
    @Table(name =  "countryName");

    String countryContinent;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryContinent() {
        return countryContinent;
    }

    public void setCountryContinent(String countryContinent) {
        this.countryContinent = countryContinent;
    }
}




// @Entity
//    @Table(name = "Hotels")
//
//    public class Hotels extends Cities {
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Long id;
//
//
//        @Column(name = "hotel_name")
//        private String HotelName;
//
//        @Column(name = "hotel_description")
//        private String hotelDescription;
//
//
//        @Column(name = "hotel_rating")
//        private int hotelRating;
//
//
//
//        //ht to Id dla hoteli wygenerowane
//        @jakarta.persistence.Id
//        @GeneratedValue
//        private Long ht;
//
//
//        public void setHt(Long ht) {
//            this.ht = ht;
//        }
//
//        public Long getHt() {
//            return ht;
//        }
//
//    }
//}