package com.example.aluno.googlemap.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.aluno.googlemap.classes.PontosDeParada;

import java.util.ArrayList;
import java.util.List;

public class Pontos_ViewModel extends AndroidViewModel {

    private List<PontosDeParada> pontosDeParadaList;
    private Pontos_Repository pontosRepository;

    public Pontos_ViewModel(@NonNull Application application) {
        super(application);
        pontosRepository = new Pontos_Repository(application);
        pontosDeParadaList = new ArrayList<>();
    }

    public Pontos_ViewModel(@NonNull Application application, byte turno) {
        super(application);
        pontosRepository = new Pontos_Repository(application);
        pontosDeParadaList = getPdPByTurn(turno);
    }

    public Pontos_ViewModel(@NonNull Application application, String placa) {
        super(application);
        pontosRepository = new Pontos_Repository(application);
        pontosDeParadaList = getPdPByPlaca(placa);
    }

    public Pontos_ViewModel(@NonNull Application application, byte turno, String placa) {
        super(application);
        pontosRepository = new Pontos_Repository(application);
        pontosDeParadaList = getPdPByTurnPlaca(turno, placa);
    }

    public List<PontosDeParada> getAllPoints() {
        pontosDeParadaList = pontosRepository.getAllPdP();
        return pontosDeParadaList;
    }

    public List<PontosDeParada> getPdPByTurn(byte turno) {
        return pontosRepository.getPdPByTurn(turno);
    }

    public List<PontosDeParada> getPdPByPlaca(String placa) {
        return pontosRepository.getPdPByPlaca(placa);
    }

    public List<PontosDeParada> getPdPByTurnPlaca(byte turno, String placa) {
        return pontosRepository.getPdPByTurnPlaca(turno, placa);
    }

    public void insertPdP(PontosDeParada... pontosDeParada) {
        for (PontosDeParada p : pontosDeParada) {
            pontosRepository.insertPonto(pontosDeParada);
        }
    }

}