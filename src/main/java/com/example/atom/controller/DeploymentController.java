package com.example.atom.controller;

import com.example.atom.model.DeploymentGroup;
import com.example.atom.svc.DeploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class DeploymentController {
    @Autowired
    private DeploymentService deploymentService;

    @RequestMapping(value="/testAjax", method= RequestMethod.GET)
    public @ResponseBody List<DeploymentGroup> testAjax() throws Exception {
        return deploymentService.getList();
    }

    @RequestMapping("/deployment")
    public String deploymentList(Model model) throws Exception {
        List<DeploymentGroup> deploymentGroups = deploymentService.getList();
        model.addAttribute("list", deploymentGroups);
        return "deployment_list";
    }

}