package com.example.atom.dao;

import com.example.atom.model.DeploymentGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * MyBatis Mapper 인터페이스.
 * @author sykim@ntels.com
 */
@Mapper
@Repository
public interface DeployMapper {
    /**
     * 매핑 파일에 있는 SQL을 호출한다.
     * @return Deployment Group 정보
     * @throws Exception
     */
    List<DeploymentGroup> getList() throws Exception;
}
