package dk.via.model;

public class Available implements LendingState {
    @Override
    public void borrow(Vinyl vinyl, Person borrower) {
        vinyl.setLendingState(new Borrowed());
        vinyl.setBorrower(borrower);
    }

    @Override
    public void reserve(Vinyl vinyl, Person reserver) {
        vinyl.setLendingState(new Reserved());
        vinyl.setReserver(reserver);
    }

    @Override
    public void returnVinyl(Vinyl vinyl) {
        throw new IllegalStateException("Vinyl is not borrowed or reserved.");
    }

    @Override
    public void remove(Vinyl vinyl) throws IllegalStateException {
        vinyl.setLendingState(new Removed());
    }

    @Override
    public String toString() {
        return "Available";
    }
}
