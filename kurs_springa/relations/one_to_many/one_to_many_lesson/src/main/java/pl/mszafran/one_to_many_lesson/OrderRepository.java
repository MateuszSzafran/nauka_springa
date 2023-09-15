package pl.mszafran.one_to_many_lesson;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<UserOrder, Long> {
}
