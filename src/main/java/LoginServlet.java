import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns= "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("login/html");
        PrintWriter writer=resp.getWriter();

        String username= req.getParameter("username");
        String password= req.getParameter("password");
        //most azért írtuk be mert nincs adatbázis a háttérbe
        if(username.equals("admin") && password.equals("admin")){
           writer.write("jó a jelszó");

        }else writer.write("nem jó a jelsző");
        req.getRequestDispatcher("login.html").include(req, resp);

        writer.close();
    }
}
