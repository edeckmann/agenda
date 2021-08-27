package eng.elemar.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eng.elemar.agenda.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
