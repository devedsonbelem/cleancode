package br.gov.sefaz.dip;

import java.sql.Connection;
import java.sql.DriverManager;

import config.Config;

public class ConnectionDatabaseMysql implements IConnection {


    private   String users="";
    private   String passwords="";
	private   Connection instance;
   
	{
    	 users = Config.USERS;
		 passwords=Config.PASSWORDS;
		 System.out.println(users + "," + passwords);
     }
    

	
	@Override
	 public   Boolean open() throws Exception{
		 if (instance==null) {
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       instance = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancoMain", users,  passwords);
			   System.out.println("Banco de Dados aberto ...");
		       return true;
			 }
			  return false;
	 }




	@Override
	public Boolean close() throws Exception {
		if (instance!=null) {
			instance.close(); 
			System.out.println("Banco de Dados aberto ...");
			
			return true;
		}
		return false;
	}
	 
	 
 

}
