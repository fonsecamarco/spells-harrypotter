package marco.spellsharrypotter.service;

import lombok.RequiredArgsConstructor;
import marco.spellsharrypotter.dto.SpellPostRequestBody;
import marco.spellsharrypotter.dto.SpellPutRequestBody;
import marco.spellsharrypotter.model.Spell;
import marco.spellsharrypotter.repository.SpellRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpellService {

    private final SpellRepository spellRepository;

    public List<Spell> listAll() {
        return spellRepository.findAll();
    }

    public Spell findById(Long id) {
        return spellRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Feitiço não encontrado"));
    }

    public Spell save(SpellPostRequestBody spellPostRequestBody) {
        Spell spell = new Spell();
        spell.setName(spellPostRequestBody.name());
        spell.setType(spellPostRequestBody.type());
        spell.setDescription(spellPostRequestBody.description());

        return spellRepository.save(spell);
    }

    public Spell replace(SpellPutRequestBody spellPutRequestBody) {
        Spell savedSpell = findById(spellPutRequestBody.id());

        savedSpell.setName(spellPutRequestBody.name());
        savedSpell.setType(spellPutRequestBody.type());
        savedSpell.setDescription(spellPutRequestBody.description());

        return spellRepository.save(savedSpell);
    }

    public void delete(Long id) {
        Spell spell = findById(id);
        spellRepository.delete(spell);
    }
}