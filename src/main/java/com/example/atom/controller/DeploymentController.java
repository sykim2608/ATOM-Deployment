package com.example.atom.controller;

import com.example.atom.model.DeleteModel;
import com.example.atom.model.DeploymentGroup;
import com.example.atom.svc.DeploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

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
     * Ajax 요청에 따른 Deployment Group 리스트를 반환
     * @return DeploymentGroup list
     * @throws Exception
     */
    @RequestMapping(value="/getList", method= RequestMethod.GET)
    public @ResponseBody List<DeploymentGroup> getList() throws Exception {
        return deploymentService.getList();
    }

    /**
     * Ajax 요청에 따른 Deployment Group 삭제
     * @param deleteModel 삭제할 Deployment Group 아이디
     * @throws Exception
     */
    @RequestMapping(value="/deleteList", method = RequestMethod.POST)
    public @ResponseBody void deleteList(@RequestBody DeleteModel deleteModel) throws Exception {
        deploymentService.deleteList(deleteModel.getDeploymentId());
    }

}
