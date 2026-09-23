package marco.spellsharrypotter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SpellPutRequestBody(
        @NotNull(message = "O id é obrigatório para atualização")
        Long id,

        @NotBlank(message = "O nome do feitiço é obrigatório")
        @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres")
        String name,

        @NotBlank(message = "O tipo do feitiço é obrigatório")
        String type,

        @NotBlank(message = "A descrição do feitiço é obrigatória")
        String description
) {}