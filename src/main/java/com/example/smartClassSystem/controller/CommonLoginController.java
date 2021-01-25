package com.example.smartClassSystem.controller;

import com.example.smartClassSystem.dto.request.LoginRequest;
import com.example.smartClassSystem.dto.request.TeacherRequest;
import com.example.smartClassSystem.dto.response.IdentityResponse;
import com.example.smartClassSystem.dto.response.LoginResponse;
import com.example.smartClassSystem.services.TeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/maintenance")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CommonLoginController {

    private final TeacherService teacherService;

    @PostMapping("/common/login")
    public ResponseEntity<LoginResponse> SignIn(@RequestBody LoginRequest loginRequest) {

        return new ResponseEntity(teacherService.signIn(loginRequest), HttpStatus.CREATED);
    }


}
