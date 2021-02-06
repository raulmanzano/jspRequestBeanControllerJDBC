package it.pkg.jspjdbc.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.pkg.jspjdbc.model.Primaria;

public class BusinessDelegate {
	private static final Logger logger = LoggerFactory.getLogger(BusinessDelegate.class);

	private static BusinessDelegate single_instance = null;

	public static BusinessDelegate getInstance() {
		if (single_instance == null)
			single_instance = new BusinessDelegate();
		return single_instance;
	}

	// privado para que no se pueda instanciar
	private BusinessDelegate() {
		try {
			// Loading The Driver Class
			Class.forName(DRIVER);
			// Getting the connection
			this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/databasename";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "westerlon";
	private static Connection connection = null;
	
	
	public List<Primaria> getAllPrimaria() {
		String sql = "SELECT * FROM primaria";
		List<Primaria> primarias = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				if (primarias == null)
					primarias = new ArrayList<>();
				Primaria primaria = new Primaria();
				primaria.setId(resultSet.getInt(1));
				primaria.setCampo1(resultSet.getString(2));
				primaria.setCampo2(resultSet.getString(3));
				primaria.setCampo3(resultSet.getString(4));
				primarias.add(primaria);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return primarias;
	}

	public void insertarPrimaria(Primaria parametro) {
		String sql = "INSERT INTO primaria (campo1,campo2,campo3) VALUES(?,?,?)";

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, parametro.getCampo1());
			pstmt.setString(2, parametro.getCampo2());
			pstmt.setString(3, parametro.getCampo3());
			if (pstmt.executeUpdate() > 0) {
				// ResultSet rs = pstmt.getGeneratedKeys();
				// if (rs.next())
				// id = rs.getInteger(1);
				//
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		// return id;
	}

	public Primaria getById(Integer parameter) {
		String sql = "SELECT * FROM primaria where id = ?";
		Primaria primaria = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, parameter);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				primaria = new Primaria();
				primaria.setId(resultSet.getInt(1));
				primaria.setCampo1(resultSet.getString(2));
				primaria.setCampo2(resultSet.getString(3));
				primaria.setCampo3(resultSet.getString(4));
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return primaria;
	}

	public void delete(Integer parameter) {
		String sql = "DELETE FROM primaria WHERE id=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, parameter);
			pstmt.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

	public void updatePrimaria(Primaria primaria) {
		String sql = "UPDATE primaria SET campo1=?, campo2=?, campo3=? WHERE id=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, primaria.getCampo1());
			pstmt.setString(2, primaria.getCampo2());
			pstmt.setString(3, primaria.getCampo3());
			pstmt.setInt(4, primaria.getId());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
