package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;

import exceptions.SinLibrosException;
import model.Cliente;
import model.Libro;

public class VentasServiceImpl implements VentasService {
	@Inject
	ClienteService serviceCliente;
	@Override
	public boolean realizarVenta(List<Libro> aVender, Cliente comprador) throws SinLibrosException {
		if (comprador==null||aVender.isEmpty()||aVender==null) {
			throw new SinLibrosException();
		}
		String sql="INSERT INTO libros.ventas (idCliente,idLibro,fecha) VALUES (?,?,?)";
		try(Connection conn=Datos.getConnection()){			
			PreparedStatement ps = conn.prepareStatement(sql);			
			ps.setInt(1,serviceCliente.devolverIdCliente(comprador));
			for (Libro unLibroAVender : aVender ) {			
				ps.setInt(2, unLibroAVender.getIsbn());		
				ps.setTimestamp(3, java.sql.Timestamp.valueOf(LocalDateTime.now()));			
				ps.executeUpdate();
			}
			return true;
		} catch (SQLException e) {			
			e.printStackTrace();
		} 
		return false;
	}

}
