package dfomenko.service;

import dfomenko.entity.Company;

import java.util.List;

public interface CompanyService {
    Company findCompanyById(Long companyId);
    List<Company> findAllCompanies();
    public Long findCompanyIdByCompanyName(String companyName);
}
