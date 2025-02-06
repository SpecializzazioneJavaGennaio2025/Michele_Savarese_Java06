package it.aulab.services;

import org.springframework.stereotype.Component;

import it.aulab.Arm;
import it.aulab.Jeeg;
import it.aulab.Leg;
import it.aulab.repositories.JeegRepository;


@Component("jeegService")
public class JeegServiceImpl implements JeegService {

private JeegRepository jeegRepository;

public JeegServiceImpl(JeegRepository jeegRepository){
    this.jeegRepository=jeegRepository;
}

    @Override
    public void attack() {
        // System.out.println("Jeeg attacca con braccio");
        Jeeg jeeg = jeegRepository.getJeeg();
        Arm armSx = jeeg.getArmSx();
        Arm armDx = jeeg.getArmDx();

        armSx.attack();
        armDx.attack();
    }

    @Override
    public void move() {
        // System.out.println("Jeeg muove con gamba");
        Jeeg jeeg = jeegRepository.getJeeg();
        Leg legSx = jeeg.getLegSx();
        Leg legDx = jeeg.getLegDx();
        legSx.walk();
        legDx.walk();
    }

    public JeegRepository getJeegRepository() {
        return jeegRepository;
    }

    public void setJeegRepository(JeegRepository jeegRepository) {
        this.jeegRepository = jeegRepository;
    }

}
