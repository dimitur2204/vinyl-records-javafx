package dk.via.model;
public class Vinyl {
    private String title;
    private String artist;
    private String releaseYear;
    private LendingState lendingState;
    private Person borrower;
    private Person reserver;
    private boolean shouldDelete;

    public Vinyl(String title, String artist, String releaseYear) {
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.reserver = null;
        this.borrower = null;
        this.shouldDelete = false;
        this.lendingState = new Available();
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public LendingState getLendingState() {
        return lendingState;
    }
    public synchronized void setLendingState(LendingState lendingState) {
        if(lendingState instanceof Available) {
            if(shouldDelete) {
                lendingState.remove(this);
            }
        }
        this.lendingState = lendingState;
    }

    public void setReserver(Person reserver) {
        this.reserver = reserver;
    }

    public void setBorrower(Person borrower) {
        this.borrower = borrower;
    }

    public Person getReserver() {
        return reserver;
    }

    public Person getBorrower() {
        return borrower;
    }

    public void setShouldDeleteWhenAvaliable(boolean shouldDelete) {
        this.shouldDelete = shouldDelete;
    }

   public boolean getShouldDelete() {
        return shouldDelete;
    }

    @Override
    public String toString() {
        return title + " by " + artist + " (" + releaseYear + ")" + " - " + lendingState.toString();
    }
}
