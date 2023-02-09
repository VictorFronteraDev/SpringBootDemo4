package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Direccion;

@Repository
@Transactional
public interface DireccionesRepository extends JpaRepository<Direccion, Long>{

	@Query(value = "SELECT d.* FROM direcciones d, clientesdirecciones cd where d.id=cd.iddireccion and idcliente=:idcliente", nativeQuery = true)
	public List<Direccion> getDireccionesByIdCliente(@Param("idcliente") Long idCliente);
	
}
