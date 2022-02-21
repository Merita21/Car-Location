package com.example.demo.controllers;

import com.example.demo.domain.AssetGroup;
import com.example.demo.repository.AssetGroupRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/assetGroup")
public class AssetGroupController {
  private AssetGroupRepository assetGroupRepository;

  public AssetGroupController(AssetGroupRepository assetGroupRepository) {
    this.assetGroupRepository = assetGroupRepository;
  }

  @GetMapping
  public ResponseEntity<List<AssetGroup>> getAll() {
    return new ResponseEntity<>(assetGroupRepository.findAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<AssetGroup> addAssetGroup(@RequestBody AssetGroup assetGroup) {
    return new ResponseEntity<>(assetGroupRepository.save(assetGroup), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<AssetGroup> editAssetGroup(@RequestBody AssetGroup assetGroup) {
    AssetGroup entity = new AssetGroup();
    Optional<AssetGroup> existingAssetGroup = assetGroupRepository.findById(assetGroup.getId());
    if (existingAssetGroup.isPresent()) {
      entity = existingAssetGroup.get();
    }
    entity.setName(assetGroup.getName());

    return new ResponseEntity<>(assetGroupRepository.save(entity), HttpStatus.OK);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteTag(@PathVariable("id") AssetGroup assetGroup) {
    assetGroupRepository.delete(assetGroup);
  }
}
