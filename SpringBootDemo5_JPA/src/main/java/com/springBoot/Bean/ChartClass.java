package com.springBoot.Bean;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springBoot.Entity.EntityClass;
import com.springBoot.dao.RepositoryClass;

@Service
public class ChartClass {
	
	@Autowired
	RepositoryClass repobj;
	
	public BufferedImage generateBarChart() {
		List<EntityClass> lobj = repobj.findAll();
		
		Map<String,Double> map = new HashMap<>();
		for(EntityClass x: lobj) {
			String category = x.getCategory();
			Double price = x.getPrice();
			
			if(map.containsKey(category)) {
				map.put(category, map.get(category)+price);
			}else {
				map.put(category, price);
			}
		}
		
		
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(Map.Entry<String, Double> entry:map.entrySet()) {
        	dataset.addValue(entry.getValue(),"Graph",entry.getKey());
        }
       

        JFreeChart barChart = ChartFactory.createBarChart(
                "Category Vs Price", 
                "Category", 
                "Price", 
                dataset, 
                PlotOrientation.VERTICAL, 
                true, true, false);

        return barChart.createBufferedImage(800, 600);
    }

}
