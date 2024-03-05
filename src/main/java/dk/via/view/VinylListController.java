package dk.via.view;

import dk.via.model.Vinyl;
import dk.via.viewmodel.VinylListViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import org.w3c.dom.Text;

public class VinylListController {
    private ViewHandler viewHandler;
    private VinylListViewModel viewModel;
    @FXML
    private ListView<Vinyl> vinylList;
    @FXML
    private TextArea logArea;
    private Region root;
    public void init(ViewHandler viewHandler, VinylListViewModel vinylListViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = vinylListViewModel;
        this.root = root;
        this.vinylList.setItems(viewModel.getVinylsList());
        this.viewModel.bindLogArea(this.logArea.textProperty());
    }
    public Region getRoot() {
        return root;
    }
    @FXML
    public void onMouseClicked() {
        Object selected = this.vinylList.getSelectionModel().getSelectedItem();
        if (!(selected instanceof Vinyl)){
            throw new IllegalStateException("The selected item is not a vinyl");
        }
       this.viewModel.setSelectedVinyl((Vinyl) this.vinylList.getSelectionModel().getSelectedItem());
    }
    @FXML
    public void onChangeClicked() {
        this.viewHandler.openView(ViewFactory.CHANGE_STATE);
    }
}
