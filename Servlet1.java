/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Lenovo
 */
public class Servlet1 extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String message=request.getParameter("message");
                String city=request.getParameter("city");
                String sdate=request.getParameter("sdate");
                String edate=request.getParameter("edate");
		response.setContentType("text/html");
               
		
                RequestDispatcher rd=request.getRequestDispatcher("pack1.Servlet2");
                rd.include(request, response);
             
		try
		{	
                
               Class.forName("com.mysql.jdbc.Driver");
			
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
               String sqlqry="insert into mytable1(name,email,contact,message,sdate,edate,city) values(?,?,?,?,?,?,?)";
               PreparedStatement ps = con.prepareStatement(sqlqry);
               
             
               
               ps.setString(1,name);
               ps.setString(2,email);
               ps.setString(3,contact);
               ps.setString(4,message);
               ps.setString(5,sdate);
               ps.setString(6,edate);
               ps.setString(7,city);
         
               int i=ps.executeUpdate();
                
             
                if(i==1)
                {
                  
                out.print("<!DOCTYPE html>\n" +
"<html>\n" +
"	<head lang=\"en\"> \n" +
"		<title>VijaySoniPhotography</title>\n" +
"		<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"images/logo.jpg\" />\n" +
"		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n" +
"		<meta charset=\"UTF-8\" name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no\"/>\n" +
"		<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"		<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\n" +
"		<link rel=\"stylesheet\" type=\"text/css\" href=\"https://fonts.googleapis.com/css?family=Pacifico\">\n" +
"		<link href=\"https://fonts.googleapis.com/css?family=PT+Sans+Caption\" rel=\"stylesheet\">\n" +
"		<link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
"		<link rel=\"stylesheet\" href=\"http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">\n" +
"		<link href=\"https://fonts.googleapis.com/css?family=Montserrat|Raleway\" rel=\"stylesheet\">\n" +
"		<link href=\"https://fonts.googleapis.com/css?family=Dancing+Script\" rel=\"stylesheet\">\n" +
"		<script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>\n" +
"		<link rel=\"stylesheet\" href=\"vsp.css\"/>\n" +
"	</head>\n" +
"	<body>\n" +
"		<header style=\"color:black;\">\n" +
"			<nav class=\"navbar navbar-responsive navbar-fixed-top\"  id=\"nav_header\">					\n" +
"				<div class=\"container\">\n" +
"					<div class=\"navbar-header\">\n" +
"						<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#mainNavBar\">\n" +
"							<span class=\"icon-bar\" style=\"background-color:#FFFFFF; margin-top:8px;\" id=\"spanbtn1\"></span>\n" +
"							<span class=\"icon-bar\" style=\"background-color:#FFFFFF; margin-top:6px;\" id=\"spanbtn2\"></span>\n" +
"							<span class=\"icon-bar\" style=\"background-color:#FFFFFF; margin-top:6px;\" id=\"spanbtn3\"></span>\n" +
"						</button>\n" +
"						<h1 class=\"h1-responsive fontawesome-cog\"><a href=\"index.html\" id=\"navheading\">Vijay Soni Photography</a></h1>\n" +
"					</div>	\n" +
"					<div class=\"collapse navbar-collapse\" id=\"mainNavBar\">\n" +
"						<ul class=\"nav navbar-right\">\n" +
"							<li class=\"active\"><a href=\"index.html\" id=\"link2\" style=\"color:#081448\">Home</a></li>\n" +
"							<li><a href=\"index.html#about\" id=\"link3\" style=\"color:#081448\">About Us</a></li>\n" +
"							<li class=\"dropdown\">\n" +
"								<a href=\"\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" id=\"link4\" style=\"color:#081448\">Portfolio\n" +
"									<span class=\"caret\"></span>\n" +
"								</a>\n" +
"								<ul class=\"dropdown-menu\">\n" +
"									<li><a class=\"dropdown-item\" href=\"portfolio1.html\" id=\"link7\" style=\"color:#081448\">Bridal Photoshoot</a></li>\n" +
"									<li><a class=\"dropdown-item\" href=\"portfolio2.html\" id=\"link8\" style=\"color:#081448\">Pre wedding Photoshoot</a></li>\n" +
"									<li><a class=\"dropdown-item\" href=\"portfolio3.html\" id=\"link9\" style=\"color:#081448\">Wedding photoshoot</a></li>\n" +
"								</ul>\n" +
"							</li>\n" +
"							<li><a href=\"index.html#stories\" id=\"link5\" style=\"color:#081448\">Stories</a></li>\n" +
"							<li><a href=\"ContactPage.html\" id=\"link6\" style=\"color:#081448\">Contact Us</a></li>\n" +
"						</ul>\n" +
"					</div>	\n" +
"				</div>\n" +
"			</nav>\n" +
"		</header>\n" +
"		\n" +
                        "<p style=\"font-family:'Dancing Script', cursive;font-size:150px;:100px;margin-top:150px;\"><center>Thank you for your request</center></p>"+
"		<footer class=\"container-fluid footer-bs\" style=\"margin-top:150px\">\n" +
"			<div class=\"container\">\n" +
"				<div class=\"row\">\n" +
"					<div class=\"col-md-4 footer-brand animated fadeInLeft\">\n" +
"						<h2>Logo</h2>\n" +
"						<p>Suspendisse hendrerit tellus laoreet luctus pharetra. Aliquam porttitor vitae orci nec ultricies. Curabitur vehicula, libero eget faucibus faucibus, purus erat eleifend enim, porta pellentesque ex mi ut sem.</p>\n" +
"					</div>\n" +
"					<div class=\"col-md-4 footer-nav animated fadeInUp\">\n" +
"						<h4 style=\"padding-left:15px;\">Menu</h4>\n" +
"						<div class=\"col-md-6\">\n" +
"							<ul class=\"list\">\n" +
"								<li><a href=\"\">About Us</a></li>\n" +
"								<li><a href=\"\">Portfolio</a></li>\n" +
"								<li><a href=\"\">Contact Us</a></li>\n" +
"							</ul>\n" +
"						</div>\n" +
"					</div>\n" +
"					<div class=\"col-md-4 footer-social animated fadeInDown\">\n" +
"						<h4>Follow Us</h4>\n" +
"						<ul>\n" +
"							<li><a href=\"\">Facebook</a></li>\n" +
"							<li><a href=\"\">Twitter</a></li>\n" +
"							<li><a href=\"\">Instagram</a></li>\n" +
"						</ul>\n" +
"					</div>\n" +
"				</div>\n" +
"VijaySoniPhotography.com</p><p>&copy;All rights reserved</p></section>\n" +
"			</div>\n" +
                        
"		</footer>\n" +
"		<script>\n" +
"			$(document).ready(function(){\n" +
"				$(\"#link3\").click(function(){\n" +
"					$(\"#link6\").css(\"background-color\".\"white\");\n" +
"				});\n" +
"			});\n" +
"		</script>\n" +
"		<script>\n" +
"			$(document).scroll(function(){\n" +
"				var startPoint=$(document).scrollTop();\n" +
"				if(startPoint>=300)\n" +
"					{\n" +
"						$(\"#nav_header\").css({\"background-color\":\"#FFFFFF\"});\n" +
"						$(\"#navheading\").css({\"color\":\"#002233\"});					\n" +
"						$(\"#link1\").css({\"color\":\"#002233\"});\n" +
"						$(\"#link2\").css({\"color\":\"#002233\"});\n" +
"						$(\"#link3\").css({\"color\":\"#002233\"});\n" +
"						$(\"#link4\").css({\"color\":\"#002233\"});\n" +
"						$(\"#link5\").css({\"color\":\"#002233\"});\n" +
"						$(\"#link6\").css({\"color\":\"#002233\"});\n" +
"						$(\"#link7\").css({\"color\":\"#002233\"});					\n" +
"						$(\"#heading\").css({\"color\":\"#002233\"});\n" +
"						$(\"#spanbtn1\").css({\"background-color\":\"#002233\"});					\n" +
"						$(\"#spanbtn2\").css({\"background-color\":\"#002233\"});					\n" +
"						$(\"#spanbtn3\").css({\"background-color\":\"#002233\"});					\n" +
"					}\n" +
"				else\n" +
"					{\n" +
"						  $(\"#nav_header\").css({\"background-color\":\"rgba(0,36,51,0.1)\"});\n" +
"						  $(\"#navheading\").css({\"color\":\"#FFFFFF\"});\n" +
"						  $(\"#link1\").css({\"color\":\"#FFFFFF\"});\n" +
"						  $(\"#link2\").css({\"color\":\"#FFFFFF\"});\n" +
"						  $(\"#link3\").css({\"color\":\"#FFFFFF\"});\n" +
"						  $(\"#link4\").css({\"color\":\"#FFFFFF\"});\n" +
"						  $(\"#link5\").css({\"color\":\"#FFFFFF\"});\n" +
"						  $(\"#link6\").css({\"color\":\"#FFFFFF\"});\n" +
"						  $(\"#link7\").css({\"color\":\"#FFFFFF\"});\n" +
"						  $(\"#heading\").css({\"color\":\"#FFFFFF\"});\n" +
"						  $(\"#spanbtn1\").css({\"background-color\":\"#FFFFFF\"});\n" +
"						  $(\"#spanbtn2\").css({\"background-color\":\"#FFFFFF\"});\n" +
"						  $(\"#spanbtn3\").css({\"background-color\":\"#FFFFFF\"});\n" +
"					}\n" +
"			});\n" +
"		</script>\n" +
"		<script>\n" +
"			$(document).scroll(function(){\n" +
"				var startPoint=$(document).scrollTop();\n" +
"				if(startPoint>=300)\n" +
"					{\n" +
"						$(\"nav\").css({\"position\":\"fixed\"});\n" +
"						$(\"nav\").css({\"\":\"\"});\n" +
"					}\n" +
"				else\n" +
"					{\n" +
"						  \n" +
"					}\n" +
"			});\n" +
"		</script>\n" +
"		<script src=\"js/bootstrap.min.js\"></script>\n" +
"		<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\n" +
"		<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" +
"		<script src=\"jquery-3.2.1.min.js\"></script>\n" +
"	</body>\n" +
"</html>");
                }
               con.close();
           
		}
		catch (Exception e2) 
                {out.print(e2);
		e2.printStackTrace();} 
                
		out.close();
                
		
	
    }
}

   
   


