package com.example.atom.svc;

import com.example.atom.dao.DeployMapper;
import com.example.atom.model.DeploymentGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeploymentService {
    @Autowired
    private DeployMapper mapper;

    public List<DeploymentGroup> getList() throws Exception {
        return mapper.getList();
    }

}
