package dk.via.model;

import dk.via.view.ViewState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager {
    private VinylList vinylList;
    private ViewState viewState;
    private PropertyChangeSupport support;
    public final static Person UI_ACTOR = new Person("Literally you");

    public ModelManager() {
        vinylList = new VinylList();
        viewState = new ViewState();
        support = new PropertyChangeSupport(this);
    }

    public VinylList getVinylList() {
        return vinylList;
    }

    public ViewState getViewState() {
        return viewState;
    }

    public void reserveVinyl(int index, Person person) {
        try {
            Vinyl vinyl = vinylList.getVinyls().get(index);
            vinyl.getLendingState().reserve(vinyl, person);
            support.firePropertyChange("ReserveVinyl", null, vinyl);
        } catch (IllegalStateException e) {
            support.firePropertyChange("ErrorReserveVinyl", null, e);
        }
    }

    public void borrowVinyl(int index, Person person) {
        try {
            Vinyl vinyl = vinylList.getVinyls().get(index);
            vinyl.getLendingState().borrow(vinyl, person);
            support.firePropertyChange("BorrowVinyl", null, vinyl);
        } catch (IllegalStateException e) {
            support.firePropertyChange("ErrorBorrowVinyl", null, e);
        }
    }

    public void returnVinyl(int index) {
        try {
            Vinyl vinyl = vinylList.getVinyls().get(index);
            vinyl.getLendingState().returnVinyl(vinyl);
            support.firePropertyChange("ReturnVinyl", null, vinyl);
        } catch (IllegalStateException e) {
            support.firePropertyChange("ErrorReturnVinyl", null, e);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
