package com.soter.dogp.service;

import com.soter.dogp.repo.SmellRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SmellService {

    @Autowired
    SmellRepo smellRepo;
    public List<Integer> getCheiradosByUser(HttpSession session){
        Integer user_id = (Integer) session.getAttribute("USERID");
        return smellRepo.getCheiradosBy(user_id);
    }

    public void addCheiroToMemory(HttpSession session, Integer cheirado_id){
        if(rememberCheiro(cheirado_id))
        {
            Integer user_id = (Integer) session.getAttribute("USERID");
            smellRepo.registerSmell(user_id,cheirado_id);
        }//dps adiciono uma mensagem de cheiro ja existente
    }

    public void addSmellToSearchList(HttpSession session, Integer cheirado_id){
        Integer user_id = (Integer) session.getAttribute("USERID");
        smellRepo.activateHuntForThePiss(user_id, cheirado_id);
    }

    private boolean rememberCheiro(Integer chid) {
        List<Integer> lista = smellRepo.getAnyByCheirado(chid);
        return smellRepo.getAnyByCheirado(chid).isEmpty();
    }

    public boolean isAuthorBeingHuntedByTheUser(Integer user_id, Integer author_id){
        List<Integer> procurados = smellRepo.listHuntedId(user_id);
        return procurados.contains(author_id);
    }


}
