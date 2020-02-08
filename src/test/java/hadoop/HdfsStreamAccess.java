package hadoop;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * 用流的方式来操作hdfs上的文件
 * 可以实现读取指定偏移量范围的数据
 *
 * @author gaochen
 * @date 2020/2/8
 */
public class HdfsStreamAccess {

    private FileSystem fs = null;

    @Before
    public void init() throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        conf.set("dfs.replication", "3");

        //拿到一个文件系统操作的客户端实例对象
        fs = FileSystem.get(conf);
        //可以直接传入 uri和用户身份
        fs = FileSystem.get(new URI("hdfs://shizhan01:9000"), conf, "hadoop");

        System.setProperty("hadoop.home.dir", "D:\\DevTools\\hadoop-2.9.2");
    }

    /**
     * 通过流的方式上传文件到hdfs
     *
     * @throws Exception
     */
    @Test
    public void testUpload() throws Exception {
        FSDataOutputStream outputStream = fs.create(new Path("/cron.log.copy1"), true);
        FileInputStream inputStream = new FileInputStream("C:\\Users\\13983\\Desktop\\cron.log");

        IOUtils.copy(inputStream, outputStream);
    }

    /**
     * 通过流的方式获取hdfs上数据
     *
     * @throws Exception
     */
    @Test
    public void testDownLoad() throws Exception {
        FSDataInputStream inputStream = fs.open(new Path("/cron.log.copy1"));
        FileOutputStream outputStream = new FileOutputStream("D:/cron.log");

        IOUtils.copy(inputStream, outputStream);
    }

    @Test
    public void testRandomAccess() throws Exception{
        FSDataInputStream inputStream = fs.open(new Path("/cron.log.copy1"));
        inputStream.seek(12);
        FileOutputStream outputStream = new FileOutputStream("D:/cron.log.part2");

        IOUtils.copy(inputStream, outputStream);
    }

    /**
     * 显示hdfs上文件的内容
     */
    @Test
    public void testCat() throws IllegalArgumentException, IOException{
        FSDataInputStream in = fs.open(new Path("/cron.log.copy1"));
        IOUtils.copy(in, System.out);
//		IOUtils.copyBytes(in, System.out, 1024);
    }

}
