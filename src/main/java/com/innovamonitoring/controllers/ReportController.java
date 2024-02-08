package com.innovamonitoring.controllers;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovamonitoring.models.entity.Camera;
import com.innovamonitoring.models.entity.Report;

import com.innovamonitoring.models.services.IReportService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ReportController {
	
	
	@Autowired
	private IReportService reportService;
	
	@GetMapping("/reports")
	public List<Report> index (){
		return reportService.findAll();
	}
	@GetMapping("/reports/property/{id}")
	public List<Report> index (@PathVariable Long id){
		return reportService.findReportByPropertyId(id);
	}
	
	
	
	@GetMapping("/reports/{id}")
	public ResponseEntity<?> show (@PathVariable Long id){
		
		Report report = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			report = reportService.findById(id);
			
		} catch (DataAccessException e) {
			response.put("message", "Error when querying the database: ");
			response.put("error",e.getMessage().concat(e.getMostSpecificCause().getMessage()));
		}
		
	    if (report == null) {
            response.put("message", "The report ID: ".concat(id.toString().concat(" does not exist in the database!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Report>(report, HttpStatus.OK);
	}

	@PostMapping("/reports")
	public ResponseEntity<?> create(@RequestBody Report report) {
		try {
			Report reportSaved = reportService.save(report);
			return new ResponseEntity<Report>(reportSaved, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/reports/{id}")
	public ResponseEntity<?> update(@RequestBody Report report, @PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		Report actualReport = reportService.findById(id);
		Report reportUpdated;

		if (actualReport == null) {
			response.put("message", "Error: no se pudo editar, el reporte ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			actualReport.setCompany(report.getCompany());
			actualReport.setDateOfReport(report.getDateOfReport());
			actualReport.setTimeOfReport(report.getTimeOfReport());
			actualReport.setLevel(report.getLevel());
			actualReport.setNumerCase(report.getNumerCase());
			actualReport.setPdf(report.getPdf());
			actualReport.setVerified(report.isVerified());
			actualReport.setAgent(report.getAgent());
			actualReport.setCaseType(report.getCaseType());
			actualReport.setProperty(report.getProperty());
			actualReport.setPoliceFirstResponderNotified(report.isPoliceFirstResponderNotified());
			actualReport.setPoliceFirstResponderScene(report.getPoliceFirstResponderScene());
			actualReport.setSecurityGuardsNotified(report.getSecurityGuardsNotified());
			actualReport.setPoliceFirstResponderScene(report.getSecurityGuardsScene());
			actualReport.setEmailedReport(report.getEmailedReport());

			reportUpdated = reportService.save(actualReport);

			return new ResponseEntity<Report>(reportUpdated, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("message", "Error al actualizar el reporte en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("reports/{id}")
	public void delete(@PathVariable Long id) {
		
		reportService.delete(id);
	} 
	
}
