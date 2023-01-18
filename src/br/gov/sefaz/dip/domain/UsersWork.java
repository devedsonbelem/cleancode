package br.gov.sefaz.dip.domain;

public class UsersWork  extends Users{

 
	
	
	
	private static final long serialVersionUID = 1L;

	
	
	@Override
	public String toString() {
		return "UsersWork [ =" + super.toString() + "]";
	}



	@Override
	public Boolean accessUsers() throws Exception {
		if ( isEmail(getEmail()) &&  isPassword(getPassword()) &&   getAcesso().equals(1)
			&& (getPerfil()>=1 && getPerfil()<=4)) {
		 
			return true;
		}
		return false;
	}

}
