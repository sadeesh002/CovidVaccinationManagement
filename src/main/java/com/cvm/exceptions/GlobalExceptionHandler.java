package com.cvm.exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cvm.responses.ErrorInfo;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String, String>> HandleException(MethodArgumentNotValidException te) {
//		Map<String, String> errorMap = new LinkedHashMap<>();
//		List<FieldError> list = te.getFieldErrors();
//		for (FieldError f : list) {
//			String fieldName = f.getField();
//			String errorMsg = f.getDefaultMessage();
//			errorMap.put(fieldName, errorMsg);
//		}
//		ResponseEntity<Map<String, String>> rEntity = new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
//		return rEntity;
//	}
	
	
	@ExceptionHandler(AdminsIdNotFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(AdminsIdNotFoundException ex, HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}
	@ExceptionHandler(NoAdminsFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(NoAdminsFoundException ex, HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}
	
	@ExceptionHandler(MedicalStaffIdNotFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(MedicalStaffIdNotFoundException ex, HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}
	@ExceptionHandler(NoMedicalStaffFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(NoMedicalStaffFoundException ex, HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}
	
	@ExceptionHandler(EmployeessIdNotFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(EmployeessIdNotFoundException ex, HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}
	@ExceptionHandler(NoEmployeesFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(NoEmployeesFoundException ex, HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}
	
	@ExceptionHandler(SlotIdNotFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(SlotIdNotFoundException ex, HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}
	@ExceptionHandler(NoSlotsFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(NoSlotsFoundException ex, HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}
	
	@ExceptionHandler(VitalIdNotFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(VitalIdNotFoundException ex, HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}
	@ExceptionHandler(NoVitalsFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(NoVitalsFoundException ex, HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}
	
	@ExceptionHandler(EmailIdNotFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(EmailIdNotFoundException ex, HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}

	
	@ExceptionHandler(CertificatesIdNotFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(CertificatesIdNotFoundException ex, HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}
	@ExceptionHandler(NoCertificatesFoundException.class)
	public ResponseEntity<ErrorInfo> handlingException(NoCertificatesFoundException ex, HttpServletRequest request) {
		String msg = ex.getMessage();
		ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.NOT_FOUND.name(), msg, request.getRequestURI());
		ResponseEntity<ErrorInfo> rEntity = new ResponseEntity<ErrorInfo>(eInfo, HttpStatus.NOT_FOUND);
		return rEntity;
	}

}
