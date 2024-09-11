package com.dmtr.rest.my_controller;

import com.dmtr.rest.entity.Pupil;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class PupilRestController {


    private List<Pupil> pupils;

    @PostConstruct
    public void createListOfPupils(){
        pupils = new ArrayList<>();

        Pupil pupil1 = new Pupil("Serj", "Bul");
        Pupil pupil2 = new Pupil("Oleg", "Petrov");
        Pupil pupil3 = new Pupil("Ivan", "Ivanov");

        pupils.add(pupil1);
        pupils.add(pupil2);
        pupils.add(pupil3);
    }
    @GetMapping("/pupils")
    public List<Pupil> getAllPupil() {
        return pupils;
    }

    @GetMapping("/pupils/{pupilIndex}")
    public Pupil getPupil(@PathVariable(name = "pupilIndex") int id){
        return pupils.get(id);
    }


}
