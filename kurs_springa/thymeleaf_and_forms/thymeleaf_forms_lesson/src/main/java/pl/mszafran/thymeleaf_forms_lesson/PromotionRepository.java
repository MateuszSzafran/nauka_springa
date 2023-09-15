package pl.mszafran.thymeleaf_forms_lesson;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
class PromotionRepository {
    private final List<Promotion> promotions = new LinkedList<>();

    List<Promotion> findAll(){
        return promotions;
    }

    void add(Promotion promotion){
        promotions.add(0,promotion);
    }

}
