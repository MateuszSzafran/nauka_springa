package pl.mszafran.redirectslesson;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Controller
class NoteController {

    private final NoteService noteService;

    NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/save")
    RedirectView save(@RequestParam String id,
                      @RequestParam String text) {
        Note note = new Note(id, text);
        boolean saved = noteService.save(note);
        if (saved) {
            String url = UriComponentsBuilder
                    .fromPath("note")
                    .queryParam("id", id)
                    .build()
                    .toString();
            return new RedirectView(url,true, false);
        } else {
            return new RedirectView("duplicate", true, false);
        }
    }

    @GetMapping("/note")
    String getNote(@RequestParam String id, Model model) {

        noteService.findById(id).ifPresent((x)->model.addAttribute("note", x));
        return "note";
    }

    @GetMapping("/duplicate")
    String wrongData(){
        return "wrong-data";
    }
}
