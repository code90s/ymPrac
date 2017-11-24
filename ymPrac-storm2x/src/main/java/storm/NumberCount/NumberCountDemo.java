package storm.NumberCount;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.Map;

/**
 * 计数器
 * Created by Yan Meng on 2017/7/23.
 */
public class NumberCountDemo {

    public static class NumberSpout extends BaseRichSpout {

        private Map map;
        private TopologyContext topologyContext;
        private SpoutOutputCollector spoutOutputCollector;
        @Override
        public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
            this.map = map;
            this.topologyContext = topologyContext;
            this.spoutOutputCollector = spoutOutputCollector;
        }

        int count = 0;
        @Override
        public void nextTuple() {
            this.spoutOutputCollector.emit(new Values(count ++));
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("error");
//            }
        }

        @Override
        public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
            outputFieldsDeclarer.declare(new Fields("count"));
        }
    }

    public static class NumberBolt extends BaseRichBolt {

        private Map map;
        private TopologyContext topologyContext;
        private OutputCollector outputCollector;
        @Override
        public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
            this.map = map;
            this.topologyContext = topologyContext;
            this.outputCollector = outputCollector;
        }

        int sum = 0;
        @Override
        public void execute(Tuple tuple) {
            Integer count = tuple.getIntegerByField("count");
            sum += count;
            System.out.println(sum);
        }

        @Override
        public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

        }
    }


    public static void main(String[] args) throws Exception {
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("number_spout", new NumberSpout());
        builder.setBolt("number_bolt", new NumberBolt()).shuffleGrouping("number_spout");

        LocalCluster localCluster = new LocalCluster();
        localCluster.submitTopology("number_topology", new Config(), builder.createTopology());

    }
}
