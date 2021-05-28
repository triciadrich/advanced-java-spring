package platform.codingnomads.co.springtest.testingjsonresponsecontent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springtest.testingjsonresponsecontent.models.Recipe;

import java.util.ArrayList;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long> {

    ArrayList<Recipe> findByNameContaining(String name);
}
