package licenta.backend.service;

import licenta.backend.model.Rezervation;

import licenta.backend.repository.RezervationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RezervationService {
    @Resource
    public RezervationRepository rezervationRepository;
    public  RezervationService(RezervationRepository rezrepository){
        rezervationRepository=rezrepository;
    }
    public List<Rezervation> findAll(){
        return rezervationRepository.findAll();

    }
    public Rezervation save(Rezervation rezervation){

        return rezervationRepository.save(rezervation);
    }
    public  <T> Optional<Rezervation> findById(Long id){
        return  rezervationRepository.findById(id);
    }
    public  void delete(Rezervation rezervation){
        rezervationRepository.delete(rezervation);
    }
}
