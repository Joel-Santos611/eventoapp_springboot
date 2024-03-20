package com.eventoapp.eventoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eventoapp.eventoapp.model.Evento;
import com.eventoapp.eventoapp.repositories.EventoRepository;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class EventoController {

    @Autowired
    EventoRepository eventoRepository;
    
    @RequestMapping("/cadastrarEvento")
    public String form() {

        return "evento/formEvento";
    }

    @RequestMapping(value="cadastrarEvento", method=RequestMethod.POST)
    public String requestMethodName(Evento evento) {
        eventoRepository.save(evento);

        return "redirect:/eventos";
    }
    @RequestMapping("/eventos")
    public ModelAndView listarEventos(){
        ModelAndView modelAndView=new ModelAndView("index");

        Iterable<Evento> eventos=eventoRepository.findAll();

        modelAndView.addObject("evento",eventos);
        return modelAndView;
    }
    
}
