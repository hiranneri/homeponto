package br.com.homeponto.dto;

import br.com.homeponto.model.Marcacao;

public class MarcacaoResponseDTO {

    private String nomeUsuario;
    private String horario;

    public MarcacaoResponseDTO(String nomeUsuario, String horario) {
        this.nomeUsuario = nomeUsuario;
        this.horario = horario;
    }

    public static MarcacaoResponseDTO toMarcacaoResponseDTO(Marcacao marcacao){
        return new MarcacaoResponseDTO(marcacao.getUsuario().getNome(), marcacao.getHorario().toString());
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
