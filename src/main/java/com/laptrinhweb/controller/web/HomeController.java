package com.laptrinhweb.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhweb.model.category;
import com.laptrinhweb.model.user;
import com.laptrinhweb.service.ICategory_Service;
import com.laptrinhweb.service.ISong_play_Service;
import com.laptrinhweb.service.IUser_service;
import com.laptrinhweb.utils.Formutil;
import com.laptrinhweb.utils.Sessionutil;

@WebServlet(urlPatterns = {"/trang-chu","/Dang-nhap","/Thoat","/Dang-ky"})
public class HomeController extends HttpServlet{
	@Inject
	private ICategory_Service ctservice;

	@Inject
	private ISong_play_Service sservice;
	@Inject
	private IUser_service user_service;

	ResourceBundle bundle = ResourceBundle.getBundle("message");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Integer code = 1;
//		req.setAttribute("song_play", sservice.findCategoryId(code));
//		req.setAttribute("category", ctservice.findAll());

		String action = req.getParameter("action");
		if(action != null && action.equals("login")){
			String message = req.getParameter("message");
			String alter = req.getParameter("alter");

			if(message != null && alter != null){
				req.setAttribute("message",bundle.getString(message));
				req.setAttribute("alter",alter);
			}
			RequestDispatcher re = req.getRequestDispatcher("/views/login.jsp");
			re.forward(req, resp);
		} else if(action != null && action.equals("logout")){
			Sessionutil.getInstance().removeValue(req,"USERMODEL");
			resp.sendRedirect(req.getContextPath()+"/trang-chu");
		}else if(action != null && action.equals("sign_up")){
			String message = req.getParameter("message");
			String alter = req.getParameter("alter");

			if(message != null && alter != null){
				req.setAttribute("message",bundle.getString(message));
				req.setAttribute("alter",alter);
			}
			RequestDispatcher re = req.getRequestDispatcher("/views/sign_up.jsp");
			re.forward(req, resp);
		}
		else{
			String st = req.getParameter("check");
			req.setAttribute("check_up",st);
			RequestDispatcher re = req.getRequestDispatcher("/views/web/home.jsp");
			re.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("login")){
			user model = Formutil.toModel(user.class,req);
			model = user_service.findusernameandpassword(model.getUsername(), model.getPassword());
			if(model != null){
				Sessionutil.getInstance().putValue(req,"USERMODEL",model);
				if(model.getRoleid().getRole_code().equals("USER")){

					resp.sendRedirect(req.getContextPath()+"/trang-chu?check=success");
				}
				else if(model.getRoleid().getRole_code().equals("ADMIN")){
					resp.sendRedirect(req.getContextPath()+"/admin-home");
				}
			}else{
				resp.sendRedirect(req.getContextPath()+"/Dang-nhap?action=login&message=user_password&alter=danger");
			}
		}
		if(action != null && action.equals("sign_up")){
			user model_new = Formutil.toModel(user.class,req);
			user model = user_service.check_user_password(model_new.getUsername(), model_new.getPassword());
			if(model == null && model_new.getUsername()!= "" && model_new.getPassword() != ""){
//				Sessionutil.getInstance().putValue(req,"USERMODEL",model);
				user_service.save(model_new);

				Sessionutil.getInstance().putValue(req,"USERMODEL",model_new);
				resp.sendRedirect(req.getContextPath()+"/trang-chu?check=success");
			}else{
				resp.sendRedirect(req.getContextPath()+"/Dang-ky?action=sign_up&message=not_sign_fail&alter=danger");
			}
		}
	}
}
