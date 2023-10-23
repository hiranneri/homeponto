package br.com.homeponto.service;

import br.com.homeponto.controller.form.MarcacaoForm;
import br.com.homeponto.dto.MarcacaoResponseDTO;
import br.com.homeponto.model.Marcacao;
import br.com.homeponto.model.Perfil;
import br.com.homeponto.repository.EmpresaRepository;
import br.com.homeponto.repository.MarcacaoRepository;
import br.com.homeponto.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class MarcacaoService {

    @Autowired
    private MarcacaoRepository marcacaoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    public MarcacaoResponseDTO marcarPonto(MarcacaoForm marcacaoForm){
            empresaRepository.getById(marcacaoForm.getIdEmpresa());
            Perfil perfil = perfilRepository.getByNome(marcacaoForm.getNomeUsuario()).get(0);
            ZonedDateTime horario = gerarHorario(perfil);
            Marcacao marcacao = marcacaoForm.converterParaMarcacao(horario,perfil);
            return MarcacaoResponseDTO.toMarcacaoResponseDTO(marcacaoRepository.save(marcacao));
    }

    private ZonedDateTime gerarHorario(Perfil perfil) {
        ZoneId zona = ZoneId.of(perfil.getFuso());
        return ZonedDateTime.now(zona);
    }
}
