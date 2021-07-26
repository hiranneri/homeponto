package br.com.homeponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homeponto.model.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Long> {

}
