package br.com.mastertech.sistemaCentralEventos.repository;

import br.com.mastertech.sistemaCentralEventos.model.EventoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventoRepository extends CrudRepository<EventoModel, Integer> {

    Optional<EventoModel> findByNome(String nome);
}
