package com.hewe.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hewe.domain.FileModel;
import com.hewe.domain.UserModel;
import com.hewe.service.IFileService;
import com.hewe.util.model.Page;

@Controller
@RequestMapping(path = "/client")
public class ClientController {

	private static final Logger log = Logger.getLogger(ClientController.class);

	@Resource(name = "fileService")
	private IFileService fileService;

	@RequestMapping(path = "/myFiles", method = RequestMethod.GET)
	public String currentUserFile(@RequestParam("pageIndex") String pageIndex, ModelMap map) {
		log.debug("currentUserFile excute");
		fileService.getPageDataFile(null, null);

		return "currentUserFile";
	}

	@RequestMapping(path = "/showFile", method = RequestMethod.GET)
	public String allFile(@RequestParam("pageIndex") String pageIndex, ModelMap map) {
		log.debug("allfile");
		Page page = null;
		if (pageIndex == null || pageIndex.trim().equals("0")) {
			page = fileService.getPageDataFile(null);
		} else {
			page = fileService.getPageDataFile(pageIndex);
		}
		List<FileModel> list = page.getList();
		if (list != null) {
			for (FileModel file : list) {
				System.out.println(file.getName());
			}
		}
		map.put("filePage", page);

		return "client_showFile";
	}

}
