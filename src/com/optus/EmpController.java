package com.optus;

import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;



@Controller
public class EmpController
	{
	
	public EmpController(){}
	public ArrayList empData(){
		
		Employee e1=new Employee();
		e1.setAge(38);
		e1.setName("lathika");
		e1.setId(1);
		
		Employee e2=new Employee();
		e2.setAge(40);
		e2.setName("Ganesh");
		e2.setId(2);
		
        ArrayList<Employee> al=new ArrayList<Employee>();
		
		al.add(e1);
		al.add(e2);
		return al;
		
	}
	
	@RequestMapping(value="/getAllEmployees",method = RequestMethod.GET)
	public String showEmp(ModelMap model) throws Exception
	{
		
		ArrayList<Employee> al=empData();
		
		/*for(Employee e:al){
			System.out.println(e.getAge());
		}*/
		
		ObjectMapper mapper=new ObjectMapper();
		
		String json=mapper.writeValueAsString(al);
		model.addAttribute("list", json);
		
		return "emp";	
	}
	
	
	@RequestMapping(value="/getAllEmployees/{id}",method = RequestMethod.GET)
	public String EmpDetails(@PathVariable int id,ModelMap model) throws Exception
	{
		
		String json="Null";
		ArrayList<Employee> al=empData();
		
		System.out.println(id);
		
		for(Employee e:al)
		{
			if(e.getId()==id)
			{
				ObjectMapper m=new ObjectMapper();
				json=m.writeValueAsString(e);
				
			}
		}
		
		model.addAttribute("employee", json);
		return "showEmp";
	}
	
	
	@RequestMapping(value = "/rest/getAllEmployees", method = RequestMethod.GET)
	 public @ResponseBody String getEmployee() throws Exception
	 {
		ArrayList<Employee> al=empData();
		 
		 ObjectMapper mapper=new ObjectMapper();
			
			String json=mapper.writeValueAsString(al);
		 return json;
	}
	
	
	@RequestMapping(value = "/rest/getAllEmployees/{id}", method = RequestMethod.GET)
	 public @ResponseBody String getEmployeeInJSON(@PathVariable int id) throws Exception {
		
		String json="Null";
		ArrayList<Employee> al=empData();
		 
		for(Employee e:al)
		{
			if(e.getId()==id)
			{
				ObjectMapper m=new ObjectMapper();
				json=m.writeValueAsString(e);
				
			}
		}
		
		
		
		return json;
	}
	
	
}