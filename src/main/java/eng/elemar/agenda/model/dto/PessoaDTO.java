package eng.elemar.agenda.model.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import eng.elemar.agenda.model.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String nome;

    @Size(min = 2, max = 100)
    private String sobrenome;

    private LocalDate dataNascimento;

    @Valid
    @NotEmpty
    private List<Telefone> telefones;
}
