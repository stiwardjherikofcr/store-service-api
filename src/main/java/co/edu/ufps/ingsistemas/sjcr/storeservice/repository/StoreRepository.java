package co.edu.ufps.ingsistemas.sjcr.storeservice.repository;

import co.edu.ufps.ingsistemas.sjcr.storeservice.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  StoreRepository extends JpaRepository<Store, Long> {

}
