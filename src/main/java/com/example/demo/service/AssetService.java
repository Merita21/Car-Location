package com.example.demo.service;

import com.example.demo.domain.Asset;

import java.util.List;

public interface AssetService {
  List<Asset> getAll();

  void saveAsset(Asset asset);

  Asset getAssetById(int id);
}
