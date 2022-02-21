package com.example.demo.controllers;

import com.example.demo.domain.Asset;
import com.example.demo.repository.AssetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/asset")
public class AssetController {
  private AssetRepository assetRepository;

  public AssetController(AssetRepository assetRepository) {
    this.assetRepository = assetRepository;
  }

  @GetMapping
  public ResponseEntity<List<Asset>> getAll() {
    return new ResponseEntity<>(assetRepository.findAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Asset> addAsset(@RequestBody Asset asset) {
    return new ResponseEntity<>(assetRepository.save(asset), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Asset> editAsset(@RequestBody Asset asset) {
    Asset entity = new Asset();
    Optional<Asset> existingAsset = assetRepository.findById(asset.getId());
    if (existingAsset.isPresent()) {
      entity = existingAsset.get();
    }
    entity.setName(asset.getName());
    entity.setDescription(asset.getDescription());
    entity.setInventoryNumber(asset.getInventoryNumber());
    entity.setAssetGroup(asset.getAssetGroup());


    return new ResponseEntity<>(assetRepository.save(entity), HttpStatus.OK);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteAsset(@PathVariable("id") Asset asset) {
    assetRepository.delete(asset);
  }
}
