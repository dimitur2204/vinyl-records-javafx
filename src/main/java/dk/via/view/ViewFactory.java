package dk.via.view;

import dk.via.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOError;
import java.io.IOException;

public class ViewFactory {
    public static final String VINYL_LIST = "Vinyl_List";
    public static final String CHANGE_STATE = "Change_State";
    private final ViewHandler viewHandler;
    private final ViewModelFactory viewModelFactory;
    private ChangeStateController changeStateController;
    private VinylListController vinylListController;

    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.vinylListController = null;
        this.changeStateController = null;
    }

    public Region loadVinylList() {
        if (this.vinylListController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("VinylList.fxml"));
            try {
                Region root = loader.load();
                this.vinylListController = loader.getController();
                this.vinylListController.init(viewHandler, viewModelFactory.getListViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        return this.vinylListController.getRoot();
    }
    public Region loadChangeState() {
        if (this.changeStateController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ChangeState.fxml"));
            try {
                Region root = loader.load();
                this.changeStateController = loader.getController();
                this.changeStateController.init(viewHandler, viewModelFactory.getChangeStateViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        return this.changeStateController.getRoot();
    }

    public Region loadView(String id) {
        return switch (id) {
            case VINYL_LIST -> loadVinylList();
            case CHANGE_STATE -> loadChangeState();
            default -> throw new IllegalArgumentException("Unknown view: " + id);
        };
    }
}
