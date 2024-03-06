package dk.via.model;

public class Borrowed implements LendingState{
    @Override
    public synchronized void borrow(Vinyl vinyl, Person borrower) {
       throw new IllegalStateException("Vinyl is already borrowed");
    }

    @Override
    public synchronized void reserve(Vinyl vinyl, Person reserver) {
        if (vinyl.getReserver() == null) {
            vinyl.setReserver(reserver);
        } else {
            throw new IllegalStateException("Vinyl is already reserved");
        }
    }

    public synchronized void returnVinyl(Vinyl vinyl) {
        vinyl.setBorrower(null);
        vinyl.setLendingState(new Available());
    }

    @Override
    public synchronized void remove(Vinyl vinyl) throws IllegalStateException {
        vinyl.setShouldDeleteWhenAvaliable(true);
    }

    @Override
    public String toString() {
        return "Borrowed";
    }
}
