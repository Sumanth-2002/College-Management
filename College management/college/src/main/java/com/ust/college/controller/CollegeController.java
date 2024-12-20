package com.ust.college.controller;


import com.ust.college.dto.Responsedto;
import com.ust.college.entity.College;
import com.ust.college.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/college/")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @PostMapping("/addCollege")
    public College addCollege(@RequestBody College college){
        return collegeService.addCollege(college);
    }

    @GetMapping("{collegeId}")
    public ResponseEntity<Responsedto> getUser(@PathVariable("collegeId") Long collegeId){
        Responsedto responseDto = collegeService.getStudnet(collegeId);
        return ResponseEntity.ok(responseDto);
    }

}
