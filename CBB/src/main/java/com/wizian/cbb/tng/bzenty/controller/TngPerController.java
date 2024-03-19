package com.wizian.cbb.tng.bzenty.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wizian.cbb.tng.bzenty.service.ITngPerService;
import com.wizian.cbb.tng.stdnt.model.StdntVO;

@RestController
public class TngPerController {

	@Autowired
	ITngPerService tngPerService;

	@PostMapping("/tng/perStdnt")
	public @ResponseBody List<StdntVO> perStdnt(@RequestBody String tngData) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, String> tngMap = objectMapper.readValue(tngData, new TypeReference<Map<String, String>>() {
			});
			String tngNo = tngMap.get("tngNo");
			List<StdntVO> stdntList = tngPerService.selectTngStdntList(tngNo);
			return stdntList;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@PostMapping("/tng/getScsbjt")
	public List<Map<String, String>> getScsbjt() {
		List<Map<String, String>> scsbjtList = tngPerService.selectScsbjt();
		return scsbjtList;
	}

	@PostMapping("/tng/stdntStts")
	public @ResponseBody List<Map<String, Object>> stdntStts() {
		List<Map<String, Object>> sttsList = tngPerService.stdntPrgrsStts();
		return sttsList;
	}
}
