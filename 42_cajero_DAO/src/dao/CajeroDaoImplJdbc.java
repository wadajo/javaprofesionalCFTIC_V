package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Cuenta;
import model.Movimiento;

class CajeroDaoImplJdbc implements CajeroDAO {

	@Override
	public void insertarMovimiento(Movimiento nuevo) {
	try(Connection conn=Datos.getConnection()){
		String sql="INSERT INTO bancabd.movimientos "
				+ "(idCuenta,fecha,cantidad,operacion) VALUES (?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, nuevo.getCuenta());
		ps.setTimestamp(2, java.sql.Timestamp.valueOf(nuevo.getFecha()));
		ps.setDouble(3, nuevo.getDinero());
		ps.setString(4, nuevo.getOperacion());
		ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizarSaldoCuenta(int numeroCuenta, double saldoNuevo) {
	try(Connection conn=Datos.getConnection()){
		String sql="UPDATE bancabd.cuentas SET saldo=? WHERE numeroCuenta=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, saldoNuevo);		
		ps.setInt(2, numeroCuenta);
		ps.execute();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

	@Override
	// revisar porque solo me funciona para las que tienen más de un titular
	public Cuenta recuperarCuenta(int numeroCuenta) {
		int saldo=0;
		String tipoCuenta="";
		List<Cliente> titulares=new ArrayList<>();		
		try (Connection conn=Datos.getConnection()){
			String sql="SELECT numeroCuenta,saldo,tipocuenta,idCliente FROM bancabd.cuentas INNER JOIN bancabd.titulares \n" + 
					"ON cuentas.numeroCuenta=titulares.idCuenta WHERE idCuenta=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroCuenta);			
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				saldo=rs.getInt("saldo");
				tipoCuenta=rs.getString("tipocuenta");
				var dni=rs.getInt("idCliente");
				titulares.add(recuperarTitular(dni));
				while(rs.next()) {					
					titulares.add(recuperarTitular(dni));													
				}	
			return new Cuenta(numeroCuenta,titulares,saldo,tipoCuenta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Movimiento> recuperarMovimientos(int numeroCuenta) {
		List<Movimiento> ultimosMov = new ArrayList<>();
		try (Connection conn=Datos.getConnection()){			
			String sql="SELECT * FROM bancabd.movimientos WHERE idCuenta=? "
					+ "ORDER BY fecha DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroCuenta);			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ultimosMov.add(new Movimiento(numeroCuenta,
						LocalDateTime.parse(rs.getString("fecha"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
						rs.getInt("cantidad"),
						rs.getString("operacion")));
			}
			return ultimosMov;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<Movimiento>();
	}

	@Override
	public void insertarCliente(Cliente nuevo) {
		try (Connection conn=Datos.getConnection()){
			String sql="INSERT INTO bancabd.clientes VALUES (?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, nuevo.getDni());
			ps.setString(2, nuevo.getNombre());
			ps.setString(3, nuevo.getDireccion());
			ps.setInt(4, nuevo.getTelefono());
			ps.execute();		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public Cliente recuperarTitular(int dni) {
		Cliente t1 = null;
		try (Connection conn=Datos.getConnection()){
			String sql="SELECT nombre,direccion,telefono FROM bancabd.clientes "
					+ "WHERE dni=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, dni);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				t1 = new Cliente(
						dni,
						rs.getString("nombre"),
						rs.getString("direccion"),
						rs.getInt("telefono"));
			}
			return t1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
