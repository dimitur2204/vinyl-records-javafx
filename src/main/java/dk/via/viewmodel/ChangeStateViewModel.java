package dk.via.viewmodel;

import dk.via.model.ModelManager;
import dk.via.model.Person;
import dk.via.model.Vinyl;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChangeStateViewModel implements PropertyChangeListener {
    private final ModelManager model;
    private final SimpleBooleanProperty isDisabledBorrow;
    private final SimpleBooleanProperty isDisabledReserve;
    private final SimpleBooleanProperty isDisabledReturn;
    private final SimpleBooleanProperty isDisabledRemove;
    public ChangeStateViewModel(ModelManager model) {
        this.model = model;
        this.model.addPropertyChangeListener(this);
        this.isDisabledBorrow = new SimpleBooleanProperty(false);
        this.isDisabledReserve = new SimpleBooleanProperty(false);
        this.isDisabledRemove = new SimpleBooleanProperty(false);
        this.isDisabledReturn = new SimpleBooleanProperty(false);
    }

    public Vinyl getSelectedVinyl() {
        return model.getViewState().getSelectedVinyl();
    }

    public void bindDisabledBorrow(BooleanProperty property) {
        this.isDisabledBorrow.bindBidirectional(property);
    }

    public void bindDisabledReserve(BooleanProperty booleanProperty) {
        this.isDisabledReserve.bindBidirectional(booleanProperty);
    }

    public void bindDisabledReturn(BooleanProperty booleanProperty) {
        this.isDisabledReturn.bindBidirectional(booleanProperty);
    }

    public void bindDisabledDelete(BooleanProperty booleanProperty) {
        this.isDisabledRemove.bindBidirectional(booleanProperty);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            System.out.println(evt.getNewValue());
            Vinyl vinyl = evt.getNewValue() instanceof Vinyl ? (Vinyl) evt.getNewValue() : null;
            if (vinyl == null) {
                return;
            };
            if (evt.getPropertyName() == "BorrowVinyl") {
                this.isDisabledBorrow.set(true);
                if(vinyl.getBorrower().equals(ModelManager.UI_ACTOR)) {
                    this.isDisabledReturn.set(false);
                    this.isDisabledReserve.set(true);
                }
                if(vinyl.getReserver() != null) {
                    return;
                }
                this.isDisabledReserve.set(false);
            }
            if (evt.getPropertyName() == "ReserveVinyl") {
                this.isDisabledReserve.set(true);
                if(vinyl.getReserver().equals(ModelManager.UI_ACTOR)) {
                    this.isDisabledBorrow.set(false);
                }
            }
            if (evt.getPropertyName() == "ReturnVinyl") {
                this.isDisabledReturn.set(true);
                this.isDisabledBorrow.set(false);
                this.isDisabledReserve.set(false);
            }
        });
    }

    public void reserve(Vinyl selectedVinyl) {
        int index = model.getVinylList().getVinyls().indexOf(selectedVinyl);
        model.reserveVinyl(index, ModelManager.UI_ACTOR);
    }
    public void borrow(Vinyl selectedVinyl) {
        int index = model.getVinylList().getVinyls().indexOf(selectedVinyl);
        model.borrowVinyl(index, ModelManager.UI_ACTOR);
    }
    public void returnVinyl(Vinyl selectedVinyl) {
        int index = model.getVinylList().getVinyls().indexOf(selectedVinyl);
        model.returnVinyl(index);
    }

    public void deleteVinyl(Vinyl selectedVinyl) {
        model.getVinylList().removeVinyl(selectedVinyl);
    }
}
