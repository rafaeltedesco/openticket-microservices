package com.trybeticket.catalog.entities;

import java.time.LocalDateTime;

import com.trybeticket.catalog.dtos.CatalogRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="catalog_events")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatalogEvent {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  public static CatalogEvent fromDto(CatalogRequestDto dto) {
    return new CatalogEvent(null, dto.name(), dto.eventDateTime());
  }
  
  @Size(min=3, message="CatalogEvent must have at least {min} characters")
  @Column(nullable = false)
  private String name;

  @Column(nullable=false)
  private LocalDateTime eventDateTime;

  public boolean isValidateDate() {
    return this.eventDateTime.isAfter(LocalDateTime.now());
  }

}
