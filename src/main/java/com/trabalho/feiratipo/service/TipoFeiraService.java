package com.trabalho.feiratipo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trabalho.feiratipo.domain.TipoFeira;
import com.trabalho.feiratipo.dto.TipoFeiraRequest;
import com.trabalho.feiratipo.exception.RegraNegocioException;
import com.trabalho.feiratipo.repository.FeiraRepository;
import com.trabalho.feiratipo.repository.TipoFeiraRepository;

@Service
public class TipoFeiraService {

    private final TipoFeiraRepository tipoFeiraRepository;
    private final FeiraRepository feiraRepository;

    public TipoFeiraService(TipoFeiraRepository tipoFeiraRepository, FeiraRepository feiraRepository) {
        this.tipoFeiraRepository = tipoFeiraRepository;
        this.feiraRepository = feiraRepository;
    }

    public List<TipoFeira> listarTodos() {
        return tipoFeiraRepository.findAll();
    }

    public TipoFeira buscarPorId(Long id) {
        return tipoFeiraRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Tipo de feira não encontrado."));
    }

    public TipoFeira salvar(TipoFeiraRequest request) {
        TipoFeira tipoFeira = new TipoFeira(null, request.getNome(), request.getDescricao());
        return tipoFeiraRepository.save(tipoFeira);
    }

    public void remover(Long id) {
        buscarPorId(id);
        if (feiraRepository.existsByTipoFeiraId(id)) {
            throw new RegraNegocioException("Não é possível remover um tipo de feira que está em uso.");
        }
        tipoFeiraRepository.deleteById(id);
    }
}