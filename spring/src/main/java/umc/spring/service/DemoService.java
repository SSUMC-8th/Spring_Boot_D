package umc.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.spring.domain.DemoEntity;
import umc.spring.repository.DemoRepository;

@Service
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;

    public DemoEntity saveDemoEntity(DemoEntity entity) {
        return demoRepository.save(entity);
    }
}
