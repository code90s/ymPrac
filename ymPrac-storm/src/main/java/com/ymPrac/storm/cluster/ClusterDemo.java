package com.ymPrac.storm.cluster;


import java.util.Map;

import backtype.storm.Config;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

/**
 * 集群demo
 * Created by Yan Meng on 2017/7/24.
 */
public class ClusterDemo {

    public static class ClusterSpout extends BaseRichSpout {

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
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("error");
            }
        }

        @Override
        public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
            outputFieldsDeclarer.declare(new Fields("count"));
        }
    }

    public static class ClusterBolt extends BaseRichBolt {

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


    public static void main(String[] args) {
        TopologyBuilder builder = new TopologyBuilder();
        // 设置 task 数量
        builder.setSpout("number_spout", new ClusterSpout()).setNumTasks(2);
        // 设置线程数
        builder.setBolt("number_bolt", new ClusterBolt(), 2).shuffleGrouping("number_spout");

        try {
            Config config = new Config();
            // 设置work数量
            config.setNumWorkers(2);
            StormSubmitter.submitTopology("Clustertopology", config, builder.createTopology());
        } catch (AlreadyAliveException e) {
            e.printStackTrace();
        } catch (InvalidTopologyException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
