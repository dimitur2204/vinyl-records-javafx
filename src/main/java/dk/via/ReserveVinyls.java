package dk.via;

import dk.via.model.ModelManager;
import dk.via.model.Person;
import dk.via.model.Reserved;
import dk.via.model.Vinyl;

public class ReserveVinyls implements Runnable{
    private ModelManager model;
    public ReserveVinyls(ModelManager model) {
        this.model = model;
    }
    @Override
    public void run() {
        try {
            Person person = new Person("John Doe");
            int first = 0;
            Thread.sleep(1000);
            this.model.reserveVinyl(first, person);
            Thread.sleep(1000);
            this.model.borrowVinyl(first, person);
            Thread.sleep(1000);
            this.model.returnVinyl(first);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
