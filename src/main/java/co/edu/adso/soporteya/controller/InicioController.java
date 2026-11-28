package co.edu.adso.soporteya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.adso.soporteya.service.TicketService;
import org.springframework.ui.Model;


@Controller 
public class InicioController {

    private final TicketService tickets;

    public InicioController(TicketService tickets) {
        this.tickets = tickets;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("conteos", tickets.conteoPorEstado());
        return "index";
    }
    
}
