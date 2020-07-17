package com.example.atom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Page Controller.
 * UI 출력
 * @author sykim@ntels.com
 */
@Controller
public class PageController {
    /**
     * deployment_list.jsp 페이지로 이동한다.
     * @return "deployment_list"
     * @throws Exception
     */
    @RequestMapping("/deployment")
    public String deploymentList() throws Exception {
        return "deployment_list";
    }

}
