package br.gov.sefaz.protecaovariavel;

import java.sql.Connection;
import java.sql.DriverManager;

import config.Config;

/**
 * Autor: Edson Belem
 * Pattern Utilizado Singleton, muito utilizado para Banco de Dados,
 * Alguns chamam de Anti-Pattern
 */

public class ConnectionDatabase {

	
	
    private   String users="";
    private   String passwords="";
	private   Connection instance;
     {
    	 users = Config.USERS;
		 passwords=Config.PASSWORDS;
		 System.out.println(users + "," + passwords);
     }
    

	
	 
	 public   boolean open() throws Exception{
		 if (instance==null) {
	       Class.forName("com.mysql.cj.jdbc.Driver");
	       instance = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancoMain", users,  passwords);
		  return true;
		 }
		  return false;
	 }
	 
	 
	 public static void main(String[] args) {
		
		 try {
			ConnectionDatabase dao = new ConnectionDatabase();
		  System.out.println(dao.open());
			
			
		 }catch(Exception ex ) {
			 System.out.println("Deu Erro:" + ex.getMessage());
		 }
		 
	}
	 
}
