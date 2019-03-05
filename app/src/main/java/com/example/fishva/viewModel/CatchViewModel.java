package com.example.fishva.viewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.fishva.entities.Catch;
import java.util.List;
import androidx.lifecycle.LiveData;
import android.app.Application;
import com.example.fishva.repositories.CatchRepository;

public class CatchViewModel extends ViewModel {
    private CatchRepository catchRepository;
    private LiveData<List<Catch>> allCatch;
    private Catch caught;
    private LiveData<List<Catch>> loadAll;
    int[] catchIds;
    int catchId;
    private Catch findByCatchId;
    public CatchViewModel(Application application) {
        //super(application);
        catchRepository = new CatchRepository(application);
        allCatch = catchRepository.getAll();
        caught = catchRepository.getCatch();
        loadAll = catchRepository.loadAllByIds(catchIds);
        findByCatchId = catchRepository.findByCatchId(catchId);
    }

    LiveData<List<Catch>> getAll() {
        return allCatch;
    }

    Catch getCatch() {
        return caught;
    }

    LiveData<List<Catch>> loadAllByIds(int[] catchIds) {
        return loadAll;
    }

    public Catch findByCatchId(int catchId) {
        return findByCatchId;
    }

    public void insert(Catch caught) {
        catchRepository.insert(caught);
    }

    public void update(Catch caught) {
        catchRepository.update(caught);
    }

    public void delete(Catch caught) {
        catchRepository.delete(caught);
    }
}
