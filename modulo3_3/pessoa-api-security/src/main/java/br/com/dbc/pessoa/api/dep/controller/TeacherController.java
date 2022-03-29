package br.com.dbc.pessoa.api.dep.controller;

import br.com.dbc.pessoa.api.dep.entity.TeacherEntity;
import br.com.dbc.pessoa.api.dep.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherRepository repo;

    @GetMapping
    public List<TeacherEntity> get() {
        return repo.findAll();
    }

    @PostMapping
    public TeacherEntity create(@RequestBody TeacherEntity e) {
        return repo.save(e);
    }
}
