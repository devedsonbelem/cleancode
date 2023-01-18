package br.gov.sefaz.dip.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  abstract  class Users implements Serializable, Comparable<Users>{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private String password;
	protected Integer acesso;
	private Integer perfil;
	
	public Users() {
	 
	}
  
	 
	public Users(Long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}


	@Override
	public boolean equals(Object obj) {
	    if (obj==null) {
	    	return false;
	    }
	    if (obj instanceof Users) {
	         Users pessoa =(Users) obj;
    		return  this.id.equals(pessoa.getId());
	    }
	   return false;
	}


	  

	@Override
	public String toString() {
		return "Users [id=" + getId() + ", name=" + getName() + 
				", email=" + getEmail() + ", password=" + getPassword() +
				", acesso=" + getAcesso() + ", perfil=" + getPerfil() + "]";
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Users obj) {
		return this.id.compareTo(obj.getId());
	}
	
	public Boolean isEmail(String email) {
		 Pattern p = Pattern.compile("([A-Za-z0-9_-]+)@\\.([A-Za-z0-9_-]+)\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]+)");
		 Matcher m = p.matcher(email);
		 return m.matches();
	}
	
	public Boolean isPassword(String password) {
		Pattern p = Pattern.compile("[A-Za-z0-9_-@!\\.]+){6,6}");
		 Matcher m = p.matcher(password);
		 return m.matches();
	}
	
	public abstract Boolean accessUsers() throws Exception;

	
	 public void gerarCriptografia() throws Exception {
		 String chave = "profedsonbelem@gmail.com=1=1;www.sefaz.com.br/projeto;*123+;";
		 MessageDigest md5 = MessageDigest.getInstance("MD5");
		 this.setPassword(this.getPassword() + chave);  

		 // converteu em bytes
		 byte[] messageDigest = md5.digest(this.getPassword().getBytes());
		  
		  // biginteger
		 BigInteger no = new BigInteger(1, messageDigest);
		 String hashText = no.toString(16);
		  // converte em texto
		  while (hashText.length() < 32) {
		  hashText = "0" + hashText;
		  }
		  this.setPassword(hashText); 
	 }
	

	public Integer getAcesso() {
		  acesso = 1;
		 return 1;
	}


	public Integer getPerfil() {
		return perfil;
	}


	public void setPerfil(Integer perfil) {
		if (this.acesso.equals(0)) {
			throw new IllegalArgumentException("Somente esse Acesso quem possuie é o Admnistrador");
		}
		if (this.perfil>=1 && this.perfil<=4) {
		this.perfil = perfil;
		}
	}


	
}
