package dfomenko.repository;

import dfomenko.entity.Model;
import dfomenko.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    Model findModelById(Long modelId);
    Model findByModelName(String modelName);


    @Query("SELECT m FROM Model m WHERE EXISTS " +
            "(SELECT s FROM Smartphone s WHERE s.modelId = m.id AND s.companyId = :companyId)")
    List<Model> findModelsByCompanyId(@Param("companyId") Long companyId);
}