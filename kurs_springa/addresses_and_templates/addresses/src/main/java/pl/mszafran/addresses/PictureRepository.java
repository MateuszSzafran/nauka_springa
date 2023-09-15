package pl.mszafran.addresses;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
class PictureRepository {
    private final Map<String, Picture> pictures;

    PictureRepository() {
        this.pictures = new HashMap<>();
        Picture dogPicture = new Picture("dog", "Pies w okularach", "dog-glasses.jpg");
        Picture catPicture = new Picture("cat", "Gruby, rudy kot", "fat-cat.jpg");
        Picture mousePicture = new Picture("mouse", "Mysz z orzechami", "mouse.jpg");
        pictures.put(dogPicture.getId(), dogPicture);
        pictures.put(catPicture.getId(), catPicture);
        pictures.put(mousePicture.getId(), mousePicture);
    }

    Optional<Picture> findById(String id){
        return Optional.ofNullable(pictures.get(id));
    }

    Collection<Picture> findAll(){
        return pictures.values();
    }
}
