package org.jsuns.util;

import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jsuns.X;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthorizationFilter implements Filter {

    public AuthorizationFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        try {

            HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;

//            if (true) {
//                Object mod = request.getParameter("mod");
//                if (mod == null) {
//                    mod = reqt.getSession().getAttribute("mod");
//                } else {
//                    reqt.getSession().setAttribute("mod", mod);
//                }
//                X.log("fffffffffffff");
//                request.setAttribute("mod", mod);
//                chain.doFilter(request, response);
//                return;
//            }

            HttpSession ses = reqt.getSession(false);
            String reqURI = reqt.getRequestURI();
            System.out.println("uri=" + reqURI);
            String q[] = reqURI.split("/");
            String module = request.getParameter("q");

            if (reqURI.contains("/login.xhtml")
                    || (ses != null && ses.getAttribute("usuario") != null)
                    || reqURI.contains("/public/")
                    || reqURI.contains("javax.faces.resource")) {
//                System.out.println("requestURI=" + reqURI);
//                System.out.println("module=" + module);
//                String sm = ses != null ? (String) ses.getAttribute("menu") : null;
//                System.out.println("dni=" + request.getParameter("dni"));
//                for (String s : q) {
//                    System.out.print("[" + s + "]");
//                }
//                if (request != null && request.getAttribute("included") == null) {
//                    Object url2 = request.getParameter("url2");
//                    X.log("included=" + request.getAttribute("included"));
//
//                    if (url2 != null) {
//
//                        X.log("se agrega hace request to '" + "/faces" + url2 + ".xhtml" + "'");
//                        request.setAttribute("included", true);
//                        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces" + url2 + ".xhtml");
////                        request.getRequestDispatcher("/faces"+url2+".xhtml").forward(request, response);
//                        return;
//                    }
//                }
//                if (ses == null || ses.getAttribute("usuario") == null) {
//                    System.out.println("op1");
//                    chain.doFilter(request, response);
//                } else if (sm == null && module == null) {
//                    //request.getRequestDispatcher("/faces/pegasus/index.xhtml").include(request, response);
//                    if (!"admin.xhtml".equals(q[3])) {
//                        resp.sendRedirect(reqt.getContextPath() + "/faces/admin.xhtml");
//                    } else {
//                        chain.doFilter(request, response);
//                    }
//                } else {
//                    if (module != null) {
//                        ses.setAttribute("menu", module);
//                        if (sm == null || !sm.equals(module)) {
//                            ses.setAttribute("url", null);
//                        }
//                    }
//                    if ("faces".equals(q[2]) || "javax.faces.resource".equals(q[2])) {
//                        X.log("se llamara a la pagina " + reqURI);
                        chain.doFilter(request, response);
//                    } else {
//                        request.setAttribute("url", "/" + q[2] + "/" + q[3]);
//                        System.out.println("Se incluira " + request.getAttribute("url"));
//                        //ses.setAttribute("url", "/" + q[2] + "/" + q[3]);
////                       FacesContext.getCurrentInstance().getExternalContext().dispatch("/faces/pegasus/index.xhtml");
////                       FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/pegasus/index.xhtml");
//                        request.getRequestDispatcher("/faces/pegasus/index.xhtml").forward(request, response);
//                        //resp.sendRedirect(reqt.getContextPath() + "/faces/pegasus/index.xhtml");
//                    }
//                }
            } else {
                resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void destroy() {

    }
}
