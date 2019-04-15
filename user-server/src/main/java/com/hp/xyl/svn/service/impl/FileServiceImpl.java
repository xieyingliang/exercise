package com.hp.xyl.svn.service.impl;

import com.hp.xyl.svn.entity.User;
import com.hp.xyl.svn.service.FileService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Author:xyl
 * Date:2019/2/21 16:32
 * Description:
 */
@Service
public class FileServiceImpl implements FileService {
    private void addFile(User user) throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\user.txt");
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write((user.toString()).getBytes());
        outputStream.close();
    }

    @EventListener
    @Async
    public void addUserFile(User user) throws IOException {
        addFile(user);
    }
}
