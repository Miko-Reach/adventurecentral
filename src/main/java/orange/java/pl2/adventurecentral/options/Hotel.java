package orange.java.pl2.adventurecentral.options;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

//public class Hotel extends Cities {


public class Hotel extends Cities {


//    Hotel¶
//
//    nazwa
//    standard (ilość gwiazdek)
//    opis
//    przynależność do miasta (klucz obcy)



    @Entity
    @Table(name = "Hotels")

    public class Hotels extends Cities {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;


        @Column(name = "hotel_name")
        private String HotelName;

        @Column(name = "hotel_description")
        private String hotelDescription;


        @Column(name = "hotel_rating")
        private int hotelRating;



        //ht to Id dla hoteli wygenerowane
        @jakarta.persistence.Id
        @GeneratedValue
        private Long ht;


        public void setHt(Long ht) {
            this.ht = ht;
        }

        public Long getHt() {
            return ht;
        }

    }
}
