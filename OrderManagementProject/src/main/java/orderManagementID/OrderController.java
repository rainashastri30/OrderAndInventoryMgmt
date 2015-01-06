package orderManagementID;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@SessionAttributes("product")

public class OrderController {
//	@RequestMapping("/hello")
//	public String helloWorld(Model model){
//		model.addAttribute("name","Raina");
//		return "hello";
	
//	
//	@RequestMapping(value = "/login" , method = RequestMethod.GET)
//	public String welcomePage(Model model) {
//		//ModelAndView model = new ModelAndView();
////		model.setViewName("hello");
//		return "login";
//	}
	
	String product_id ;
	String productType;
	List<Cars>productList = new ArrayList<Cars>();
	
	@Autowired
	ProductInfoService productInfoService;
	
	@Autowired
	Product product;
	
	
//	
	
	
	
	
	@RequestMapping(value = "/login")
	public String login(HttpServletResponse response) {
		
//		 response.addHeader("Access-Control-Allow-Origin", "*");
//	        response.addHeader("Access-Control-Allow-Methods", "POST,GET");
//	        response.addHeader("Access-Control-Allow-Headers", "Content-Type, Accept");
//	        
//	        response.setStatus(403);
				return "login";
	}
	
	@RequestMapping(value = "/Cancel", method = RequestMethod.POST)
	public void Cancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
	
		request.logout();
		 response.sendRedirect("http://localhost:3000/#/store");
				//return "cancel";
	}
	
	@RequestMapping(value = "/Back",method = RequestMethod.POST)
	public void GoBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
	
		request.logout();
		 response.sendRedirect("http://localhost:3000/#/store");
				//return "cancel";
	}
	
	
	@RequestMapping(value = {"/","/user/login"})
	public String noProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
	
		//request.logout();
		// response.sendRedirect("http://localhost:3000/#/store");

//	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	      String name = auth.getName(); //get logged in username
	      
				return "noProduct";
	}
	

	@RequestMapping(value = "/orderHistory",method = RequestMethod.POST)
	public ModelAndView orderHistroy(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
	
		//request.logout();
		// response.sendRedirect("http://localhost:3000/#/store");

	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); //get logged in username
	      List<Product> orderList = productInfoService.fectchAllOrder(name);
	      ModelAndView andView = new ModelAndView();
	      andView.addObject("orderList", orderList);
	      andView.setViewName("orderList");
				return andView;
	}
	
	
	
	
	
	@RequestMapping(value = "/home/{productCategory}/{productId}")
	@ResponseBody
	public Product home(@PathVariable String productId,@PathVariable String productCategory,HttpSession session) throws Exception {
		
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String name = auth.getName(); //get logged in username
		
		 
        if(productCategory.equalsIgnoreCase("cars")){
        	 product = productInfoService.checkProductAvailability(productId,productCategory,name);
        	
        }
        else if(productCategory.equalsIgnoreCase("tvs")){
        	 product = productInfoService.checkProductAvailability(productId,productCategory,name);
        	
        	
        }
        else if(productCategory.equalsIgnoreCase("nps")){
        	 product = productInfoService.checkProductAvailability(productId,productCategory,name);
       	
        }
        
        session.setAttribute("productId", productId);
		session.setAttribute("productCategory", productCategory);
		session.setAttribute("product", product);
		ModelAndView model = new ModelAndView();
		model.addObject("product", product);
		model.setViewName("productDescription");
        return product;
		
	}
	
	
	
//	@RequestMapping(value = "/hello")
//	public String hello() {
//
//				return "hello";
//	}
//	
//	@RequestMapping(value = "/")
//	public String home1() {
//
//				return "home";
//	}
	
//	@RequestMapping(value="/CheckProduct")
//	public ModelAndView checkProduct(HttpSession session) throws Exception{
//		//if(product=="car"){
//		//productList = productInfoService.checkCarAvailability(product_id,product);
//		session.setAttribute("productId", product_id);
//		session.setAttribute("product", productType);
//		ModelAndView model = new ModelAndView();
//		model.addObject("productList",productList);
//		model.setViewName("productDescription");
//		//}
//		
//		return model;
//		
//	}

//	@RequestMapping(value = "/payment", method = RequestMethod.POST)
//	public ModelAndView payment() {
//		
//		ModelAndView model = new ModelAndView();
//		model.addObject("productList",productList);
//		model.setViewName("payment");
//
//				return model;
//	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public ModelAndView payment(Map<String, Object> modelMap,HttpSession session){
		Customer cust = new Customer();
		ModelAndView model = new ModelAndView();
	//	model.addObject("productList",productList);
	//	session.getAttribute("productcategory");
		model.addObject("productCategory",session.getAttribute("productCategory"));
		session.setAttribute("product", product);
		model.addObject("customer",cust);
		model.addObject("product", product);
		model.setViewName("payment");
		//modelMap.put("customerForm", cust);

		return model;
	}
	
	@RequestMapping(value = "/Confirm", method = RequestMethod.POST)
	public ModelAndView confirm(@Valid @ModelAttribute("customer")Customer customer,ModelMap model,HttpSession session) {
		
		
		session.setAttribute("product",product);
		model.addAttribute("customer", customer);
		session.setAttribute("customer", customer);
		
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("product", product);
		modelView.addObject("productCategory",session.getAttribute("productCategory"));
		modelView.setViewName("confirmView");
		return modelView;
		
		
		 
	}
	
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public ModelAndView addOrder(HttpSession session) throws Exception {
		
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String name = auth.getName(); //get logged in username
		Object obj = session.getAttribute("customer");
		session.setAttribute("product",product);
		String objProductId = session.getAttribute("productId").toString();
		String objProductCategory = session.getAttribute("productCategory").toString();
		int orderId = productInfoService.insertOrderDetails((Customer)obj,(String)objProductId,(String)objProductCategory,name);
		ModelAndView andView = new ModelAndView();
		andView.addObject("orderId", orderId);
		andView.setViewName("orderDetails");
		session.setAttribute("orderId", orderId);

		return andView;
		
		
		 
	}
	
	@RequestMapping(value = "/CancelOrder/{orderId}", method = RequestMethod.GET)
	public ModelAndView cancelOrder(HttpSession session,@PathVariable int orderId) {
		
	boolean deleteSuccess = productInfoService.deleteOrder(orderId);
		ModelAndView andView = new ModelAndView();
		andView.addObject("status", deleteSuccess);
		andView.setViewName("cancel");
	

		return andView;
		
		
		 
	}

	
}

