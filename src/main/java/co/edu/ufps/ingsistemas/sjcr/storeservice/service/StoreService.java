package co.edu.ufps.ingsistemas.sjcr.storeservice.service;

import co.edu.ufps.ingsistemas.sjcr.storeservice.entities.Store;

import java.util.List;

public interface StoreService {
    public List<Store> findAllStore();
    public Store findStoreById(Long id);
    public Store createStore(Store store);
    public Store updateStore(Store store);
    public void  deleteStore(Long id);
}
