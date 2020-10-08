package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Libro;

public class LibroServiceImpl implements LibroService {

	@Override
	public List<Libro> mostrarTodosLosLibros() {
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
	public List<Libro> mostrarLibrosPorTema(String tema) {
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

	@Override
	public boolean realizarVenta(int idAVender, int idCliente) {
		String sql="INSERT INTO libros.ventas (idCliente,idLibro,fecha) VALUES (?,?,?)";
		try(Connection conn=Datos.getConnection()){			
			PreparedStatement ps = conn.prepareStatement(sql);			
			ps.setInt(1, idCliente);
			ps.setInt(2, idAVender);		
			ps.setTimestamp(3, java.sql.Timestamp.valueOf(LocalDateTime.now()));
			// en la cadena de conexión de la BBDD le indiqué Europe/Madrid
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {			
			e.printStackTrace();
		} 
		return false;
	}
}
