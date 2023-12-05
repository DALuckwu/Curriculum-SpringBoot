package com.example.demo.controllers;

import com.example.demo.entities.Curriculum;
import com.example.demo.entities.ExperienciaProfissional;
import com.example.demo.entities.FormacaoAcademica;
import com.example.demo.repository.CurriculumRepository;
import com.example.demo.repository.ExperienciaProfissionalRepository;
import com.example.demo.repository.FormacaoAcademicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curriculos")
public class CurriculumController {

    @Autowired
    private CurriculumRepository curriculumRepository;

    @Autowired
    private ExperienciaProfissionalRepository experienciaProfissionalRepository;

    @Autowired
    private FormacaoAcademicaRepository formacaoAcademicaRepository;

    // Endpoints para Curriculum

    @GetMapping
    public List<Curriculum> getAllCurriculos() {
        return curriculumRepository.findAll();
    }

    @GetMapping("/{id}")
    public Curriculum getCurriculumById(@PathVariable Long id) {
        return curriculumRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Curriculum createCurriculum(@RequestBody Curriculum curriculum) {
        return curriculumRepository.save(curriculum);
    }

    @PutMapping("/{id}")
    public Curriculum updateCurriculum(@PathVariable Long id, @RequestBody Curriculum updatedCurriculum) {
        updatedCurriculum.setId(id);
        return curriculumRepository.save(updatedCurriculum);
    }

    @DeleteMapping("/{id}")
    public void deleteCurriculum(@PathVariable Long id) {
        curriculumRepository.deleteById(id);
    }

    // Endpoints para ExperienciaProfissional

    @GetMapping("/{curriculumId}/experiencias")
    public List<ExperienciaProfissional> getExperienciasProfissionais(@PathVariable Long curriculumId) {
        Curriculum curriculum = curriculumRepository.findById(curriculumId).orElse(null);
        if (curriculum != null) {
            return curriculum.getExperienciasProfissionais();
        }
        return null;
    }

    @PostMapping("/{curriculumId}/experiencias")
    public ExperienciaProfissional createExperienciaProfissional(
            @PathVariable Long curriculumId,
            @RequestBody ExperienciaProfissional experienciaProfissional) {
        Curriculum curriculum = curriculumRepository.findById(curriculumId).orElse(null);
        if (curriculum != null) {
            experienciaProfissional.setCurriculum(curriculum);
            return experienciaProfissionalRepository.save(experienciaProfissional);
        }
        return null;
    }

    // Endpoints para FormacaoAcademica

    @GetMapping("/{curriculumId}/formacoes")
    public List<FormacaoAcademica> getFormacoesAcademicas(@PathVariable Long curriculumId) {
        Curriculum curriculum = curriculumRepository.findById(curriculumId).orElse(null);
        if (curriculum != null) {
            return curriculum.getFormacoesAcademicas();
        }
        return null;
    }

    @PostMapping("/{curriculumId}/formacoes")
    public FormacaoAcademica createFormacaoAcademica(
            @PathVariable Long curriculumId,
            @RequestBody FormacaoAcademica formacaoAcademica) {
        Curriculum curriculum = curriculumRepository.findById(curriculumId).orElse(null);
        if (curriculum != null) {
            formacaoAcademica.setCurriculum(curriculum);
            return formacaoAcademicaRepository.save(formacaoAcademica);
        }
        return null;
    }
}
