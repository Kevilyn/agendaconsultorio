package com.example.PIClinica.service;

import com.example.PIClinica.dto.PacienteDTO;
import com.example.PIClinica.model.Paciente;
import com.example.PIClinica.repository.DentistaRepository;
import com.example.PIClinica.repository.IDao;
import com.example.PIClinica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PacienteService {

    private IDao<Paciente> pacienteDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteDao = pacienteIDao;
    }

    public Paciente salvarPaciente(Paciente paciente){
        paciente.setDataAlta(new Date());
        return pacienteDao.salvar(paciente);
    }

    public Paciente buscarPaciente(int id){
        return pacienteDao.buscar(id);
    }

    public List<PacienteDTO> buscarTodosPacientes(){
        ObjectMapper mapper = new ObjectMapper();
        List<Paciente> pacientes = pacienteDao.buscarTodos();
        List<PacienteDTO> pacienteDTOS = new ArrayList<>();
        for(Paciente paciente:pacientes){
            PacienteDTO pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
            pacienteDTOS.add(pacienteDTO);
        }
        return pacienteDTOS;
    }

    public Boolean deletarPaciente(int id){
       return pacienteDao.deletar(id);
    }

    public Paciente atualizarPaciente(Paciente paciente){
        return pacienteDao.atualizar(paciente);
    }

    @Autowired

    private PacienteRepository pacienteRepository;
    public Paciente buscarPorNome(String nome){
        return pacienteRepository.findPacienteByNome(nome).get();
    }
}
