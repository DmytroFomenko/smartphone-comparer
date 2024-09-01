package dfomenko.repository;

import dfomenko.entity.Company;
import dfomenko.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findCompanyById(Long companyId);
    Company findByCompanyName(String companyName);

}