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
            Person person2 = new Person("Jane Doe");
            int randomVinyl = (int) (Math.random() * model.getVinylList().getVinyls().size());
            Thread.sleep(1000);
            this.model.reserveVinyl(randomVinyl, person);
            Thread.sleep(1000);
            this.model.borrowVinyl(randomVinyl, person);
            Thread.sleep(1000);
            this.model.reserveVinyl(randomVinyl, person2);
            Thread.sleep(1000);
            this.model.borrowVinyl(randomVinyl, person2);
            Thread.sleep(1000);
            this.model.returnVinyl(randomVinyl);
            Thread.sleep(1000);
            this.model.reserveVinyl(randomVinyl, person2);
            Thread.sleep(1000);
            this.model.borrowVinyl(randomVinyl, person2);
            Thread.sleep(5000);
            this.model.returnVinyl(randomVinyl);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
