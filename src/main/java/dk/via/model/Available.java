package dk.via.model;

public class Available implements LendingState {
    @Override
    public synchronized void borrow(Vinyl vinyl, Person borrower) {
        vinyl.setBorrower(borrower);
        vinyl.setLendingState(new Borrowed());
    }

    @Override
    public synchronized void reserve(Vinyl vinyl, Person reserver) {
        vinyl.setReserver(reserver);
        vinyl.setLendingState(new Reserved());
    }

    @Override
    public synchronized void returnVinyl(Vinyl vinyl) {
        throw new IllegalStateException("Vinyl is not borrowed or reserved.");
    }

    @Override
    public synchronized void remove(Vinyl vinyl) throws IllegalStateException {
        vinyl.setLendingState(new Removed());
    }

    @Override
    public String toString() {
        return "Available";
    }
}
