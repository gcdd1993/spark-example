package mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;

import java.io.IOException;

/**
 * 相当于一个yarn集群的客户端
 * 需要在此封装我们的mr程序的相关运行参数，指定jar包
 * 最后提交给yarn
 *
 * @author gaochen
 * @date 2020/2/9
 */
public class WordcountDriver {

    private static final String HADOOP_HOSTNAME = "hdfs://shizhan01:9000";

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args == null || args.length == 0) {
            args = new String[2];
            args[0] = HADOOP_HOSTNAME + "/wordcount/input/cron.log";
            args[1] = HADOOP_HOSTNAME + "/wordcount/output8";
        }

        Configuration conf = new Configuration();
        //设置的没有用!  ??????
        conf.set("HADOOP_USER_NAME", "hadoop");
        conf.set("dfs.permissions.enabled", "false");

        conf.set("mapreduce.framework.name", "yarn");
        conf.set("yarn.resoucemanager.hostname", "shizhan01");
        JobConf jobConf = new JobConf(new Configuration());
        //指定job的输入原始文件所在目录
        FileInputFormat.setInputPaths(jobConf, new Path(args[0]));
        //指定job的输出结果所在目录
        FileOutputFormat.setOutputPath(jobConf, new Path(args[1]));

        Job job = Job.getInstance(jobConf);
        /*job.setJar("/home/hadoop/wc.jar");*/
        //指定本程序的jar包所在的本地路径
        job.setJarByClass(WordcountDriver.class);

        //指定本业务job要使用的mapper/Reducer业务类
        job.setMapperClass(WordcountMapper.class);
        job.setReducerClass(WordcountReducer.class);

        //指定mapper输出数据的kv类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        //指定最终输出的数据的kv类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //将job中配置的相关参数，以及job所用的java类所在的jar包，提交给yarn去运行
        /*job.submit();*/
        boolean res = job.waitForCompletion(true);
        System.exit(res ? 0 : 1);
    }
}
