package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.Libro;
import service.Datos;

@RequestScoped
@Named("librosdaojdbc")
public class LibrosDAOJdbc implements LibrosDAO {

	@Override
	public List<Libro> recuperarTodosLosLibros() {
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

	@Override
	public List<Libro> recuperarLibrosPorTema(String tema) {
		List<Libro> librosPorTema=new ArrayList<>();
		String sql="SELECT isbn,titulo,autor,precio,paginas "
				+ "FROM libros.libros INNER JOIN libros.temas USING (idTema) "
				+ "WHERE tema=?";
		try(Connection conn=Datos.getConnection()){			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tema);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Libro unLibroDeEsteTema=new Libro(
						rs.getInt("isbn"),
						rs.getString("titulo"),
						rs.getString("autor"),
						rs.getInt("precio"),
						rs.getInt("paginas"),
						tema);
				librosPorTema.add(unLibroDeEsteTema);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return librosPorTema;
	}

	@Override
	public Libro recuperarLibroPorIsbn(int isbn) {		
		Libro libroDeEsteIsbn=new Libro();
		String sql="SELECT isbn,titulo,autor,precio,paginas,tema "
				+ "FROM libros.libros INNER JOIN libros.temas USING (idTema) "
				+ "WHERE isbn=?";
		try(Connection conn=Datos.getConnection()){			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, isbn);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				libroDeEsteIsbn=new Libro(
						isbn,
						rs.getString("titulo"),
						rs.getString("autor"),
						rs.getInt("precio"),
						rs.getInt("paginas"),
						rs.getString("tema"));				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libroDeEsteIsbn;
	}

}
