package com.sunglowsys.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Hotel_Inventory_1")
public class HotelInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String totalInventory;

    public HotelInventory() {
    }

    public HotelInventory(Long id, String totalInventory) {
        this.id = id;
        this.totalInventory = totalInventory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(String totalInventory) {
        this.totalInventory = totalInventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelInventory that = (HotelInventory) o;
        return Objects.equals(id, that.id) && Objects.equals(totalInventory, that.totalInventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalInventory);
    }

    @Override
    public String toString() {
        return "HotelInventory{" +
                "id=" + id +
                ", totalInventory='" + totalInventory + '\'' +
                '}';
    }
}
