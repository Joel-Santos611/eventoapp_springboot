package com.eventoapp.eventoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventoapp.eventoapp.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    
}
