package com.infoshareacademy.czerwoni.servlets;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("upload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(
                FileUploadServlet.class.getCanonicalName());

    protected void processRequest(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        final String path = request.getParameter("destination");
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);

        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();

        try {
            out = new FileOutputStream(
                        new File(path + File.separator + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            writer.println("Nowy plik " + fileName + " utworzony w " + path);
            LOGGER.log(
                    Level.INFO,
                    "Plik {0} został przesłany do {1}",
                    new Object[] { fileName, path });
        } catch (FileNotFoundException fne) {
            writer.println(
                    "Albo nie wskazałeś pliku do przesłania, albo "
                    + "próbujesz go zapisać w nieistniejącej lub niedostępnej "
                    + "lokalizacji.");
            writer.println("<br/> BŁĄD: " + fne.getMessage());

            LOGGER.log(
                    Level.SEVERE,
                    "Problemy w trakcie przesyłu pliku. Błąd: {0}",
                    new Object[] { fne.getMessage() });
        } finally {
            if (out != null) {
                out.close();
            }

            if (filecontent != null) {
                filecontent.close();
            }

            if (writer != null) {
                writer.close();
            }
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Nagłówek części = {0}", partHeader);

        for (String content : part.getHeader("content-disposition")
                                  .split(";")) {
            if (content.trim()
                           .startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1)
                              .trim()
                              .replace("\"", "");
            }
        }

        return null;
    }


    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet that uploads files to a user-defined destination";
    }
}
