package dfomenko.service;

import dfomenko.entity.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModelService {

    Model findModelById(Long modelId);

    List<Model> findAllModels();

    Long findModelIdByModelName(String modelName);

    @Query("SELECT m FROM Model m WHERE EXISTS " +
            "(SELECT s FROM Smartphone s WHERE s.modelId = m.id AND s.companyId = :companyId)")
    List<Model> findModelsByCompanyId(@Param("companyId") Long companyId);

}
