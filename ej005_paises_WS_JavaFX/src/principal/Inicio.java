package principal;

import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.*;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import model.Pais;
import service.InfoPaisesFactory;
import service.InfoPaisesService;
import service.InfoPaisesServiceImpl;

@SuppressWarnings("restriction")
public class Inicio extends Application{
	InfoPaisesService service=InfoPaisesFactory.getInfoPaisesService();	
	
	ObservableList<String> listaTotal=FXCollections.observableList(generarNombresPaises());
	
	@Override
	public void start(Stage platoInicial) throws Exception {				
		platoInicial.setTitle("Enciclopedia de Países - JavaFX");				
		
		Label instruccion=new Label("Selecciona un país");
		instruccion.setFont(Font.font("sans-serif", 20));
		
		Label seleccionado=new Label("Ningún país seleccionado...");
		seleccionado.setFont(Font.font("sans-serif", 20));
		
		ComboBox<String> selectorPaises = new ComboBox<String>(listaTotal);
		selectorPaises.setVisibleRowCount(15);
		selectorPaises.setOnAction(elegido->seleccionado.setText("Elegiste "+selectorPaises.getValue()));
		
		Button elegir=new Button ("Ver detalles");		
		elegir.setOnAction(click->verInfoPais(selectorPaises.getValue()));
		
		TilePane lienzoInicial = new TilePane();		
		lienzoInicial.getChildren().add(0,instruccion);
		lienzoInicial.getChildren().add(1,selectorPaises);		
		lienzoInicial.getChildren().add(2,elegir);
		Scene escenaInicial = new Scene(lienzoInicial,400,500);
		platoInicial.setScene(escenaInicial);		
		platoInicial.show();
	}
	
	private void verInfoPais(String nombrePaisElegido) {
		Pais elegido=service.devolverPais(nombrePaisElegido);
		
		Stage platoDetalles=new Stage();
		platoDetalles.setTitle("Detalles de "+nombrePaisElegido+" - JavaFX");
		
		Label nombre=new Label("Nombre: "+nombrePaisElegido);
		nombre.setFont(Font.font("sans-serif", 20));
		Label poblacion=new Label("Población: "+elegido.getHabitantes()+" habitantes");
		poblacion.setFont(Font.font("sans-serif", 20));
		Label capital=new Label("Ciudad capital: "+elegido.getCapital());
		capital.setFont(Font.font("sans-serif", 20));
		Label region=new Label("Región: "+elegido.getRegion());
		region.setFont(Font.font("sans-serif", 20));
		Label bandera=new Label("Bandera: ");
		bandera.setFont(Font.font("sans-serif", 20));
		Image banderaImg = new Image(elegido.getBandera(), 100, 200, true, false);
		ImageView banderaView=new ImageView(banderaImg);		
		
		Button cerrar=new Button("Cerrar");
		cerrar.setOnAction(click->platoDetalles.close());
		
		TilePane lienzoDetalles = new TilePane();
		lienzoDetalles.getChildren().add(0, nombre);
		lienzoDetalles.getChildren().add(1, poblacion);
		lienzoDetalles.getChildren().add(2, capital);
		lienzoDetalles.getChildren().add(3, region);
		lienzoDetalles.getChildren().add(4, banderaView);
		lienzoDetalles.getChildren().add(5, cerrar);
		Scene escenaDetalles = new Scene(lienzoDetalles,300,300);
		platoDetalles.setScene(escenaDetalles);		
		platoDetalles.show();
	}

	private List<String> generarNombresPaises() {
		return service.recuperarPaises().keySet().stream()
				.sorted()
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
