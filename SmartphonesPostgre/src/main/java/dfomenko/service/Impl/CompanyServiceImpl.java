package dfomenko.service.Impl;


import dfomenko.entity.Company;
import dfomenko.repository.CompanyRepository;
import dfomenko.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public Company findCompanyById(Long companyId) {
        return companyRepository.findCompanyById(companyId);
    }


    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Long findCompanyIdByCompanyName(String companyName) {
        return companyRepository.findByCompanyName(companyName).getId();
    }
}
