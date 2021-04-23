package br.com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionFactory;

public class ChurrascoDAO {

	private Connection connection;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	private ArrayList<ChurrascoModel> churrascoLista = new ArrayList<ChurrascoModel>();

	public ChurrascoDAO() {
		connection = new ConnectionFactory().getConnection();
	}

	public boolean insertChurrasco(ChurrascoModel churrasco) {
		String sql = "INSERT INTO churrasco (tipoChurrasco, qtdeChurrasco, valorChurrasco) VALUES(?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, churrasco.getTipoChurrasco());
			ps.setInt(2, churrasco.getQtdeChurrasco());
			ps.setDouble(3, churrasco.getValorChurrasco());
			ps.execute();
			ps.close();
			return true;
		} catch (Exception error) {
			return false;
		}
	}

	public ArrayList<ChurrascoModel> getAllChurrasco() {
		String sql = "SELECT * FROM churrasco";
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				churrascoLista.add(new ChurrascoModel(rs.getString("tipoChurrasco"), rs.getDouble("valorChurrasco"), rs.getInt("qtdeChurrasco"), rs.getInt("id_churrasco")));
			}
		} catch (Exception error) {
			System.out.println("Erro na listagem!" + error);
		}
		return churrascoLista;
	}

	public ChurrascoModel getChurrascoById(int id) {
		ChurrascoModel churrasco = null;
		String sql = "SELECT * FROM churrasco WHERE id_churrasco = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String tipoChurrasco = rs.getString("tipoChurrasco");
				int qtdeChurrasco = rs.getInt("qtdeChurrasco") ;
				double valorChurrasco = rs.getDouble("valorChurrasco");
				int id_churrasco = rs.getInt("id_churrasco");
				churrasco = new ChurrascoModel (tipoChurrasco, valorChurrasco, qtdeChurrasco, id_churrasco);
			}
		} catch (Exception error) {
			System.out.println("Erro na listagem!" + error);
		}
		return churrasco;
	}
	
	public boolean updateChurrascoById(ChurrascoModel churrasco) {
		String sql = "UPDATE churrasco SET tipoChurrasco = ?, qtdeChurrasco = ?, valorChurrasco = ? WHERE id_churrasco = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, churrasco.getTipoChurrasco());
			ps.setInt(2, churrasco.getQtdeChurrasco());
			ps.setDouble(3, churrasco.getValorChurrasco());
			ps.setInt(4, churrasco.getId_churrasco());
			ps.execute();
			ps.close();
			return true;
		} catch (Exception error) {
			return false;
		}
	}
	
	public boolean deleteChurrasco(int id) {
		String sql = "DELETE FROM churrasco WHERE id_churrasco = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch(Exception error) {
			return false;
		}
		return true;
	}
}
