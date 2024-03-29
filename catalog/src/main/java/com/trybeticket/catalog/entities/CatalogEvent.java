package com.trybeticket.catalog.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="catalog_events")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CatalogEvent {
  @Id
  private Long id;

  @Size(min=3, message="CatalogEvent must have at least {min} characters")
  @Column(nullable = false)
  private String name;

  @Column(nullable=false)
  private LocalDateTime eventDateTime;
}
