package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "asset")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String description;
  private int inventoryNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "assetGroupId", insertable = false, updatable = false)
  private AssetGroup assetGroup;
}
