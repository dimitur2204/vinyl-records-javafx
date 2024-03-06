package dk.via.view;

import dk.via.model.Borrowed;
import dk.via.model.ModelManager;
import dk.via.model.Reserved;
import dk.via.viewmodel.ChangeStateViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class ChangeStateController {
    @FXML
    private Button deleteButton;
    private ViewHandler viewHandler;
    private ChangeStateViewModel viewModel;
    private Region root;
    @FXML
    private Label titleLabel;
    @FXML
    private Label yearLabel;
    @FXML
    private Button reserveButton;
    @FXML
    private Button borrowButton;
    @FXML
    private Button returnButton;
    public void init(ViewHandler viewHandler, ChangeStateViewModel changeStateViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = changeStateViewModel;
        this.root = root;
        this.titleLabel.setText(viewModel.getSelectedVinyl().getTitle());
        this.yearLabel.setText(viewModel.getSelectedVinyl().getReleaseYear());
        this.viewModel.bindDisabledBorrow(borrowButton.disableProperty());
        this.viewModel.bindDisabledReserve(reserveButton.disableProperty());
        this.viewModel.bindDisabledDelete(deleteButton.disableProperty());
        this.viewModel.bindDisabledReturn(returnButton.disableProperty());
    }
    public Region getRoot() {
        return root;
    }
    @FXML
    public void onReserveClicked() {
        this.viewModel.reserve(viewModel.getSelectedVinyl());
    }

    @FXML
    public void onBorrowClicked() {
        this.viewModel.borrow(viewModel.getSelectedVinyl());
    }

    @FXML
    public void onReturnClicked() {
        this.viewModel.returnVinyl(viewModel.getSelectedVinyl());
    }
    @FXML
    public void onDeleteClicked(ActionEvent actionEvent) {
        this.viewModel.deleteVinyl(viewModel.getSelectedVinyl());
    }

    @FXML void onBackClicked() {
        this.viewHandler.openView(ViewFactory.VINYL_LIST);
    }

}
