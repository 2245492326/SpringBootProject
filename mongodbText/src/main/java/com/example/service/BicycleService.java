package com.example.service;

import com.example.entity.Bicycle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BicycleService {

    /**
     * 添加车辆信息
     * @param bicycle
     * @return
     */
    public boolean addBicycle(Bicycle bicycle);


    /**
     * 修改车辆信息
     * @param bicycle
     * @return
     */
    public boolean updateBicycle(Bicycle bicycle);


    /**
     * 根据id删除
     * @param id
     */
    public boolean deleteBicycle(int id);

    /**
     * 分页查询
     * @param pageSize
     * @param pageNum
     * @return
     */
    public List<Bicycle> getBicycleList(int pageSize, int pageNum);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Bicycle getBicycleById(int id);

}
