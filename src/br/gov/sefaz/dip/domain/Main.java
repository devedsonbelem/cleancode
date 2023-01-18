package br.gov.sefaz.dip.domain;

public class Main {

	 public static void main(String[] args) {
		try {
		 UsersWork users = new UsersWork();
		       users.setId(100L);
		       users.setName("belem");
		       users.setEmail("belem@gmail.com");
		       users.setPassword("123456");
		       users.gerarCriptografia();
		       users.setPerfil(2);
		       users.accessUsers();
		       
		       
		       System.out.println(users.toString());
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
