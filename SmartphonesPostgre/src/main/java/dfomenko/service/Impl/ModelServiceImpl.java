package dfomenko.service.Impl;


import dfomenko.entity.Model;
import dfomenko.repository.ModelRepository;
import dfomenko.repository.SmartphoneRepository;
import dfomenko.service.ModelService;
import dfomenko.service.SmartphoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final SmartphoneRepository smartphoneRepository;

    @Override
    public Model findModelById(Long modelId) {
        return modelRepository.findModelById(modelId);
    }

    @Override
    public List<Model> findAllModels() {
        return modelRepository.findAll();
    }

    @Override
    public Long findModelIdByModelName(String modelName) {
        return modelRepository.findByModelName(modelName).getId();
    }


    @Override
    public List<Model> findModelsByCompanyId(Long companyId) {
        return modelRepository.findModelsByCompanyId(companyId);
    }
}
