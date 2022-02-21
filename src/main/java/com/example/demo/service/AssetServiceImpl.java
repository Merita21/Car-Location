package com.example.demo.service;

import com.example.demo.domain.Asset;
import com.example.demo.repository.AssetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {
  private final AssetRepository assetRepository;

  public AssetServiceImpl(final AssetRepository assetRepository) {
    this.assetRepository = assetRepository;
  }

  @Override
  public List<Asset> getAll() {
    return null;
  }

  @Override
  public void saveAsset(Asset asset) {
    this.assetRepository.save(asset);
  }

  @Override
  public Asset getAssetById(int id) {
    return null;
  }

}
