package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Cliente;
import model.Libro;

public class ClienteServiceImpl implements ClienteService {

	@Override
	public Cliente autenticarCliente(String user, String pwd) {
		String sql="SELECT * FROM libros.clientes WHERE usuario=? AND password=?";
		String email="";
		int telefono=0;
		try(Connection conn=Datos.getConnection()){			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				email=rs.getString("email");
				telefono=rs.getInt("telefono");
				return new Cliente(user,pwd,email,telefono);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Cliente altaCliente(String user, String pwd, String email, int telefono) {
		String sql="INSERT INTO libros.clientes(usuario,password,email,telefono) VALUES (?,?,?,?)";
		try(Connection conn=Datos.getConnection()){			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pwd);
			ps.setString(3, email);
			ps.setInt(4, telefono);
			ps.executeUpdate();
			return new Cliente(user,pwd,email,telefono);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public Integer devolverIdCliente(Cliente deseado) {
		String sql="SELECT idCliente FROM libros.clientes WHERE usuario=?";
		try(Connection conn=Datos.getConnection()){			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, deseado.getUsuario());			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {				
				return rs.getInt("idCliente");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
