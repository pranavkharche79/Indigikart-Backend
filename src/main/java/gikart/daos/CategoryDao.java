package gikart.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gikart.entities.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

}
