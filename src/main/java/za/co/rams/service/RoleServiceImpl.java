package za.co.rams.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import za.co.rams.dao.entity.Role;
import za.co.rams.dao.repo.RoleRepo;
import za.co.rams.dto.RoleDTO;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepo roleRepo;
    private ModelMapper mapper;
    public RoleServiceImpl(RoleRepo roleRepo, ModelMapper mapper){
        this.roleRepo = roleRepo;
        this.mapper = mapper;
    }

    @Override
    public List<RoleDTO> retrieveAllRoles() {
        List<RoleDTO> roleDTOList = new ArrayList<>();
        roleRepo.findAll().stream().forEach(role -> {roleDTOList.add(mapper.map(role, RoleDTO.class));});
        return roleDTOList;
    }
}
