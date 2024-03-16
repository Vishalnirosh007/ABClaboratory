package abc.laboratory.webapp.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import abc.laboratory.webapp.Model.Doctor;
import abc.laboratory.webapp.Service.DoctorService;


@WebServlet("/doctorController")

public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        DoctorService doctorService = DoctorService.getDoctorServiceInstance();

        if (type != null && type.equals("specific")) {
            getSpecificDoctor(request, response, doctorService);
        } else {
            getAllDoctors(request, response, doctorService);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        DoctorService doctorService = DoctorService.getDoctorServiceInstance();

        if (type != null && type.equals("update")) {
            updateDoctor(request, response, doctorService);
        } else if (type != null && type.equals("add")) {
            addDoctor(request, response, doctorService);
        } else if (type != null && type.equals("delete")) {
            deleteDoctor(request, response, doctorService);
        }
    }

    private void getAllDoctors(HttpServletRequest request, HttpServletResponse response, DoctorService service) throws ServletException, IOException {

        String message = "";
        List<Doctor> doctorList;

        try {
            doctorList = service.getAllDoctors();
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
            doctorList = new ArrayList<>();
        }

        request.setAttribute("message", message);
        request.setAttribute("doctorList", doctorList);

        RequestDispatcher rd = request.getRequestDispatcher("DoctorDashboard.jsp");
        rd.forward(request, response);
    }

    private void getSpecificDoctor(HttpServletRequest request, HttpServletResponse response, DoctorService service) throws ServletException, IOException {
        String doctorIdStr = request.getParameter("doctorID");
        int doctorID;
        Doctor doctor;
        String message = "";

        if (doctorIdStr != null && !doctorIdStr.isEmpty()) {
            try {
                doctorID = Integer.parseInt(doctorIdStr);
                doctor = service.getSpecificDoctor(doctorID);
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                message = e.getMessage();
                doctor = new Doctor();
            }
        } else {
            message = "Doctor ID is missing or invalid.";
            doctor = new Doctor();
        }

        request.setAttribute("doctor", doctor);
        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Search-Doctor-Details.jsp");
        rd.forward(request, response);
    }


    private void updateDoctor(HttpServletRequest request, HttpServletResponse response, DoctorService service) throws ServletException, IOException {
        int doctorID = Integer.parseInt(request.getParameter("doctorID"));
        String firstName = request.getParameter("doctorFirstName");
        String lastName = request.getParameter("doctorLastName");
        String specialization = request.getParameter("doctorSpecialization");
        String email = request.getParameter("doctorEmail");

        Doctor doctor = new Doctor(doctorID, firstName, lastName, specialization, email);

        boolean result;
        String message = "";
        try {
            result = service.editTheDoctor(doctor);
            if (result) {
                message = "Doctor " + doctorID + " has been successfully updated!";
            } else {
                message = "Failed to update the doctor! Doctor ID: " + doctorID;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Search-Doctor-Details.jsp");
        rd.forward(request, response);
    }


    private void addDoctor(HttpServletRequest request, HttpServletResponse response, DoctorService service) throws ServletException, IOException {

        String firstName = request.getParameter("doctorFirstName");
        String lastName = request.getParameter("doctorLastName");
        String specialization = request.getParameter("doctorSpecialization");
        String email = request.getParameter("doctorEmail");

        Doctor doctor = new Doctor(firstName, lastName, specialization, email);

        boolean result;
        String message = "";
        try {
            result = service.registerDoctor(doctor);
            if (result) {
                message = "Doctor " + firstName + " " + lastName + " has been successfully added!";
            } else {
                message = "Failed to add the doctor! Doctor: " + firstName + " " + lastName;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("Add-Doctor-Details.jsp");
        rd.forward(request, response);
    }

    private void deleteDoctor(HttpServletRequest request, HttpServletResponse response, DoctorService service) throws ServletException, IOException {

        int doctorID = Integer.parseInt(request.getParameter("doctorID"));

        boolean result;
        String message = "";
        try {
            result = service.deleteTheDoctor(doctorID);
            if (result) {
                message = "Doctor ID " + doctorID + " has been successfully deleted!";
            } else {
                message = "Failed to delete the doctor! Doctor ID: " + doctorID;
            }
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        HttpSession session = request.getSession();

        try {
            List<Doctor> doctorList = service.getAllDoctors();
            session.setAttribute("doctorList", doctorList);
        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        session.setAttribute("message", message);
        response.sendRedirect("DoctorDashboard.jsp");
    }

}
