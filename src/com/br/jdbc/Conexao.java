/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author rogerio
 */
public class Conexao {
    
    public Connection getConnection(){
        
        try{
            
           return DriverManager.getConnection("jdbc:mysql://localhost/name_for_database", "user", "password");
           
           
        }catch(SQLException erro){
           
           throw new RuntimeException(erro);
           
       }
        
    }
    
}
