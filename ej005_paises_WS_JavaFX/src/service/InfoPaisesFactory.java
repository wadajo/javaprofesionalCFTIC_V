package service;

public class InfoPaisesFactory {
	public static InfoPaisesService getInfoPaisesService() {
		return new InfoPaisesServiceImpl();
	}
}
