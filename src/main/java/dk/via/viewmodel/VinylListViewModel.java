package dk.via.viewmodel;

import dk.via.model.ModelManager;
import dk.via.model.Vinyl;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VinylListViewModel implements PropertyChangeListener {
    private ModelManager model;
    private ObservableList<Vinyl> vinylsList;
    private SimpleStringProperty logArea;
    public VinylListViewModel(ModelManager model) {
        this.vinylsList = FXCollections.observableArrayList(model.getVinylList().getVinyls());
        this.logArea = new SimpleStringProperty();
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    public ObservableList<Vinyl> getVinylsList() {
        return vinylsList;
    }

    public void setSelectedVinyl(Vinyl vinyl) {
        model.getViewState().setSelectedVinyl(vinyl);
    }

    public void bindLogArea(StringProperty property) {
        this.logArea.bindBidirectional(property);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            this.vinylsList.setAll(model.getVinylList().getVinyls());
            //append to the logArea
            if(logArea.isEmpty().get()) {
                logArea.set(evt.getNewValue().toString());
                return;
            }
            this.logArea.set(logArea.get() + "\n" + evt.getNewValue());
        });
    }
}
