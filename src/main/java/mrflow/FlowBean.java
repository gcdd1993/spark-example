package mrflow;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * TODO
 *
 * @author gaochen
 * @date 2020/2/9
 */
public class FlowBean implements Writable {

    /**
     * 总上行流量
     */
    private long upFlow;

    /**
     * 下行流量
     */
    private long dFlow;

    /**
     * 总流量
     */
    private long sumFlow;

    public FlowBean(long upFlow, long dFlow) {
        this.upFlow = upFlow;
        this.dFlow = dFlow;
        this.sumFlow = upFlow + dFlow;
    }

    /**
     * 反序列化时，需要反射调用空参构造函数，所以要显示定义一个
     */
    public FlowBean() {
    }

    /**
     * 序列化方法
     */
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(upFlow);
        dataOutput.writeLong(dFlow);
        dataOutput.writeLong(sumFlow);
    }

    /**
     * 反序列化方法
     * 注意：反序列化的顺序跟序列化的顺序完全一致
     */
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.upFlow = dataInput.readLong();
        this.dFlow = dataInput.readLong();
        this.sumFlow = dataInput.readLong();
    }

    public long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(long upFlow) {
        this.upFlow = upFlow;
    }

    public long getdFlow() {
        return dFlow;
    }

    public void setdFlow(long dFlow) {
        this.dFlow = dFlow;
    }

    public long getSumFlow() {
        return sumFlow;
    }

    public void setSumFlow(long sumFlow) {
        this.sumFlow = sumFlow;
    }

    @Override
    public String toString() {
        return "FlowBean{" +
                "upFlow=" + upFlow +
                ", dFlow=" + dFlow +
                ", sumFlow=" + sumFlow +
                '}';
    }
}
