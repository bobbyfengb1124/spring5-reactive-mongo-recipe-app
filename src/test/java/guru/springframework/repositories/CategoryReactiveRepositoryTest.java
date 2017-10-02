/**
 * author: Feng Bo
 *
 * date: Oct 2, 2017
 */
package guru.springframework.repositories;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.domain.Category;
import guru.springframework.repositories.reactive.CategoryReactiveRepository;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryReactiveRepositoryTest {

	private static final String FOO = "Foo";
	@Autowired
	CategoryReactiveRepository categoryReactiveRepository;

	@Before
	public void setUp() throws Exception {
		categoryReactiveRepository.deleteAll().block();
	}

	@Test
	public void testSave() throws Exception {
		Category category = new Category();
		category.setDescription(FOO);

		categoryReactiveRepository.save(category).block();

		Long count = categoryReactiveRepository.count().block();

		assertEquals(Long.valueOf(1L), count);
	}

	@Test
	public void testFindByDescription() throws Exception {
		Category category = new Category();
		category.setDescription(FOO);

		categoryReactiveRepository.save(category).then().block();

		Category fetchedCat = categoryReactiveRepository.findByDescription(FOO).block();

		assertNotNull(fetchedCat.getId());
	}

}
