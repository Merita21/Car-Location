package com.example.demo.service;

import com.example.demo.domain.Position;

import java.util.List;

public interface PositionService {
  List<Position> getAll();

  void savePosition(Position position);

  Position getPositionById(int id);
}
