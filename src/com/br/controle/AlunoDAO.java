/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.controle;

import com.br.jdbc.Conexao;
import com.br.modelo.Alunos;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rogerio
 */
public class AlunoDAO {
    
     public Connection conn;
     
     
     
     public AlunoDAO(){
         
         this.conn = new Conexao().getConnection();
     }
     
     
     public void cadastrar(Alunos aluno){
         
         try {
             
             String sql = "INSERT INTO aluno(matricula,nome) VALUES (?,?)";
             
             PreparedStatement stmt = conn.prepareStatement(sql);
             
             stmt.setString(1, aluno.getMatricula());
             stmt.setString(2, aluno.getNome());
             
             stmt.execute();
             stmt.close();
             
             JOptionPane.showMessageDialog(null, "Cadastro realizado!");
             
         } catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao Cadastrar! " + e);
         }
         
         
         
         
     }
     
     
     public void alterar(Alunos aluno){
         
         try {
             
             String sql = "UPDATE aluno set matricula=?, nome=? WHERE id=?";
             
             PreparedStatement stmt = conn.prepareStatement(sql);
             
             
             stmt.setString(1, aluno.getMatricula());
             stmt.setString(2, aluno.getNome());
             stmt.setInt(3, aluno.getId());
             
             
             stmt.execute();
             stmt.close();
             
             JOptionPane.showMessageDialog(null, "Alteração concluída");
             
             
         } catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro na alteração! " + e);
         }
         
         
     }
     
     
     
     public void deletar(Alunos aluno){
         
         
         try {
             
             String sql = "DELETE FROM aluno WHERE id=?";
             
             PreparedStatement stmt = conn.prepareStatement(sql);
             
             stmt.setInt(1, aluno.getId());
             
             stmt.execute();
             stmt.close();
             
             JOptionPane.showMessageDialog(null, "Aluno Excluído!");
             
         } catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro ao excluír aluno! " + e);
         }
     }
     
     
     
     
     
     
     
     
     
     
     
     public List<Alunos> listarAlunos(){
         
         try{
             
             List<Alunos> lista = new ArrayList<>();
         
         String sql = "SELECT * FROM aluno";
         
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();
         
         while(rs.next()){
             
             Alunos aluno = new Alunos();
             
             aluno.setId(rs.getInt("id"));
             aluno.setMatricula(rs.getString("matricula"));
             aluno.setNome(rs.getString("nome"));
             
             lista.add(aluno);
         }
         
         return lista;
         
         }catch(SQLException e){
             
             JOptionPane.showMessageDialog(null,"Erro na consulta! " + e);
             return null ;
         }
         
         
     }
    
}
