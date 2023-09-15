package pl.javastart.exercise;

import org.springframework.data.repository.CrudRepository;

interface NameStatsRepo extends CrudRepository<NameStats, Long> {
}
