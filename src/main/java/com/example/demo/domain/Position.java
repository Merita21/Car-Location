package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "position")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Position {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int  x;
  private int y;
  private Timestamp timestamp;
}
