package com.hp.xyl.svn.controller;

import com.hp.xyl.svn.model.ResultModel;
import com.hp.xyl.svn.utils.StringUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Past;
import java.io.*;

/**
 * Author:xyl
 * Date:2019/3/19 15:55
 * Description:
 */
@Slf4j
@Api(description = "图片上传接口")
@RestController
@RequestMapping("/file")
public class FileController {
    /**
     * 上传文件到FastDFS
     *
     * @param file
     */
    @RequestMapping(value = "/fastDFSUpload", method = RequestMethod.POST)
    public ResultModel<String> fastDFSUpload(MultipartFile file) throws IOException, MyException {
        ResultModel<String> resultModel = new ResultModel<>();
        String extName = file.getOriginalFilename().split("\\.")[1];
        String fileName = file.getOriginalFilename().split("\\.")[0];
        byte[] bytes = file.getBytes();
        String videoPath = uploadFile(bytes, extName);
        resultModel.setData(videoPath);
        return resultModel;
    }

    @GetMapping(value = "/download")
    public ResponseEntity<InputStreamResource> download(String filePath, HttpServletResponse response) throws IOException, MyException {
        ClientGlobal.initByProperties("application.properties");
        // 链接FastDFS服务器，创建tracker和Stroage
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        String storageServerIp = getStorageServerIp(trackerClient, trackerServer);
        StorageServer storageServer = getStorageServer(storageServerIp);
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        byte[] b = storageClient.download_file("group1", filePath);
        if (b == null) {
            throw new IOException("文件" + filePath + "不存在");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"","test"));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity.ok().headers(headers).contentLength(b.length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(new ByteArrayInputStream(b)));
    }

    /**
     * FastDFS实现文件下载
     *
     * @param filePath
     */
    @RequestMapping(value = "/fastDFSDownload", method = RequestMethod.GET)
    public ResponseEntity<ResultModel> fastDFSDownload(String filePath, HttpServletResponse response) throws IOException, MyException {
        ResultModel<Object> resultModel = new ResultModel<>();
        ClientGlobal.initByProperties("application.properties");
        // 链接FastDFS服务器，创建tracker和Stroage
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        String storageServerIp = getStorageServerIp(trackerClient, trackerServer);
        StorageServer storageServer = getStorageServer(storageServerIp);
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        byte[] b = storageClient.download_file("group1", filePath);
        if (b == null) {
            throw new IOException("文件" + filePath + "不存在");
        }
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        // 设置强制下载不打开
        response.setContentType("application/force-download");
        // 设置文件名
        response.addHeader("Content-Disposition", "attachment;fileName=" + "测试");
        //也可以明确的设置一下UTF-8，测试中不设置也可以。
        response.setContentType("multipart/form-data;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fileName.getBytes("GB2312"), "ISO-8859-1"));
        try (OutputStream os = response.getOutputStream()) {
            IOUtils.write(b, os);
            log.info("下载成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(resultModel);
    }

    /**
     * FastDFS获取将上传文件信息
     */
    @RequestMapping(value = "/fastDFSGetFileInfo", method = RequestMethod.GET)
    public void fastDFSGetFileInfo(String filePath) {
        try {
            // 链接FastDFS服务器，创建tracker和Stroage
            ClientGlobal.initByProperties("application.properties");
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();

            String storageServerIp = getStorageServerIp(trackerClient, trackerServer);
            StorageServer storageServer = getStorageServer(storageServerIp);
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);

            FileInfo fi = storageClient.get_file_info("group1", filePath);
            if (fi == null) {
                throw new IOException("文件" + filePath + "不存在");
            }

            log.debug("文件信息=" + fi.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * FastDFS获取文件名称
     */
    @RequestMapping(value = "/fastDFSGetFileName", method = RequestMethod.GET)
    public void fastDFSGetFileName(String filePath) {
        try {
            // 链接FastDFS服务器，创建tracker和Stroage
            ClientGlobal.initByProperties("application.properties");
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();

            String storageServerIp = getStorageServerIp(trackerClient, trackerServer);
            StorageServer storageServer = getStorageServer(storageServerIp);
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);

            NameValuePair[] nvps = storageClient.get_metadata("group1", filePath);
            if (nvps == null) {
                throw new IOException("文件" + filePath + "不存在");
            }

            log.debug(nvps[0].getName() + "." + nvps[0].getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * FastDFS实现删除文件
     */
    @RequestMapping(value = "/fastDFSDelete", method = RequestMethod.GET)
    public void fastDFSDelete(String filePath) {
        try {
            // 链接FastDFS服务器，创建tracker和Stroage
            ClientGlobal.initByProperties("application.properties");
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();

            String storageServerIp = getStorageServerIp(trackerClient, trackerServer);
            StorageServer storageServer = getStorageServer(storageServerIp);
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);

            int i = storageClient.delete_file("group1", filePath);
            log.debug(i == 0 ? "删除成功" : "删除失败:" + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String uploadFile(byte[] byteFile, String extFile) throws MyException, IOException {
        // 拼接服务区的文件路径
        StringBuffer sbPath = new StringBuffer();
        sbPath.append("http://192.168.30.132");
        // 初始化文件资源
        ClientGlobal.initByProperties("application.properties");
        // 链接FastDFS服务器，创建tracker和Stroage
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        String storageServerIp = getStorageServerIp(trackerClient, trackerServer);
        StorageServer storageServer = getStorageServer(storageServerIp);
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        String[] strings = storageClient.upload_file(byteFile, extFile, null);
        if (!ArrayUtils.isEmpty(strings)) {
            sbPath.append(StringUtil.join("/", strings));
        }
        log.info("上传路径=" + sbPath.toString());
        return sbPath.toString();
    }

    /**
     * 得到Storage服务
     *
     * @param storageIp
     * @return 返回Storage服务
     */
    private static StorageServer getStorageServer(String storageIp) {
        StorageServer storageServer = null;
        if (storageIp != null && !("").equals(storageIp)) {
            try {
                // ip port store_path下标
                storageServer = new StorageServer(storageIp, 23000, 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("——storage server生成");
        return storageServer;
    }

    /**
     * 获得可用的storage IP
     *
     * @param trackerClient
     * @param trackerServer
     * @return 返回storage IP
     */
    private static String getStorageServerIp(TrackerClient trackerClient, TrackerServer trackerServer) {
        String storageIp = null;
        if (trackerClient != null && trackerServer != null) {
            try {
                StorageServer storageServer = trackerClient.getStoreStorage(trackerServer, "group1");
                storageIp = storageServer.getSocket().getInetAddress().getHostAddress();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("——获取组中可用的storage IP——" + storageIp);
        return storageIp;
    }
}
