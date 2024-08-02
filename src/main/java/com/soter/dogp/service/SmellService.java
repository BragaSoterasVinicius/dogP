package com.soter.dogp.service;

import com.soter.dogp.objcts.Cheiro;
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
    public List<Cheiro> getCheiradosByUser(HttpSession session){
        Integer user_id = (Integer) session.getAttribute("USERID");
        return smellRepo.getCheiradosBy(user_id);
    }

    public void addCheiroToMemory(HttpSession session, Integer cheirado_id){
        Integer user_id = (Integer) session.getAttribute("USERID");
        if(rememberCheiro(cheirado_id, user_id))
        {
            smellRepo.registerSmell(user_id,cheirado_id);
        }//dps adiciono uma mensagem de cheiro ja existente
    }

    public void addSmellToSearchList(HttpSession session, Integer cheirado_id){
        Integer user_id = (Integer) session.getAttribute("USERID");
        Boolean switcher = !smellRepo.isItAlreadyPiss(user_id, cheirado_id);
        smellRepo.activateHuntForThePiss(user_id, cheirado_id, switcher);
    }

    private boolean rememberCheiro(Integer chid, Integer userid) {
        List<Cheiro> lista = smellRepo.getAllByCoordinates(chid, userid);
        return lista.isEmpty();
    }

    public boolean isAuthorBeingHuntedByTheUser(Integer user_id, Integer author_id){
        List<Integer> procurados = smellRepo.listHuntedId(user_id);
        return procurados.contains(author_id);
    }

    public void changeApelido(Integer smellId, String apelido){
        smellRepo.changeApelido(smellId, apelido);
    }


    public String getApelido(int userid, Integer sessionUser) {
        return smellRepo.findAppelidoByUserId(userid, sessionUser);
    }
}
