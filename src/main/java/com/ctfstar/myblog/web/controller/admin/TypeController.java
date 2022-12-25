package com.ctfstar.myblog.web.controller.admin;


import com.ctfstar.myblog.web.pojo.Type;
import com.ctfstar.myblog.web.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("/types")
    public String types(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable
    , Model model){
        model.addAttribute("page",typeService.listType(pageable));

        return "admin/type";
    }


    @RequestMapping("/types/input")
    public String input(){
        return "admin/typeinput";
    }

    @RequestMapping("/types/submit")
    public String submit(Type type){
        Type t=typeService.saveType(type);
        System.out.println(t);
        return "redirect:/admin/types";
    }


    @RequestMapping("/types/{id}/input")
    public String update(@PathVariable Long id , Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/typeedit";
    }

    @RequestMapping("/types/{id}")
    public String edite(Type type,@PathVariable Long id){
        Type t=typeService.updateType(id,type);

        return "redirect:/admin/types";
    }


    @RequestMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id){
        typeService.deleteType(id);
        return "redirect:/admin/types";
    }
}
