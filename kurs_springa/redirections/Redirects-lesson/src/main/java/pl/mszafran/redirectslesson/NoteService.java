package pl.mszafran.redirectslesson;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
class NoteService {
    private final Map<String, Note> notes = new HashMap<>();

    boolean save(Note note) {
        if (notes.containsKey(note.getId())) {
            return false;
        }
        {
            notes.put(note.getId(), note);
            return true;
        }
    }

    Optional<Note> findById(String id){
        return Optional.ofNullable(notes.get(id));
    }
}
