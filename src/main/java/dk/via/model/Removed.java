package dk.via.model;

public class Removed implements LendingState{

    @Override
    public synchronized void borrow(Vinyl vinyl, Person borrower) throws IllegalStateException {
        throw new IllegalStateException("Vinyl is removed");
    }

    @Override
    public synchronized void reserve(Vinyl vinyl, Person reserver) throws IllegalStateException {
        throw new IllegalStateException("Vinyl is removed");
    }

    @Override
    public synchronized void returnVinyl(Vinyl vinyl) throws IllegalStateException {
        throw new IllegalStateException("Vinyl is removed");
    }

    @Override
    public synchronized void remove(Vinyl vinyl) throws IllegalStateException {
       throw new IllegalStateException("Vinyl is removed");
    }
}
