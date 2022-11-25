package com.example.PIClinica.controller;

import com.example.PIClinica.dto.DentistaDTO;
import com.example.PIClinica.dto.PacienteDTO;
import com.example.PIClinica.model.Dentista;
import com.example.PIClinica.model.Paciente;
import com.example.PIClinica.repository.impl.DentistaDaoH2;
import com.example.PIClinica.repository.impl.PacienteDaoH2;
import com.example.PIClinica.service.DentistaService;
import com.example.PIClinica.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    private DentistaService dentistaService = new DentistaService(new DentistaDaoH2());

    @GetMapping
    public List<DentistaDTO> buscarTodos(){
        return dentistaService.buscarTodosDentistas();
    }

    @PostMapping
    public ResponseEntity<Dentista> registrarDentista(@RequestBody Dentista dentista){
        return ResponseEntity.ok(dentistaService.salvarDentista(dentista));
    }

    @PutMapping
    public ResponseEntity<Dentista> atualizarDentista(@RequestBody Dentista dentista){
        ResponseEntity<Dentista> response = null;

        if( dentista.getId() > 0 && dentistaService.buscarDentista(dentista.getId()) != null)
            response = ResponseEntity.ok(dentistaService.atualizarDentista(dentista));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentista> buscarDentista(@PathVariable int id){
        return ResponseEntity.ok(dentistaService.buscarDentista(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarDentista(@PathVariable int id){
        ResponseEntity responseEntity = null;
        if(dentistaService.deletarDentista(id))
            responseEntity = ResponseEntity.status(HttpStatus.OK).build();
        else
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return responseEntity;
    }
}
