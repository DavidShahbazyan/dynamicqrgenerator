package arm.davsoft.dynamicqrgenerator.controller;

import arm.davsoft.dynamicqrgenerator.dao.UserDao;
import arm.davsoft.dynamicqrgenerator.helpers.util.SessionUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author David Shahbazyan
 * @since May 08, 2017
 */
public class LoginController {
    private String msg;
    private String user;
    private String pass;

    private UserDao userDao;


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isLoggedIn() {
        return SessionUtils.getSession() != null && SessionUtils.getSession().getAttribute("username") != null;
    }

    //validate login
    public void validateUsernamePassword() throws IOException {
        boolean valid = userDao.validate(user, pass);
        if (valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            FacesContext.getCurrentInstance().getExternalContext().redirect(SessionUtils.getRequest().getContextPath() + "/pages/home.xhtml");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Passowrd", "Please enter correct username and Password"));
            FacesContext.getCurrentInstance().getExternalContext().redirect(SessionUtils.getRequest().getContextPath() + "/pages/index.xhtml");
        }
    }

    //logout event, invalidate session
    public void logout() throws IOException {
        HttpSession session = SessionUtils.getSession();
        System.out.println(String.format("Invalidating session for \"%s\" user.", session.getAttribute("username")));
        session.invalidate();
        FacesContext.getCurrentInstance().getExternalContext().redirect(SessionUtils.getRequest().getContextPath() + "/pages/index.xhtml");
    }
}
