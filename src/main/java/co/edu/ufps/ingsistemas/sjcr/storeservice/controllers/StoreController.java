package co.edu.ufps.ingsistemas.sjcr.storeservice.controllers;

import co.edu.ufps.ingsistemas.sjcr.storeservice.entities.Store;
import co.edu.ufps.ingsistemas.sjcr.storeservice.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/stores")
@Tag(name = "Store")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation",
                content = {@Content(mediaType = "application/json",
                        schema = @Schema(implementation = Store.class))}),
        @ApiResponse(responseCode = "400", description = "Bad request",
                content = @Content),
        @ApiResponse(responseCode = "404", description = "Store not found",
                content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error",
                content = @Content)})
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping()
    @Operation(summary = "Get all stores", description = "Get all stores")
    public ResponseEntity<List<Store>> findAllStore() {
        List<Store> stores = storeService.findAllStore();
        return ResponseEntity.ok(stores);
    }

    @GetMapping(value = "/find/{id}")
    @Operation(summary = "Get store by id", description = "Get store by id")
    public ResponseEntity<Store> findStoreById(@PathVariable("id") Long id) {
        Store store = storeService.findStoreById(id);
        return ResponseEntity.ok(store);
    }

    @PostMapping(value = "/add")
    @Operation(summary = "Add store", description = "Add store")
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        Store newStore = storeService.createStore(store);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStore);
    }

    @PutMapping(value = "/update/{id}")
    @Operation(summary = "Update store", description = "Update store")
    public ResponseEntity<Store> updateStore(@PathVariable("id") Long id, @RequestBody Store store) {
        storeService.updateStore(store);
        return ResponseEntity.ok(store);
    }

    @DeleteMapping(value = "/delete/{id}")
    @Operation(summary = "Delete store", description = "Delete store")
    public ResponseEntity<?> deleteStore(@PathVariable("id") Long id) {
        storeService.deleteStore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
