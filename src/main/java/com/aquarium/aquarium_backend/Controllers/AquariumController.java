package com.aquarium.aquarium_backend.Controllers;

import com.aquarium.aquarium_backend.Services.AquariumService;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/aquarium")
public class AquariumController {
    private final AquariumService aquariumService;

    public AquariumController(AquariumService aquariumService) {
        this.aquariumService = aquariumService;
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Aquarium>> getAquariumByUserId(@PathVariable Long userId) {
        List<Aquarium> aquariumList = aquariumService.getAllUsersAquariums(userId);
        return new ResponseEntity<>(aquariumList, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Aquarium>> getAllAquariums() {
        List<Aquarium> aquariumList = aquariumService.getAllAquariums();
        return new ResponseEntity<>(aquariumList, HttpStatus.OK);
    }
}