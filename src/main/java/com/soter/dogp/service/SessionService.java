package com.soter.dogp.service;

import com.soter.dogp.objcts.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    public void setUserSession(HttpSession session, User sessionUser){
        session.setAttribute("USERID", sessionUser.getUser_id());
        session.setAttribute("USERNAME", sessionUser.getNome());
        session.setAttribute("USEREMAIL", sessionUser.getEmail());
        session.setAttribute("POSTEID", sessionUser.getLast_post());
        session.setAttribute("LOGGED", true);
    }

}
