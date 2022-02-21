package com.example.demo.service;


import com.example.demo.domain.AssetGroup;
import com.example.demo.repository.AssetGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetGroupServiceImpl implements AssetGroupService {
  private final AssetGroupRepository assetGroupRepository;

  public AssetGroupServiceImpl(final AssetGroupRepository assetGroupRepository) {
    this.assetGroupRepository = assetGroupRepository;
  }

  @Override
  public List<AssetGroup> getAll() {
    return null;
  }

  @Override
  public void saveAssetGroup(AssetGroup assetGroup) {
    this.assetGroupRepository.save(assetGroup);
  }

  @Override
  public AssetGroup getAssetGroupById(int id) {
    return null;
  }
}
