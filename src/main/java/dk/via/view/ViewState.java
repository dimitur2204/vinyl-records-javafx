package dk.via.view;

import dk.via.model.Vinyl;

public class ViewState {
    private Vinyl selectedVinyl;
    public ViewState() {
        selectedVinyl = null;
    }
    public Vinyl getSelectedVinyl() {
        return selectedVinyl;
    }
    public void setSelectedVinyl(Vinyl selectedVinyl) {
        this.selectedVinyl = selectedVinyl;
    }
}
