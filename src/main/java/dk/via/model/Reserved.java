package dk.via.model;

public class Reserved implements LendingState{
    @Override
    public synchronized void borrow(Vinyl vinyl, Person borrower) {
        if (vinyl.getReserver() == borrower) {
            vinyl.setLendingState(new Borrowed());
            vinyl.setReserver(null);
        } else {
            throw new IllegalStateException("Vinyl is reserved by someone else");
        }
    }

    @Override
    public synchronized void reserve(Vinyl vinyl, Person reserver) {
        throw new IllegalStateException("Vinyl is already reserved");
    }

    @Override
    public synchronized void returnVinyl(Vinyl vinyl) {
        throw new IllegalStateException("Vinyl is not borrowed");
    }

    @Override
    public synchronized void remove(Vinyl vinyl) throws IllegalStateException {
        vinyl.setShouldDeleteWhenAvaliable(true);
    }

    @Override
    public String toString() {
        return "Reserved";
    }
}
