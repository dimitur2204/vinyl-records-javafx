package dk.via.model;

import java.util.ArrayList;

public class VinylList {
    private ArrayList<Vinyl> vinyls;

    public VinylList() {
        vinyls = new ArrayList<>();
    }
    private boolean canDelete(Vinyl vinyl) {
        if (vinyl.getLendingState() instanceof Available) {
            return true;
        }
        return false;
    }
    public void removeVinyl(Vinyl vinyl) {
        if(canDelete(vinyl)) {
            vinyls.remove(vinyl);
            return;
        }
        vinyl.setShouldDeleteWhenAvaliable(true);
    }

    public void addVinyl(Vinyl vinyl) {
        vinyls.add(vinyl);
    }

    public ArrayList<Vinyl> getVinyls() {
        return vinyls;
    }
}
