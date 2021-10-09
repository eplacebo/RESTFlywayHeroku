package rest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.NoteService;
import service.impl.NoteServiceImpl;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;


@WebServlet("/list")
public class UploadDownloadServlet extends HttpServlet {

    NoteService noteService;

    @Override
    public void init() throws ServletException {
        noteService = new NoteServiceImpl();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(request)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024 * 1024 * 3);
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(1024 * 1024 * 40);
            upload.setSizeMax(1024 * 1024 * 50);
            String uploadPath = getServletContext().getRealPath("");
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            try {

                List<FileItem> formItems = upload.parseRequest(request);
                String username = "";
                String fileName = "";
                String filePath = "";

                if (formItems != null && formItems.size() > 0) {
                    for (FileItem item : formItems) {
                        if (!item.isFormField()) {
                            fileName = new File(item.getName()).getName();
                            filePath = uploadPath + fileName;
                            File storeFile = new File(filePath);
                            item.write(storeFile);
                            request.setAttribute("message", "File " + fileName + " has uploaded successfully!");
                        } else if (item.isFormField()) {
                            username = item.getString();
                        }
                    }
                }
                noteService.saveOrUpdate(username, fileName, filePath);

            } catch (Exception ex) {
                request.setAttribute("message", "There was an error: " + ex.getMessage());
            }
            getServletContext().getRequestDispatcher("/WEB-INF/View/result.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

