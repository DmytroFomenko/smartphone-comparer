package dfomenko.service.Impl;

import dfomenko.entity.Smartphone;
import dfomenko.repository.SmartphoneRepository;
import dfomenko.service.SmartphoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SmartphoneServiceImpl implements SmartphoneService {

    private final SmartphoneRepository smartphoneRepository;

    @Override
    public List<Smartphone> findAllSmartphones() {
        return smartphoneRepository.findAll();
    }

    @Override
    public List<Smartphone> findAllByModelId(Long modelId) {
        return smartphoneRepository.findAllByModelId(modelId);
    }

    @Override
    public List<Smartphone> findAllByCompanyId(Long companyId) {
        return smartphoneRepository.findAllByCompanyId(companyId);
    }

    @Override
    public Smartphone findByCompanyIdAndModelId(Long companyId, Long ModelId) {
        return smartphoneRepository.findByCompanyIdAndModelId(companyId, ModelId);
    }


}
