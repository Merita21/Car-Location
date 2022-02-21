package com.example.demo.controllers;

import com.example.demo.domain.Position;
import com.example.demo.repository.PositionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/position")
public class PositionController {
  private PositionRepository positionRepository;

  public PositionController(PositionRepository positionRepository) {
    this.positionRepository = positionRepository;
  }

  @GetMapping
  public ResponseEntity<List<Position>> getAll() {
    return new ResponseEntity<>(positionRepository.findAll(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Position> addPosition(@RequestBody Position position) {
    return new ResponseEntity<>(positionRepository.save(position), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Position> editPosition(@RequestBody Position position) {
    Position entity = new Position();
    Optional<Position> existingPosition = positionRepository.findById(position.getId());
    if (existingPosition.isPresent()) {
      entity = existingPosition.get();
    }
    entity.setX(position.getX());
    entity.setY(position.getY());
    entity.setTimestamp(position.getTimestamp());

    return new ResponseEntity<>(positionRepository.save(entity), HttpStatus.OK);
  }

  @DeleteMapping(value = "/{id}")
  public void deletePosition(@PathVariable("id") Position position) {
    positionRepository.delete(position);
  }
}
