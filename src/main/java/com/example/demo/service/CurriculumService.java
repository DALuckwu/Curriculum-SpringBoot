package com.example.demo.service;

import com.example.demo.entities.Curriculum;
import com.example.demo.entities.ExperienciaProfissional;
import com.example.demo.entities.FormacaoAcademica;

import java.util.List;

public interface CurriculumService {
    List<Curriculum> getAllCurriculos();
    Curriculum getCurriculumById(Long id);
    Curriculum createCurriculum(Curriculum curriculum);
    Curriculum updateCurriculum(Long id, Curriculum updatedCurriculum);
    void deleteCurriculum(Long id);

    List<ExperienciaProfissional> getExperienciasProfissionais(Long curriculumId);
    ExperienciaProfissional createExperienciaProfissional(Long curriculumId, ExperienciaProfissional experienciaProfissional);

    List<FormacaoAcademica> getFormacoesAcademicas(Long curriculumId);
    FormacaoAcademica createFormacaoAcademica(Long curriculumId, FormacaoAcademica formacaoAcademica);
}
