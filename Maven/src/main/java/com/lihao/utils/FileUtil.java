package com.lihao.utils;

import com.lihao.exception.Wrong;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class FileUtil {
    public static String[] fileBookLoad(MultipartFile file,String path){
        String name = file.getOriginalFilename();
        InputStream in;
        String filename;
        try {
            in = file.getInputStream();
            File file1 = new File(path);
            if (!file1.exists()) {
                file1.mkdirs();
            }
            filename = UUID.randomUUID() + name.substring(name.lastIndexOf("."));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
            byte[] bytes = new byte[1024 * 100];
            int readCount = 0;
            while ((readCount = in.read(bytes)) != -1) {
                out.write(bytes, 0, readCount);
            }
            out.flush();
            in.close();
            out.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);

        }
        String []ss = new String[2];
        int startIndex = path.indexOf("/static");
        String result = path.substring(startIndex);
        ss[0]=StringUtil.getUri()+result+"/"+filename;
        ss[1]=path+"/"+filename;
        return ss;
    }
    public static boolean removeFile(String filePath) throws Wrong {
        File file = new File(filePath);
        if(file.exists() && file.isFile()){
            if(file.delete()){
                System.out.println("文件成功删除！");
                return true;
            }else{
                throw new Wrong("文件处理失败！");
            }
        }else{
            throw new Wrong("文件不存在！");
        }
    }
}
