package com.example.demo.service;

import com.example.demo.domain.Tag;
import com.example.demo.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
  private final TagRepository tagRepository;

  public TagServiceImpl(final TagRepository tagRepository) {
    this.tagRepository = tagRepository;
  }

  @Override
  public List<Tag> getAll() {
    return null;
  }

  @Override
  public void saveTag(Tag tag) {
    this.tagRepository.save(tag);
  }

  @Override
  public Tag getTagByMacAddress(int macAddres) {
    return null;
  }
}
