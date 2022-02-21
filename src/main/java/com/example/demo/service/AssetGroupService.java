package com.example.demo.service;

import com.example.demo.domain.AssetGroup;

import java.util.List;

public interface AssetGroupService {
  List<AssetGroup> getAll();

  void saveAssetGroup(AssetGroup assetGroup);

  AssetGroup getAssetGroupById(int id);
}
