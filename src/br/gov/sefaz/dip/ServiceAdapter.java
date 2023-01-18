package br.gov.sefaz.dip;

public class ServiceAdapter {

	
	private IConnection connection;
	
	public ServiceAdapter(IConnection connection){
		this.connection = connection;
		
	}
	
	public void open() throws Exception {
		this.connection.open();
	}
	
	public String writeMessage(String msg) throws Exception{
		return msg;
	}
	
	public void close() throws Exception {
		this.connection.open();
	}
	
	
	public static void main(String[] args) {
		try {
		ConnectionDatabaseMysql connection  = new ConnectionDatabaseMysql();
		ServiceAdapter service =new ServiceAdapter(connection);
		
	      service.open();
	      service.close();  
				
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
