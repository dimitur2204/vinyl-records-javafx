package dk.via;

import dk.via.model.ModelManager;
import dk.via.model.Person;
public class ReserveVinyls2 implements Runnable{
    private ModelManager model;
    public ReserveVinyls2(ModelManager model) {
        this.model = model;
    }
    @Override
    public void run() {
        try {
            Person person = new Person("Jane Doe");
            int first = 0;
            Thread.sleep(1000);
            this.model.reserveVinyl(first, person);
            Thread.sleep(1000);
            this.model.borrowVinyl(first, person);
            Thread.sleep(1000);
            this.model.returnVinyl(first);
            Thread.sleep(1000);
            this.model.returnVinyl(first);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
