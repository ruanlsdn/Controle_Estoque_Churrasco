package br.com.model;

import java.util.ArrayList;

public class ChurrascoBO {
	ChurrascoDAO churrascoDAO = new ChurrascoDAO();

	public boolean insertChurrasco(ChurrascoModel churrasco) {
		return churrascoDAO.insertChurrasco(churrasco);
	}
	
	public ArrayList<ChurrascoModel> getAllChurrasco (){
		return churrascoDAO.getAllChurrasco();
	}
	
	public ChurrascoModel getChurrascoById(int id) {
		return churrascoDAO.getChurrascoById(id);
	}
	
	public boolean updateChurrascoById(ChurrascoModel churrasco) {
		return churrascoDAO.updateChurrascoById(churrasco);
	}
	
	public boolean deleteChurrasco(int id) {
		return churrascoDAO.deleteChurrasco(id);
	}
}
