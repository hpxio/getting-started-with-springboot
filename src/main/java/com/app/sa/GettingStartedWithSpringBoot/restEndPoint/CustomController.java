package com.app.sa.GettingStartedWithSpringBoot.restEndPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {

    @Autowired
    CustomService customService;

    @RequestMapping(path = "/app/add", method = RequestMethod.POST)
    public String addData(@RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "data", required = false) String data) {
        customService.repository.save(name, data);
        return customService.repository.print();
    }
}
