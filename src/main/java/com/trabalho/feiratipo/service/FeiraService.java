package com.trabalho.feiratipo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trabalho.feiratipo.domain.Feira;
import com.trabalho.feiratipo.domain.TipoFeira;
import com.trabalho.feiratipo.dto.FeiraRequest;
import com.trabalho.feiratipo.exception.RegraNegocioException;
import com.trabalho.feiratipo.repository.FeiraRepository;

@Service
public class FeiraService {

    private final FeiraRepository feiraRepository;
    private final TipoFeiraService tipoFeiraService;

    public FeiraService(FeiraRepository feiraRepository, TipoFeiraService tipoFeiraService) {
        this.feiraRepository = feiraRepository;
        this.tipoFeiraService = tipoFeiraService;
    }

    public List<Feira> listarTodos() {
        return feiraRepository.findAll();
    }

    public Feira buscarPorId(Long id) {
        return feiraRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Feira não encontrada."));
    }

    public Feira salvar(FeiraRequest request) {
        TipoFeira tipoFeira = tipoFeiraService.buscarPorId(request.getTipoFeiraId());
        if (request.isAtiva() && feiraRepository.existsByLogradouroAndBairroAndAtivaAndIdNot(
                request.getLogradouro(), request.getBairro(), true, -1L)) {
            throw new RegraNegocioException(
                "Já existe uma feira ativa no endereço: " + request.getLogradouro() + ", " + request.getBairro());
        }
        Feira feira = new Feira(null, request.getNome(), request.getLogradouro(),
                request.getBairro(), request.isAtiva(), tipoFeira);
        return feiraRepository.save(feira);
    }

    public void remover(Long id) {
        buscarPorId(id);
        feiraRepository.deleteById(id);
    }
}