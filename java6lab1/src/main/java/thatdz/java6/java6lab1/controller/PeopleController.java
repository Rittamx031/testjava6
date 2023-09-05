package thatdz.java6.java6lab1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import thatdz.java6.java6lab1.entity.People;
import thatdz.java6.java6lab1.repo.PeopleRepo;
import thatdz.java6.java6lab1.repo.PeopleRepository;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("person")
public class PeopleController {
    @Autowired
    public PeopleRepository repo;
    @Autowired
    public PeopleRepo pprepo;

    @GetMapping("index")
    public String getAll(Model model) {
        List<People> list;
        int[] panigation;
        try {
            panigation = repo.panigationRelase();
            list = repo.getObjectInPage(1);
        } catch (Exception e) {
            list = null;
            panigation = null;
        }
        model.addAttribute("people", list);
        if (panigation != null) {
            model.addAttribute("panigation", panigation);
        }
        return "people";
    }

    @GetMapping("page/{pageNo}")
    public String getAll(Model model, @PathVariable("pageNo") int pageNo) {
        List<People> list;
        int[] panigation;
        try {
            panigation = repo.panigationRelase();
            list = repo.getObjectInPage(pageNo);
        } catch (Exception e) {
            list = null;
            panigation = null;
        }
        model.addAttribute("people", list);
        if (panigation != null) {
            model.addAttribute("panigation", panigation);
        }
        return "people";
    }

    @GetMapping("prev-page")
    public String getPrevPage(Model model) {
        List<People> list;
        int[] panigation;
        try {
            list = repo.getPrevPage();
            panigation = repo.panigationRelase();
        } catch (Exception e) {
            list = null;
            panigation = null;
        }
        model.addAttribute("people", list);
        if (panigation != null) {
            model.addAttribute("panigation", panigation);
        }
        return "people";
    }

    @GetMapping("next-page")
    public String getNextPage(Model model) {
        List<People> list;
        int[] panigation;
        try {
            list = repo.getNextPage();
            panigation = repo.panigationRelase();
            System.out.println(panigation[0]);
        } catch (Exception e) {
            list = null;
            panigation = null;
        }
        model.addAttribute("people", list);
        model.addAttribute("panigation", panigation);
        return "people";
    }

    @GetMapping("gop-file")
    public String gopFile() {
        repo.margeFile();
        return "succsetfully";
    }

    @GetMapping("save-in-db")
    public String saveToDatabase() {
        pprepo.saveAll(repo.getAllPeoples());
        return "succsetfully";
    }
    @GetMapping("country-count")
    public String getCountryCount(Model model) {
        model.addAttribute("countries", repo.getQuocGia(repo.getAllPeoples()));
        return "country";
    }
    @GetMapping("slogan-count")
    public String getSloganCount(Model model) {
        model.addAttribute("slogans", repo.getSlogan(repo.getAllPeoples()));
        return "slogan";
    }
    @GetMapping("sort-list-by-salary")
    public String getSortList(Model model ) {
        model.addAttribute("people", repo.getSortList(repo.getAllPeoples()));
        return "people";
    }
    
}
