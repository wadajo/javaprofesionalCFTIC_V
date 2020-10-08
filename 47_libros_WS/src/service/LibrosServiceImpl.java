package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.Libro;

@RequestScoped
@Named("libroservice")
public class LibrosServiceImpl implements LibrosService {

	@Override
	public List<Libro> devolverLibros() {
		List<Libro> todosLosLibros=new ArrayList<>();
		String sql="SELECT isbn,titulo,autor,precio,paginas,tema "
				+ "FROM libros.libros INNER JOIN libros.temas USING (idTema) "
				+ "ORDER BY titulo";
		try(Connection conn=Datos.getConnection()){			
			PreparedStatement ps = conn.prepareStatement(sql);			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Libro unLibro=new Libro(
						rs.getInt("isbn"),
						rs.getString("titulo"),
						rs.getString("autor"),
						rs.getInt("precio"),
						rs.getInt("paginas"),
						rs.getString("tema"));
				todosLosLibros.add(unLibro);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return todosLosLibros;
	}

}
