package pl.mszafran.fragments;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
class ProductRepository {
    private final List<Product> products;

    ProductRepository(){
        this.products = List.of(
                new Product(1L, "Telewizor", "Znakomity telewizor Oled z dźwiękiem przestrzennym i niesamowitymi kolorami",
                        4999, "tv"),
                new Product(2L, "iPhone", "Telefon, który ułatwi Ci codzienne czynności i o niczym nie zapomnisz",
                        3499, "mobile"),
                new Product(3L, "Mikrofon", "Nagrywasz podcasty, wywiady, albo notatki głosowe? Ten mikrofon zapewni" +
                        "jakość dźwięku, która zachwyci nie tylko Ciebie, ale i Twoich słuchaczy.",
                        699, "microphone-alt"));
    }

    List<Product> findAll(){
        return products;
    }

    Optional<Product> findById(Long id){
        for (Product x : products) {
            if(x.getId().equals(id)){
                return Optional.of(x);
            }
        }
        return Optional.empty();
    }
}
