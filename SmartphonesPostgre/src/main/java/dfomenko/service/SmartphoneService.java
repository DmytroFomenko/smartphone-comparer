package dfomenko.service;

import dfomenko.entity.Smartphone;

import java.util.List;

public interface SmartphoneService {
    List<Smartphone> findAllSmartphones();

    List<Smartphone> findAllByModelId(Long modelId);

    List<Smartphone> findAllByCompanyId(Long companyId);
    Smartphone findByCompanyIdAndModelId(Long companyId, Long ModelId);

}
