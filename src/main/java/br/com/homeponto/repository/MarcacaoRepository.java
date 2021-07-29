package br.com.homeponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homeponto.model.Marcacao;

public interface MarcacaoRepository extends JpaRepository<Marcacao, Long> {

}
