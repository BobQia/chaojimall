package com.swiet;

import java.util.UUID;

/**
 * @author DengQiao
 * @date 2023-5-28 0028
 */
public class TestFile {

    private static final int FILE_LENGTH = 10;

    //public static void main(String[] args) {
    //    File file = new File("C:\\Users\\DengQiao\\Desktop\\新建文件夹");
    //    if (file.isDirectory()) {
    //        for (File listFile : file.listFiles()) {
    //            if (listFile.isDirectory()) {
    //                String path = listFile.getPath();
    //                String name = listFile.getName();
    //                Random random = new Random();
    //                StringBuilder sb = new StringBuilder();
    //                for (int j = 0; j < 20; j++) {
    //                    for (int i = 0; i < FILE_LENGTH; i++) {
    //                        sb.append((char) (random.nextInt(26) + 'a'));
    //                    }
    //
    //                    try {
    //                        File filew = new File(path + "\\" +name+ "文章---" + random.nextInt(10)+".txt");
    //                        FileWriter writer = new FileWriter(filew);
    //                        writer.write(sb.toString());
    //                        writer.close();
    //                    } catch (IOException e) {
    //                        e.printStackTrace();
    //                    }
    //                }
    //
    //            }
    //        }
    //
    //    }
    //}

//    public static void main(String[] args) throws IOException {
//        File file = new File("C:\\Users\\DengQiao\\Desktop\\新建文件夹.zip");
//        FileInputStream fileInputStream = new FileInputStream(file);
//
//        //获取ZIP输入流(一定要指定字符集Charset.forName("GBK")否则会报java.lang.IllegalArgumentException: MALFORMED)
//        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream), StandardCharsets.UTF_8);
//        //定义ZipEntry置为null,避免由于重复调用zipInputStream.getNextEntry造成的不必要的问题
//        ZipEntry ze = null;
//
////循环遍历
//        while ((ze = zipInputStream.getNextEntry()) != null) {
//
//            System.out.println("文件名：" + ze.getName() + " 文件大小：" + ze.getSize() + " bytes");
//            System.out.println("文件内容：");
//
//            //读取
//            BufferedReader br = new BufferedReader(new InputStreamReader(zipInputStream, Charset.forName("GBK")));
//
//            String line;
//
//            //内容不为空，输出
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
//
//        //一定记得关闭流
//        zipInputStream.closeEntry();
//
//    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }

}
