package com.example.atom.controller;

import com.example.atom.dao.DeployMapper;
import com.example.atom.model.DeploymentGroup;
import com.example.atom.svc.DeploymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DeploymentController {
    @Autowired
    private DeploymentService deploymentService;

    @RequestMapping("/test")
    public @ResponseBody List<DeploymentGroup> jspTest() throws Exception {
        return deploymentService.getList();
    }

    @RequestMapping("/list")
    public String list(Model model) throws Exception {
        List<DeploymentGroup> deploymentlist = deploymentService.getList();
        model.addAttribute("list", deploymentlist);

        return "list";
    }



}
