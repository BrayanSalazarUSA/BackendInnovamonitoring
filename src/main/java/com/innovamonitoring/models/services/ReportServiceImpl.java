package com.innovamonitoring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovamonitoring.models.dao.IReportDao;
import com.innovamonitoring.models.entity.Report;

@Service
public class ReportServiceImpl implements IReportService {

	@Autowired
	private IReportDao reportDao;

	@Override
	public List<Report> findAll() {

		return (List<Report>) reportDao.findAll();
	}

	@Override
	public Report save(Report report) {
		// TODO Auto-generated method stub
		return reportDao.save(report);
	}

	@Override
	public void delete(Long id) {
		reportDao.deleteById(id);
	}

	@Override
	public Report findById(Long id) {
		
		return reportDao.findById(id).orElse(null);
	}

	@Override
	public List<Report> findReportByPropertyId(Long id) {
		// TODO Auto-generated method stub
		return reportDao.fingByProperty(id);
	}

}
