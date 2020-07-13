package com.example.atom.dao;

import com.example.atom.model.DeploymentGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeployMapper {
    List<DeploymentGroup> getList() throws Exception;
}
