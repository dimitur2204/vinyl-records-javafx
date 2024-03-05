package dk.via.view;

import dk.via.viewmodel.ViewModelFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler {
    private Scene currentScene;
    private Stage primaryStage;
    private ViewFactory viewFactory;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.currentScene = new Scene(new Region());
        this.viewFactory = new ViewFactory(this, viewModelFactory);
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        openView(ViewFactory.VINYL_LIST);
    }

    public void openView(String id) {
        Region root = viewFactory.loadView(id);
        currentScene.setRoot(root);
        if (root.getUserData() == null) {
            primaryStage.setTitle("");
        } else {
            primaryStage.setTitle(root.getUserData().toString());
        }
        primaryStage.setScene(currentScene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public void closeView() {
        primaryStage.close();
    }
}
