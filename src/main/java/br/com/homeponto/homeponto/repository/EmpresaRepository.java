package br.com.homeponto.homeponto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homeponto.homeponto.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	List<Empresa> findByNomeFantasia(String nomeEmpresa);
	
}
