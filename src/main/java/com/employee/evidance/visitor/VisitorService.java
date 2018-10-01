package com.employee.evidance.visitor;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {


    @Autowired
    private VisitorRepository visitorRepository;


    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    public void createVisitor(Visitor visitor) {

        if (validateIDCard(visitor.getIdCard())) {
            visitorRepository.save(visitor);
        }

    }

    private boolean validateIDCard(String idCard) {
        if (idCard.length() == 7 && Character.isLetter(idCard.charAt(0)) && idCard.charAt(0) == 'A' && isDigit(
            idCard)) {

            return true;
        }

        return false;
    }

    private boolean isDigit(String idCard) {

        for (int i = 1; i < idCard.length(); i++) {
            if (!Character.isDigit(idCard.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void deleteVisitor(String visitorId) {
        visitorRepository.deleteById(visitorId);
    }

    public void editVisitor(String visitorId, Visitor visitor) {
        Optional<Visitor> visitorToBeUpdated = visitorRepository.findById(visitorId);

        if (visitorToBeUpdated.isPresent()) {
            visitorToBeUpdated.get().setName(visitor.getName());
            visitorToBeUpdated.get().setIdCard(visitor.getIdCard());
            visitorToBeUpdated.get().setArrivalTime(visitor.getArrivalTime());
            visitorToBeUpdated.get().setExitTime(visitor.getExitTime());
            visitorToBeUpdated.get().setSurname(visitor.getSurname());
        }

        this.createVisitor(visitorToBeUpdated.get());
    }

    public Visitor findSpecificVisitor(String visitorId) {
        return visitorRepository.findById(visitorId).get();
    }


}
