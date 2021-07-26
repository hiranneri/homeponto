package br.com.homeponto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homeponto.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

	List<Perfil> getByNome(String nome);

}
