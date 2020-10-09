package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("temasservice")
public class TemasServiceImpl implements TemasService {

	@Override
	public List<String> mostrarTemas() {
		List<String> temas=new ArrayList<>();
		String sql="SELECT tema FROM libros.temas ORDER BY tema ASC";
		try(Connection conn=Datos.getConnection()){			
			PreparedStatement ps = conn.prepareStatement(sql);			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				temas.add(rs.getString("tema"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temas;
	}

}
