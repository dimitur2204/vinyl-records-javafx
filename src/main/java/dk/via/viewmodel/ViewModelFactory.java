package dk.via.viewmodel;

import dk.via.model.ModelManager;

public class ViewModelFactory {
    private final ChangeStateViewModel changeStateViewModel;
    private final VinylListViewModel listViewModel;

    public ViewModelFactory(ModelManager model) {
        this.changeStateViewModel = new ChangeStateViewModel(model);
        this.listViewModel = new VinylListViewModel(model);
    }
    public ChangeStateViewModel getChangeStateViewModel() {
            return changeStateViewModel;
    }
    public VinylListViewModel getListViewModel() {
        return listViewModel;
    }
}

