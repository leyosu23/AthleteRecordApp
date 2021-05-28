package com.example.jpa;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class DepartmentController {

	@Autowired 
	private AthleteRepository athleteRepository;

	@GetMapping("/stu")
	public String home(Department athlete)
	{
		return "add-athlete";
	}
	
	//add 
	@PostMapping("/add")
	
    public String add(@Valid Department athlete, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-athlete";
        }

        // Check whether an athlete (row) exists in the Player table or not (use an exists () method)
        // and show the player details, or show a message “player does not exist”
        if(!athleteRepository.existsById(athlete.getAthleteId()))
        {
        	 athleteRepository.save(athlete);
             model.addAttribute("athletes", athleteRepository.findAll());
        }
        else
        {
        	return "existingAthelete";
        }
        return "index";
    }
	//Get the edit request
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int no, Model model) {
	    Department pat = athleteRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid athlete number:" + no));

	    model.addAttribute("department", pat);
	    return "update-athlete";
	}
	//update 
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") int no, @Valid Department student,
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        student.setAthleteId(no);
	        return "update-athlete";
	    }

	    athleteRepository.save(student);
	    model.addAttribute("departments", athleteRepository.findAll());
	    return "index";
	}
	//delete 
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int no, Model model) {
	    Department pat= athleteRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid patient Number:" + no));
	    athleteRepository.delete(pat);
	    model.addAttribute("users", athleteRepository.findAll());
	    return "index";
	}

}
