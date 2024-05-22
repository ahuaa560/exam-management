package com.example.examManageFronend1.service.ManagerService;

import com.example.examManageFronend1.mapper.OrganizationMapper;
import com.example.examManageFronend1.model.Organization;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    private final OrganizationMapper organizationMapper;

    public OrganizationService(OrganizationMapper organizationMapper) {
        this.organizationMapper=organizationMapper;
    }

    public Organization findByUserId(String userId) {
            return organizationMapper.findByUserId(userId);
    }

    public Organization findAll(){ return organizationMapper.findAll();}

    public void addOrganization(Organization organization) {
         organizationMapper.insert(organization);
    }

    public void deleteOrganization(Organization organization) {
        organizationMapper.delete(organization);
    }




}
