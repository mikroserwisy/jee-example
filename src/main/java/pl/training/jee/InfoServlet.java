package pl.training.jee;

import lombok.Setter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/info")
public class InfoServlet extends HttpServlet {

    private static final String SERVICE_NAME = "service-name";

    @Setter
    @EJB(beanName = "ServiceStatusProvider")
    private StatusProvider statusProvider; // = new StatusProvider();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var clientName = request.getParameter(SERVICE_NAME);
        //var writer = response.getWriter();
        //var responseText = prepareResponse(statusProvider.getStatus(clientName));
        //writer.println(responseText);
        request.setAttribute("status", statusProvider.getStatus(clientName));
        var dispatcher = getServletContext().getRequestDispatcher("/info-view.jsp");
        dispatcher.forward(request, response);
    }

   /* private String prepareResponse(String status) {
        return "<html><head><title>Info</title></head><body><p>Status: " + status + "</p></body></html>";
    }*/
}
