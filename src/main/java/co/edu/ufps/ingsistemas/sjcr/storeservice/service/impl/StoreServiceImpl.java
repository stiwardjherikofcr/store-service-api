package co.edu.ufps.ingsistemas.sjcr.storeservice.service.impl;

import co.edu.ufps.ingsistemas.sjcr.storeservice.entities.Store;
import co.edu.ufps.ingsistemas.sjcr.storeservice.exceptions.ResourceNotFoundException;
import co.edu.ufps.ingsistemas.sjcr.storeservice.repository.StoreRepository;
import co.edu.ufps.ingsistemas.sjcr.storeservice.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<Store> findAllStore() {
        return storeRepository.findAll();
    }

    @Override
    public Store findStoreById(Long id) {
        return storeRepository.findById(id).orElse(null);
    }

    @Override
    public Store createStore(Store storeRequest) {
        return storeRepository.save(storeRequest);
    }

    @Override
    public Store updateStore(Store storeRequest) {
        Store store = findStoreById(storeRequest.getId());
        if (store == null){
            throw new ResourceNotFoundException("Store not exist with id:" + storeRequest.getId());
        }
        else
            store.setName(storeRequest.getName());
        store.setDescription(storeRequest.getDescription());
        store.setPhone(storeRequest.getPhone());
        store.setPicture(storeRequest.getPicture());
        store.setLatitude(storeRequest.getLatitude());
        store.setLongitud(storeRequest.getLongitud());
        return storeRepository.save(store);
    }

    @Override
    public void deleteStore(Long id) throws ResourceNotFoundException {
        if(storeRepository.existsById(id)){
            storeRepository.deleteById(id);
        }
        else throw new ResourceNotFoundException("Store not exist with id:" + id);
    }
}

