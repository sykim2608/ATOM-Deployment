package com.example.atom.controller;

import com.example.atom.model.*;
import com.example.atom.svc.DeploymentService;
import com.example.atom.svc.PagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    PagingService pagingService;

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

    /**
     * Ajax 요청에 따른 Deployment Group 등록
     * @param deploymentGroup 등록할 Deployment Group 정보
     * @throws Exception
     */
    @RequestMapping(value="/addList", method = RequestMethod.POST)
    public @ResponseBody void addList(@RequestBody DeploymentGroup deploymentGroup) throws Exception {
        deploymentService.addList(deploymentGroup);
    }

    /**
     * Ajax 요청에 따른 Deployment Group 변경
     * @param modifyModel 변경할 Deployment Group 정보
     * @throws Exception
     */
    @RequestMapping(value="/modifyList", method = RequestMethod.POST)
    public @ResponseBody void modifyList(@RequestBody ModifyModel modifyModel) throws Exception {
        deploymentService.modifyList(modifyModel);
    }

    /**
     * Ajax 요청에 따른 Deployment Group 검색
     * @param searchModel 검색할 Deployment Group 정보
     * @return 검색된 DeploymentGroup 정보
     * @throws Exception
     */
    @RequestMapping(value="/findList", method = RequestMethod.POST)
    public @ResponseBody List<DeploymentGroup> findList(@RequestBody SearchModel searchModel) throws Exception {
        return deploymentService.findList(searchModel);
    }

    @RequestMapping(value="/pageList", method = RequestMethod.GET)
    public String pageList(Model model, int curPage) throws Exception {
        PagingModel pagingModel = new PagingModel();
        pagingModel = pagingService.createPaging(curPage);
        model.addAttribute("pagingModel", pagingModel);
        return "/deployment_list";
    }

}
