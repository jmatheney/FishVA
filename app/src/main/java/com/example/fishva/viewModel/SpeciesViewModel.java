package com.example.fishva.viewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.fishva.entities.Species;
import java.util.List;
import androidx.lifecycle.LiveData;
import android.app.Application;
import com.example.fishva.repositories.SpeciesRepository;

public class SpeciesViewModel extends ViewModel {
    private SpeciesRepository speciesRepository;
    private LiveData<List<Species>> allSpecies;
    private Species species;
    private LiveData<List<Species>> loadAll;
    int[] speciesIds;
    int speciesId;
    private Species findBySpeciesId;
    public SpeciesViewModel(Application application) {
        //super(application);
        speciesRepository = new SpeciesRepository(application);
        allSpecies = speciesRepository.getAll();
        species = speciesRepository.getSpecies();
        loadAll = speciesRepository.loadAllBySpeciesIds(speciesIds);
        findBySpeciesId = speciesRepository.findBySpeciesId(speciesId);
    }

    LiveData<List<Species>> getAll() {
        return allSpecies;
    }

    Species getSpecies() {
        return species;
    }

    LiveData<List<Species>> loadAllBySpeciesIds(int[] speciesIds) {
        return loadAll;
    }

    public Species findBySpeciesId(int speciesId) {
        return findBySpeciesId;
    }

    public void insert(Species species) {
        speciesRepository.insert(species);
    }

    public void update(Species species) {
        speciesRepository.update(species);
    }

    public void delete(Species species) {
        speciesRepository.delete(species);
    }
}
