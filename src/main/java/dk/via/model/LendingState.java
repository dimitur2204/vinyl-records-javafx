package dk.via.model;

// The Vinyl can be in different states depending on availability, reservation, borrowing or a combined borrowing and reservation.
// You can borrow a Vinyl either if it is not reserved by someone else or are already borrowed or if it is reserved by you (reserved). You cannot reserve a Vinyl if it already contains a reservation (there is no reservation list, only one person at the time can reserve the Vinyl). However, you are allowed to reserve a Vinyl if it is available (no reservation and not borrowed) or if it is borrowed and do not have another reservation.
public interface LendingState {
   public void borrow(Vinyl vinyl, Person borrower) throws IllegalStateException;
    public void reserve(Vinyl vinyl, Person reserver) throws IllegalStateException;
    public void returnVinyl(Vinyl vinyl) throws IllegalStateException;
    public void remove(Vinyl vinyl) throws IllegalStateException;
}
