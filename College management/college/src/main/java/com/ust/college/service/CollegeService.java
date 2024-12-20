package com.ust.college.service;


import com.ust.college.dto.Collegedto;
import com.ust.college.dto.Departmentdto;
import com.ust.college.dto.Responsedto;
import com.ust.college.dto.Studentdto;
import com.ust.college.entity.College;
import com.ust.college.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;
    @Autowired
    private WebClient.Builder webClientBuilder;

    public College addCollege(College college){
       return  collegeRepository.save(college);
    }

    public College getCollegeById(Long collegeId){
        return collegeRepository.findById(collegeId).orElse(null);
    }

    public Responsedto getStudnet(Long collegeId) {
        Responsedto responseDto = new Responsedto();
        College college = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new RuntimeException("College not found"));
        Collegedto collegedto = mapToCollege(college);

        // Fetch flights for the airline
        List<Departmentdto> departmentdto= webClientBuilder.baseUrl("http://localhost:9098")
                .build()
                .get()
                .uri("/department/getDeptByCollegeId/" + college.getCollegeId())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Departmentdto>>() {})
                .block();

        // Fetch passengers for each flight
        for (Departmentdto departmentdtos : departmentdto) {
            List<Studentdto> passengerDTOList = webClientBuilder.baseUrl("http://localhost:9097")
                    .build()
                    .get()
                    .uri("/student/getStudentByDeptId/" + departmentdtos.getDeptId())
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<Studentdto>>() {})
                    .block();

            departmentdtos.setStudentdtoList(passengerDTOList);
        }

        responseDto.setCollegedto(collegedto);
        responseDto.setDepartmentdtoList(departmentdto);

        return responseDto;
    }

    private Collegedto mapToCollege(College college) {
        Collegedto dto = new Collegedto();
        dto.setCollegeId(college.getCollegeId());
        dto.setFounder(college.getFounder());
        dto.setLocation(college.getLocation());
        dto.setName(college.getName());
        dto.setStrength(college.getStrength());
        return dto;
    }

}
