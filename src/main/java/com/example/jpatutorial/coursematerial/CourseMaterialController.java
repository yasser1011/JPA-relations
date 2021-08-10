package com.example.jpatutorial.coursematerial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courseMaterial")
public class CourseMaterialController {
    private CourseMaterialRepository courseMaterialRepository;

    @Autowired
    public CourseMaterialController(CourseMaterialRepository courseMaterialRepository){
        this.courseMaterialRepository = courseMaterialRepository;
    }
    @GetMapping
    List<CourseMaterial> findAllMaterials(){
        return courseMaterialRepository.findAll();
    }
}
