package com.example.PIClinica.controller;

import com.example.PIClinica.dto.PacienteDTO;
import com.example.PIClinica.model.Paciente;
import com.example.PIClinica.repository.impl.PacienteDaoH2;
import com.example.PIClinica.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")

public class PacienteController {

    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @GetMapping
    public List<PacienteDTO> buscarTodos(){
        return pacienteService.buscarTodosPacientes();
    }

    @PostMapping
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.salvarPaciente(paciente));
    }

    @PutMapping
    public ResponseEntity<Paciente> atualizarPaciente(@RequestBody Paciente paciente){
        ResponseEntity<Paciente> response = null;

        if( paciente.getId() > 0 && pacienteService.buscarPaciente(paciente.getId()) != null)
            response = ResponseEntity.ok(pacienteService.atualizarPaciente(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable int id){
        return ResponseEntity.ok(pacienteService.buscarPaciente(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPaciente(@PathVariable int id){
        ResponseEntity responseEntity = null;
        if(pacienteService.deletarPaciente(id))
            responseEntity = ResponseEntity.status(HttpStatus.OK).build();
        else
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return responseEntity;
    }

}
