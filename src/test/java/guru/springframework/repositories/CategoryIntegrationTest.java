package categoryRepositorygframework.repositories;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

/**
 * Created by jt on 6/17/17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryIntegrationTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() {

        System.out.println("Quick test ");
        AtomicInteger ai = new AtomicInteger(0);
        List<Category> categories = new LinkedList<>();
        this.categoryRepository.findAll().forEach( categories::add);
        Assertions.assertThat(categories.size()).isEqualTo(8);

        for ( Category c : categories ) {
            this.categoryRepository.findByDescription(c.getDescription());
        }

    }

}