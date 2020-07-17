package pl.cv.recipedietapp.service;

import org.springframework.stereotype.Service;
import pl.cv.recipedietapp.entity.DayName;
import pl.cv.recipedietapp.repository.DayNameRepository;

@Service
public class DayNameService {
    private final DayNameRepository dayNameRepository;

    public DayNameService(DayNameRepository dayNameRepository) {
        this.dayNameRepository = dayNameRepository;
    }

    public DayName findByName(String name) {
        return dayNameRepository.findByName(name);
    }
}
