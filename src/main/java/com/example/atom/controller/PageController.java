package com.example.atom.controller;

import com.example.atom.model.PagingModel;
import com.example.atom.svc.PagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Page Controller.
 * UI 출력
 * @author sykim@ntels.com
 */
@Controller
public class PageController {

    @Autowired
    PagingService pagingService;

    /**
     * deployment_list.jsp 페이지로 이동한다.
     * @return "deployment_list"
     * @throws Exception
     */
    @RequestMapping("/deployment")
    public String deploymentList(Model model) throws Exception {
        PagingModel pagingModel = new PagingModel();
        pagingModel = pagingService.createPaging(1);
        model.addAttribute("pagingModel", pagingModel);
        return "deployment_list";
    }

}
