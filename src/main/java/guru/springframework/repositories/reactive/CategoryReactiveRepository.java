/**
 * author: Feng Bo
 *
 * date: Oct 2, 2017
 */
package guru.springframework.repositories.reactive;

import java.util.Optional;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import guru.springframework.domain.Category;
import reactor.core.publisher.Mono;


public interface CategoryReactiveRepository extends ReactiveMongoRepository<Category, String> {

	
	Mono<Category> findByDescription(String description);
}
