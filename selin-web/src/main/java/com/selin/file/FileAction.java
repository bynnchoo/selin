package com.selin.file;

import org.roof.fileupload.api.FileInfo;
import org.roof.fileupload.api.FileManager;
import org.roof.spring.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhenglt on 2017/8/13.
 */
@Controller
@RequestMapping("selin/fileAction")
public class FileAction {

    private FileManager fileManager;


    @RequestMapping("/uploadFile")
    @ResponseBody
    public Result uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        Map<String, Object> xdata = new HashMap<String, Object>();
        xdata.put("displayName", file.getOriginalFilename());
        xdata.put("fileSize", file.getSize());
        xdata.put("ContentType", file.getContentType());
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(file.getBytes());
            FileInfo fileinfo = fileManager.saveFile(in, xdata);
            return new Result(Result.SUCCESS,fileinfo.getName());
        } catch (Exception e) {
            return new Result(Result.FAIL,"上传失败");
        }
    }

    @RequestMapping("/getFile")
    public synchronized void getFile(String filename, HttpServletResponse response, HttpServletRequest request) {
        InputStream in = fileManager.getFile(filename);
        response.setContentType("image/png");
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            byte[] buf = new byte[1024];
            while (in.read(buf) != -1) {
                out.write(buf);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (out != null){
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Autowired(required = true)
    public void setFileManager(@Qualifier("simpleFileManager") FileManager fileManager) {
        this.fileManager = fileManager;
    }

}
