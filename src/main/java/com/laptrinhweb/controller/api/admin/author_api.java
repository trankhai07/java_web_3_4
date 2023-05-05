package com.laptrinhweb.controller.api.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhweb.model.author;
import com.laptrinhweb.service.IAuthor_service;
import com.laptrinhweb.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-author"})
public class author_api extends HttpServlet {
    @Inject
    private IAuthor_service atservice;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        ObjectMapper mapper = new ObjectMapper();
        author at = HttpUtil.of(req.getReader()).toModel(author.class);

        at = atservice.save(at);
        mapper.writeValue(resp.getOutputStream(),at );
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        ObjectMapper mapper = new ObjectMapper();
        author at = HttpUtil.of(req.getReader()).toModel(author.class);

        atservice.delete(at.getIds());
        mapper.writeValue(resp.getOutputStream(),at );
    }
}
