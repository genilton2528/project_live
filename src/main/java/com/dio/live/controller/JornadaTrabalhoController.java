package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaList(){
        return jornadaService.findAll();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable("idJornada") Long idJornada) throws Exception {
        return ResponseEntity.ok( jornadaService.getById(idJornada)
                .orElseThrow( () -> new Exception("Jornada não encontrada") ));
    }

    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.updateJornada(jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity<String> deleteJornada(@PathVariable("idJornada") Long idJornada) {
        try {
            jornadaService.deleteJornada(idJornada);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>( e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Excluido com sucesso!", HttpStatus.OK);
    }
}
