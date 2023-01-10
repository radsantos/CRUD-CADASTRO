/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.modelo;

/**
 *
 * @author rogerio
 */
public class Alunos {
    
    private int id;
    private String matricula;
    private String nome;
    
    public Alunos(){
        
    }

    public Alunos(int id, String matricula, String nome){
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    

    
}
