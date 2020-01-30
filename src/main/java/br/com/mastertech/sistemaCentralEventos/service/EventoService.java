package br.com.mastertech.sistemaCentralEventos.service;

import br.com.mastertech.sistemaCentralEventos.model.EventoModel;
import br.com.mastertech.sistemaCentralEventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    public EventoModel cadastrarEvento(EventoModel evento){
        return repository.save(evento);
    }

    public Iterable<EventoModel> listarTodosEventos(){
        Iterable<EventoModel> evento = repository.findAll();
        return evento;
    }

    public EventoModel listarEventoId(int id){
        Optional<EventoModel> evento = repository.findById(id);
        return evento.get();
    }

    public EventoModel ListarEventoNome(String nome){
        Optional<EventoModel> evento = repository.findByNome(nome);
        if(evento.isPresent()){
            return evento.get();
        }
        return null;
    }

}
