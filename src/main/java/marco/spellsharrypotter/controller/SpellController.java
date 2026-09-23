package marco.spellsharrypotter.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import marco.spellsharrypotter.dto.SpellPostRequestBody;
import marco.spellsharrypotter.dto.SpellPutRequestBody;
import marco.spellsharrypotter.model.Spell;
import marco.spellsharrypotter.service.SpellService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spells")
@RequiredArgsConstructor
public class SpellController {

    private final SpellService spellService;

    @GetMapping
    public List<Spell> listAll() {
        return spellService.listAll();
    }

    @GetMapping("{id}")
    public Spell findById(@PathVariable Long id) {
        return spellService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Spell save(@RequestBody @Valid SpellPostRequestBody spellPostRequestBody) {
        return spellService.save(spellPostRequestBody);
    }

    @PutMapping
    public Spell replace(@RequestBody @Valid SpellPutRequestBody spellPutRequestBody) {
        return spellService.replace(spellPutRequestBody);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        spellService.delete(id);
    }
}