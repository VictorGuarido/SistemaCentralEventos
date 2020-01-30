package br.com.mastertech.sistemaCentralEventos.controller;

import br.com.mastertech.sistemaCentralEventos.model.EventoModel;
import br.com.mastertech.sistemaCentralEventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {

    @Autowired
    private EventoService service;

    @GetMapping
    public String mostrarHome(){
        return "index";
    }

    @GetMapping("/voltar")
    public String voltarHome(){
        return "index";
    }

    @GetMapping("/form")
    public String mostrarForm(){
        return "form";
    }

    @PostMapping("/cadastrar")
    public String cadastrarEvento(EventoModel evento){
        service.cadastrarEvento(evento);
        return "form";
    }

    @GetMapping("/listar")
    public ModelAndView listarEventos(EventoModel evento, Model model){
        ModelAndView pagina = new ModelAndView("listarTodosEventos");
        Iterable<EventoModel> eventos = service.listarTodosEventos();
        pagina.addObject("eventos", eventos);
        return pagina;
    }

    @GetMapping("/buscar")
    public String mostrarBusca(){
        return  "buscarEvento";
    }

    @GetMapping("/evento")
    public String listarEvento(@RequestParam("nome") String nome, Model model){
        EventoModel evento = service.ListarEventoNome(nome);

        if(evento != null) {
            model.addAttribute("evento", evento);
            return "listarEvento";
        }
        else {
            model.addAttribute("msg", "O evento " + nome + " não foi encontrado!! procure novamente");
            return "buscarEvento";
        }
    }

    @GetMapping("/evento/{nome}")
    public String listarEventoPorNome(@PathVariable("nome") String nome, Model model){
        EventoModel evento = service.ListarEventoNome(nome);

        if(evento != null) {
            model.addAttribute("evento", evento);
            return "listarEvento";
        }
        else {
            model.addAttribute("msg", "O evento " + nome + " não foi encontrado!! procure novamente");
            return "buscarEvento";
        }
    }

}
