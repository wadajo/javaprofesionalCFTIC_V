package dao;

public class CajeroDaoFactory {
	
	public static CajeroDAO getCajeroDao() {
		return new CajeroDaoImplJdbc();
	}
}
