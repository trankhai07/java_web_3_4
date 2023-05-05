package com.laptrinhweb.controller.api.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhweb.model.category;
import com.laptrinhweb.service.ICategory_Service;
import com.laptrinhweb.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-category"})
public class category_api extends HttpServlet{
	@Inject
	private ICategory_Service ctservice;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		category cate = HttpUtil.of(req.getReader()).toModel(category.class);
		
		cate = ctservice.save(cate);
		mapper.writeValue(resp.getOutputStream(),cate );
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");

		ObjectMapper mapper = new ObjectMapper();
		category cate = HttpUtil.of(req.getReader()).toModel(category.class);

		ctservice.delete(cate.getIds());
		mapper.writeValue(resp.getOutputStream(),cate );
	}
}
