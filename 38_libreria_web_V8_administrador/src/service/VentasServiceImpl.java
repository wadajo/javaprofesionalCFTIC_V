package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Libro;
import model.Venta;

public class VentasServiceImpl implements VentasService {

	@Override
	public List<Venta> devolverVentas() {
		List<Venta> ventas=new ArrayList<>();
		String sql="SELECT * FROM libros.ventas INNER JOIN libros.clientes USING (idCliente) "
				+ "INNER JOIN libros.libros " + 
				"ON libros.libros.isbn=libros.ventas.idLibro "
				+ "INNER JOIN libros.temas USING (idTema) " +
				"ORDER BY fecha DESC";
	try(Connection conn=Datos.getConnection()){			
		PreparedStatement ps = conn.prepareStatement(sql);			
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
				Libro vendido=new Libro(rs.getInt("isbn"),
						rs.getString("titulo"),
						rs.getString("autor"),
						rs.getInt("precio"),
						rs.getInt("paginas"),
						rs.getString("tema"));
				Cliente comprador=new Cliente(
						rs.getString("usuario"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getInt("telefono"));
				Venta realizada=new Venta(comprador, 
						rs.getTimestamp("fecha"), 
						vendido);
				ventas.add(realizada);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ventas;
	}

}
