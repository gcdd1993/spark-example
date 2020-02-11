package provinceflow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.HashMap;
import java.util.Map;

/**
 * 将统计结果按照手机归属地不同省份输出到不同文件中
 *
 * @author gaochen
 * @date 2020/2/9
 */
public class ProvincePartitioner extends Partitioner<Text, FlowBean> {

    /**
     * 归属地映射，从外部获取
     */
    private static Map<String, Integer> provinceDict = new HashMap<>(256);

    static {
        provinceDict.put("138", 0);
        provinceDict.put("137", 1);
        provinceDict.put("136", 2);
        provinceDict.put("135", 3);
    }

    /**
     * 重写partitioner，让相同归属地的号码返回相同的分区号int
     */
    @Override
    public int getPartition(Text text, FlowBean flowBean, int numPartitions) {
        String telephoneNumberHead = text.toString().substring(0, 3);
        return provinceDict.getOrDefault(telephoneNumberHead, 4);
    }
}
