package equipment;

public class Seeder {

        static final Double DEFAULT_VALUE_FOR_SALE = 10000.00;
        private Integer width;
        private Double value;
        private Integer capacity;
        private Boolean trackEradicator;

        public Seeder(Integer width, Integer capacity){
            this.capacity = 350;
            this.width = 3;
            this.trackEradicator = true;
            this.value = DEFAULT_VALUE_FOR_SALE;
        }

        @Override
        public String toString() {
            return "\n\tSiewnik: " +
                    "szerokość robocza: " + width + "m, " +
                    "pojemność skrzyni ładunkowej: " + capacity + "dm3, " +
                    "spulchniacz śladów: " + trackEradicator
                    ;
        }
    }
