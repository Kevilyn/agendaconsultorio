package com.example.PIClinica.service;

import com.example.PIClinica.model.Paciente;
import com.example.PIClinica.repository.IDao;

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

    public List<Paciente> buscarTodosPacientes(){
        return pacienteDao.buscarTodos();
    }

    public void deletarPaciente(int id){
        pacienteDao.deletar(id);
    }

    public Paciente atualizarPaciente(Paciente paciente){
        return pacienteDao.atualizar(paciente);
    }
}
