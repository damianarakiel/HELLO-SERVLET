package pro.buildmysoftware;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/signIn")
public class LoginServlet extends HttpServlet {

    Accounts accounts = new Accounts();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String> users = Accounts.getUsers();
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        boolean credentialsOk = users.entrySet().stream().anyMatch(e -> e.getKey().equals(login) && e.getValue().equals(password));

        req.getSession().setAttribute("logged", credentialsOk);

        resp.sendRedirect("app/index.jsp");

//
//        HttpSession session = req.getSession();
//        session.setAttribute("login", req.getParameter("login"));
//
//        if(accounts.getUsers().containsKey(session.getAttribute("login"))){
//            if (accounts.getUsers().get(session.getAttribute("login")).equals(session.getAttribute("password"))){
//                resp.sendRedirect("index.jsp");
//            } else {
//                resp.sendRedirect("http://kotytajskie.cba.pl");
//            }
//        } else {
//            resp.sendRedirect("http://kotytajskie.cba.pl");
//        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
