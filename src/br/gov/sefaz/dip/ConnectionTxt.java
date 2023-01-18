package br.gov.sefaz.dip;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConnectionTxt implements IConnection{

	 private FileWriter writers;
	 
	@Override
	public Boolean open() throws Exception {
		if (writers==null) {
		 writers = new FileWriter("/tmp/chat.txt",true);
		 return true;
		}
		return false;
	}

	public Boolean writeTxt(String msg) throws Exception{
		if (writers!=null) {
		writers.append("\n"+new SimpleDateFormat("yyyy_MM_dd_HH:mm:ss").format(new Date()) + " : " + msg);
		writers.flush();
		return true;
		}
		return false;
	}
	
	@Override
	public Boolean close() throws Exception {
		if (writers!=null) {
		 writers.close();
		 return true;
		}
		return false;
	}

	
	 
}
