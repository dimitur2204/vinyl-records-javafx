package dk.via.model;

public class Borrowed implements LendingState{
    @Override
    public void borrow(Vinyl vinyl, Person borrower) {
       throw new IllegalStateException("Vinyl is already borrowed");
    }

    @Override
    public void reserve(Vinyl vinyl, Person reserver) {
        if (vinyl.getReserver() == null) {
            vinyl.setReserver(reserver);
        } else {
            throw new IllegalStateException("Vinyl is already reserved");
        }
    }

    public void returnVinyl(Vinyl vinyl) {
        vinyl.setLendingState(new Available());
        vinyl.setBorrower(null);
    }

    @Override
    public void remove(Vinyl vinyl) throws IllegalStateException {
        vinyl.setShouldDeleteWhenAvaliable(true);
    }

    @Override
    public String toString() {
        return "Borrowed";
    }
}
