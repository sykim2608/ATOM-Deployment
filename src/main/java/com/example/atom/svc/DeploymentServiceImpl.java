package com.example.atom.svc;

import com.example.atom.dao.DeployMapper;
import com.example.atom.model.DeploymentGroup;
import com.example.atom.model.ModifyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Deployment Group 데이터 처리 클래스.
 * @author sykim@ntels.com
 */
@Service
public class DeploymentServiceImpl implements DeploymentService {
    /**
     * DeployMapper
     */
    @Autowired
    private DeployMapper mapper;

    @Override
    public List<DeploymentGroup> getList() throws Exception {
        return mapper.getList();
    }

    @Override
    public void deleteList(String deploymentId) throws Exception {
        mapper.deleteList(deploymentId);
    }

    @Override
    public void addList(DeploymentGroup deploymentGroup) throws Exception {
        mapper.addList(deploymentGroup);
    }

    @Override
    public void modifyList(ModifyModel modifyModel) throws Exception {
        mapper.modifyList(modifyModel);
    }


}
