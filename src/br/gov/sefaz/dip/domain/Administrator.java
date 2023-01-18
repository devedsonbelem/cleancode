package br.gov.sefaz.dip.domain;

public class Administrator extends Users {

	private static final long serialVersionUID = 1L;

    
 
	public Administrator() {
		 
	}
	 
	
	
    @Override
	public String toString() {
		return "Administrator [toString()=" + super.toString() + "]";
	}



	public Integer getAcesso() {
    	 acesso =0;
    	return this.acesso;
    }
	
 

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public Boolean accessUsers() throws Exception {
		if ( isEmail(getEmail()) &&  isPassword(getPassword()) &&  getAcesso().equals(0)) {
			if (getEmail().equals("administrador@gmail.com")) {
			     setPerfil(5);
			}
		}
		return false;
	}

	
	
}
