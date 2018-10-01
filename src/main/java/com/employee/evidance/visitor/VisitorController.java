package com.employee.evidance.visitor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @RequestMapping(value = "/visitors", method = RequestMethod.GET)
    public List<Visitor> getAllVisitors() {
        return visitorService.getAllVisitors();
    }

    @RequestMapping(value = "/createVisitor", method = RequestMethod.POST)
    public void createVisitor(@RequestBody Visitor visitor) {
        visitorService.createVisitor(visitor);
    }

    @RequestMapping(value = "/deleteVisitor/{id}", method = RequestMethod.DELETE)
    public void deleteVisitor(@PathVariable String id) {
        visitorService.deleteVisitor(id);

    }

    @RequestMapping(value = "/editVisitor/{id}", method = RequestMethod.PUT)
    public void editVisitor(@RequestBody Visitor visitor, @PathVariable String id) {
        visitorService.editVisitor(id, visitor);
    }

    @RequestMapping(value = "/getVisitor/{id}", method = RequestMethod.GET)
    public Visitor findSpecificVisitor(@PathVariable String id) {
        return visitorService.findSpecificVisitor(id);
    }
}