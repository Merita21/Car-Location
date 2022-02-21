package com.example.demo.service;

import com.example.demo.domain.Position;
import com.example.demo.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
  private final PositionRepository positionRepository;

  public PositionServiceImpl(final PositionRepository positionRepository) {
    this.positionRepository = positionRepository;
  }

  @Override
  public List<Position> getAll() {
    return null;
  }

  @Override
  public void savePosition(Position position) {
    this.positionRepository.save(position);
  }
  @Override
  public Position getPositionById(int  id) {
    return null;
  }
}
