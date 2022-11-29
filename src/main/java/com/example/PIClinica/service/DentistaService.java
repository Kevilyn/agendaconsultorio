package com.example.PIClinica.service;

import com.example.PIClinica.dto.DentistaDTO;
import com.example.PIClinica.model.Dentista;
import com.example.PIClinica.repository.DentistaRepository;
import com.example.PIClinica.repository.IDao;
import com.example.PIClinica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DentistaService {

    private IDao<Dentista> dentistaDao;

    public DentistaService(IDao<Dentista> dentistaIDao) {
        this.dentistaDao = dentistaIDao;
    }

    public Dentista salvarDentista(Dentista dentista){
        return dentistaDao.salvar(dentista);
    }

    public Dentista buscarDentista(int id){
        return dentistaDao.buscar(id);
    }

    public List<DentistaDTO> buscarTodosDentistas(){
        ObjectMapper mapper = new ObjectMapper();
        List<Dentista> dentistas = dentistaDao.buscarTodos();
        List<DentistaDTO> dentistaDTOS = new ArrayList<>();
        for(Dentista dentista:dentistas){
            DentistaDTO dentistaDTO = mapper.convertValue(dentista, DentistaDTO.class);
            dentistaDTOS.add(dentistaDTO);
        }
        return dentistaDTOS;
    }

    public Boolean deletarDentista(int id){
        return dentistaDao.deletar(id);
    }

    public Dentista atualizarDentista(Dentista dentista){
        return dentistaDao.atualizar(dentista);
    }

    private DentistaRepository dentistaRepository;

    @Autowired


    private PacienteRepository pacienteRepository;
    public Dentista buscarPorNome(String nome){
        return dentistaRepository.findDentistaByNome(nome).get();
    }

}
