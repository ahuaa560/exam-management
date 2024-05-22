package com.example.examManageFronend1.service.ManagerService;

import com.example.examManageFronend1.mapper.RegionMapper;
import com.example.examManageFronend1.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionMapper regionMapper;

    public Region getRegionById(String regionId) {
        return regionMapper.selectRegionById(regionId);
    }

    public List<Region> getAllRegions() {
        return regionMapper.selectAllRegions();
    }

    public void addRegion(Region region) {
        regionMapper.insertRegion(region);
    }

    public void updateRegion(Region region) {
        regionMapper.updateRegion(region);
    }

    public void deleteRegion(String regionId) {
        regionMapper.deleteRegion(regionId);
    }

}