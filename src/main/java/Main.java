import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Result")
public class Main extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter writer = null;
        try{
            writer = response.getWriter();
            writer.println("<center>");

            double result = 0;
            String input = request.getParameter("t1");

            boolean valid = Group10Calculator.getIfValid();

            if(valid != false) {
                result = Group10Calculator.evaluate(input);
                DecimalFormat df = new DecimalFormat("0.000");
                writer.println("<center><br><br><h1>" + "The result is : " + df.format(result) + "</h1></center>");
            }
            else {
                writer.println("<center><br><br><h1>" + "Error: invalid input!" + "</h1></center>");
            }
        }catch(Exception e){
            writer.println("Error: " + e.getMessage());
        }
        finally {
            writer.println("<br>");
            writer.println("<a href=index.html> Enter another expression! </a>");
            writer.println("</center>");
        }
    }

}