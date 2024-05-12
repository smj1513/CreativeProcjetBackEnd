package _2024.creativeproject.persistence.repository;

import _2024.creativeproject.persistence.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
