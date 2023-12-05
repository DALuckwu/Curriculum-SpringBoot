package com.example.demo.service;

import com.example.demo.entities.Curriculum;
import com.example.demo.entities.ExperienciaProfissional;
import com.example.demo.entities.FormacaoAcademica;
import com.example.demo.repository.CurriculumRepository;
import com.example.demo.repository.ExperienciaProfissionalRepository;
import com.example.demo.repository.FormacaoAcademicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumServiceImpl implements CurriculumService {

    @Autowired
    private CurriculumRepository curriculumRepository;

    @Autowired
    private ExperienciaProfissionalRepository experienciaProfissionalRepository;

    @Autowired
    private FormacaoAcademicaRepository formacaoAcademicaRepository;

    @Override
    public List<Curriculum> getAllCurriculos() {
        return curriculumRepository.findAll();
    }

    @Override
    public Curriculum getCurriculumById(Long id) {
        return curriculumRepository.findById(id).orElse(null);
    }

    @Override
    public Curriculum createCurriculum(Curriculum curriculum) {
        return curriculumRepository.save(curriculum);
    }

    @Override
    public Curriculum updateCurriculum(Long id, Curriculum updatedCurriculum) {
        updatedCurriculum.setId(id);
        return curriculumRepository.save(updatedCurriculum);
    }

    @Override
    public void deleteCurriculum(Long id) {
        curriculumRepository.deleteById(id);
    }

    @Override
    public List<ExperienciaProfissional> getExperienciasProfissionais(Long curriculumId) {
        Curriculum curriculum = getCurriculumById(curriculumId);
        return curriculum != null ? curriculum.getExperienciasProfissionais() : null;
    }

    @Override
    public ExperienciaProfissional createExperienciaProfissional(Long curriculumId, ExperienciaProfissional experienciaProfissional) {
        Curriculum curriculum = getCurriculumById(curriculumId);
        if (curriculum != null) {
            experienciaProfissional.setCurriculum(curriculum);
            return experienciaProfissionalRepository.save(experienciaProfissional);
        }
        return null;
    }

    @Override
    public List<FormacaoAcademica> getFormacoesAcademicas(Long curriculumId) {
        Curriculum curriculum = getCurriculumById(curriculumId);
        return curriculum != null ? curriculum.getFormacoesAcademicas() : null;
    }

    @Override
    public FormacaoAcademica createFormacaoAcademica(Long curriculumId, FormacaoAcademica formacaoAcademica) {
        Curriculum curriculum = getCurriculumById(curriculumId);
        if (curriculum != null) {
            formacaoAcademica.setCurriculum(curriculum);
            return formacaoAcademicaRepository.save(formacaoAcademica);
        }
        return null;
    }
}
