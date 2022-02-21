package com.example.demo.controllers;

import com.example.demo.domain.Tag;
import com.example.demo.repository.TagRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/tag")
public class TagController {
  private TagRepository tagRepository;

  public TagController(TagRepository tagRepository) {
    this.tagRepository = tagRepository;
  }

  @GetMapping
  public ResponseEntity<List<Tag>> getAll() {
    return new ResponseEntity<>(tagRepository.findAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Tag> addTag(@RequestBody Tag tag) {
    return new ResponseEntity<>(tagRepository.save(tag), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Tag> editTag(@RequestBody Tag tag) {
    Tag entity = new Tag();
    Optional<Tag> existingTag = tagRepository.findById(tag.getMacAddress());
    if (existingTag.isPresent()) {
      entity = existingTag.get();
    }
    entity.setMacAddress(tag.getMacAddress());
    entity.setInventoryNumber(tag.getInventoryNumber());
    entity.setBatteryStatusOn(tag.isBatteryStatusOn());

    return new ResponseEntity<>(tagRepository.save(entity), HttpStatus.OK);
  }

  @DeleteMapping(value = "/{macAddress}")
  public void deleteTag(@PathVariable("macAddress") Tag tag) {
    tagRepository.delete(tag);
  }
}
