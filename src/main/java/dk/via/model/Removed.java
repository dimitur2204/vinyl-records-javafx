package dk.via.model;

public class Removed implements LendingState{

    @Override
    public void borrow(Vinyl vinyl, Person borrower) throws IllegalStateException {
        throw new IllegalStateException("Vinyl is removed");
    }

    @Override
    public void reserve(Vinyl vinyl, Person reserver) throws IllegalStateException {
        throw new IllegalStateException("Vinyl is removed");
    }

    @Override
    public void returnVinyl(Vinyl vinyl) throws IllegalStateException {
        throw new IllegalStateException("Vinyl is removed");
    }

    @Override
    public void remove(Vinyl vinyl) throws IllegalStateException {
       throw new IllegalStateException("Vinyl is removed");
    }
}
