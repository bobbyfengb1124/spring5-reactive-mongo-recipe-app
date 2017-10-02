/**
 * author: Feng Bo
 *
 * date: Oct 2, 2017
 */
package guru.springframework.repositories.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import guru.springframework.domain.Recipe;

public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String> {

}
