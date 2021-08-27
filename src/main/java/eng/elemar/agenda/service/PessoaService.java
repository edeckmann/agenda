package eng.elemar.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.elemar.agenda.exceptions.BusinessException;
import eng.elemar.agenda.exceptions.NotFoundException;
import eng.elemar.agenda.mapper.MapperUtil;
import eng.elemar.agenda.model.Pessoa;
import eng.elemar.agenda.model.dto.PessoaDTO;
import eng.elemar.agenda.repository.PessoaRepository;
import eng.elemar.agenda.utils.MessageUtils;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private MapperUtil mapper;

    @Transactional
    public PessoaDTO save(PessoaDTO dto) {
        Pessoa pessoa = mapper.mapTo(dto, Pessoa.class);
        repository.save(pessoa);
        return mapper.mapTo(pessoa, PessoaDTO.class);
    }

    @Transactional
    public PessoaDTO update(PessoaDTO dto) {
        Optional<Pessoa> optionalPessoa = repository.findById(dto.getId());
        if (!optionalPessoa.isPresent()) {
            throw new BusinessException(MessageUtils.ENTITY_NOT_EXISTS);
        }
        Pessoa Pessoa = mapper.mapTo(dto, Pessoa.class);
        repository.save(Pessoa);
        return mapper.mapTo(Pessoa, PessoaDTO.class);
    }

    @Transactional(readOnly = true)
    public List<PessoaDTO> findAll() {
        List<Pessoa> list = repository.findAll();
        return mapper.mapList(list, PessoaDTO.class);
    }

    @Transactional(readOnly = true)
    public PessoaDTO findById(Long id) {
        Pessoa pessoa = repository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.mapTo(pessoa, PessoaDTO.class);
    }

}
