package dk.via;

import dk.via.model.ModelManager;
import dk.via.model.Vinyl;
import dk.via.model.VinylList;
import dk.via.view.ViewHandler;
import dk.via.viewmodel.ViewModelFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        ModelManager model = new ModelManager();
        Vinyl v1 = new Vinyl("The Dark Side of the Moon", "Pink Floyd", "1973");
        Vinyl v2 = new Vinyl("The Wall", "Pink Floyd", "1979");
        model.getVinylList().addVinyl(v1);
        model.getVinylList().addVinyl(v2);
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(primaryStage);
        Thread t1 = new Thread(new ReserveVinyls(model));
        t1.start();
    }

    public static void main(String[] args) {
        launch();
    }
}