package dfomenko.repository;

import dfomenko.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {

    List<Smartphone> findAllByModelId(Long modelId);

    List<Smartphone> findAllByCompanyId(Long companyId);
    Smartphone findByCompanyIdAndModelId(Long companyId, Long ModelId);
}