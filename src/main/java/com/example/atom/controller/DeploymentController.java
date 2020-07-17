package com.example.atom.controller;

import com.example.atom.model.DeploymentGroup;
import com.example.atom.svc.DeploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * Deployment Controller.
 * Ajax 요청 처리
 * @author sykim@ntels.com
 */
@Controller
public class DeploymentController {
    /**
     * Deployment Service
     */
    @Autowired
    DeploymentService deploymentService;

    /**
     * Ajax 요청에 의해 Deployment Group 리스트를 반환한다.
     * @return DeploymentGroup list
     * @throws Exception
     */
    @RequestMapping(value="/testAjax", method= RequestMethod.GET)
    public @ResponseBody List<DeploymentGroup> testAjax() throws Exception {
        return deploymentService.getList();
    }

}
