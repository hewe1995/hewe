package com.hewe.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hewe.domain.FileModel;
import com.hewe.domain.UserModel;
import com.hewe.service.IFileService;
import com.hewe.util.model.WebUtil;

@Controller
@RequestMapping(path = "/file")
public class FileController {
	@Resource(name = "fileService")
	private IFileService fileService;

	@RequestMapping(path = "/upload", method = RequestMethod.GET)
	public String uploadFileView() {

		return "uploadFile";
	}

	@RequestMapping(path = "/upload", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file1") MultipartFile file1, HttpServletRequest request, ModelMap map) {

		UserModel user = (UserModel) request.getSession().getAttribute("user");

		if (user == null) {
			map.put("message", "请先<a href='login'>登录</a>");
			return "message";
		}

		String path = request.getSession().getServletContext().getRealPath("/");
		String rootPath = path.substring(0, path.lastIndexOf("apache-tomcat-8.5.5")) + "savefile";
		System.out.println(rootPath);
		String fileName = file1.getOriginalFilename();
		String saveName = WebUtil.makeFileName(fileName);
		String savePath = WebUtil.makePath(saveName, rootPath);
		File saveFile = new File(savePath, saveName);
		if (!saveFile.exists()) {
			saveFile.mkdirs();
		}
		try {

			file1.transferTo(saveFile);
			// 保存到表中
			FileModel fileModel = new FileModel(WebUtil.makeId(), fileName, savePath, new Date(), 0, user, saveName);
			fileService.add(fileModel);
			map.put("message", "success");
		} catch (Exception e) {
			map.put("message", "error");
			e.printStackTrace();
		}

		return "success";
	}

	@RequestMapping(path = "/download", method = RequestMethod.GET)
	public ResponseEntity download(@RequestParam("id") String id, ModelMap map) {
		ResponseEntity<byte[]> entity;

		if (id.trim().equals("")) {
			return new ResponseEntity<String>("please choose what file you want", HttpStatus.OK);
		}
		FileModel fileModel = fileService.find(id);
		if (fileModel == null) {
			return new ResponseEntity<String>("source not found", HttpStatus.OK);
		}
		String path = fileModel.getPath() + "\\" + fileModel.getSaveName();
		System.out.println(path);
		File file = new File(path);
		if (!file.exists()) {
			return new ResponseEntity<String>("source not found", HttpStatus.OK);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		System.out.println(fileModel.getName());
		String fileName = "";
		try {
			fileName = new String(fileModel.getName().getBytes("UTF-8"), "iso-8859-1");
		} catch (UnsupportedEncodingException e1) {

			e1.printStackTrace();
		}
		headers.setContentDispositionFormData("attachment", fileName);
		try {
			entity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
			fileModel.setDowntimes(fileModel.getDowntimes() + 1);
			fileService.update(fileModel);
		} catch (IOException e) {
			return new ResponseEntity<String>("source not found", HttpStatus.OK);
		}
		System.out.println("准备下载");
		return entity;
	}
}
