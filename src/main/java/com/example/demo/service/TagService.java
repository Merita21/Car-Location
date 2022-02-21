package com.example.demo.service;

import com.example.demo.domain.Tag;

import java.util.List;

public interface TagService {
  List<Tag> getAll();

  void saveTag(Tag tag);

  Tag getTagByMacAddress(int macAddres);

}
