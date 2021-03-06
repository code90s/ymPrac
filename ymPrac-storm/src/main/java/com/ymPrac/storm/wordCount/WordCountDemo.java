package com.ymPrac.storm.wordCount;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
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
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单词技术
 * Created by Yan Meng on 2017/7/23.
 */
public class WordCountDemo {

    public static class WCSpout extends BaseRichSpout {

        private Map map;
        private TopologyContext topologyContext;
        private SpoutOutputCollector spoutOutputCollector;
        @Override
        public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
            this.map = map;
            this.topologyContext = topologyContext;
            this.spoutOutputCollector = spoutOutputCollector;
        }

        @Override
        public void nextTuple() {
            Collection<File> files = FileUtils.listFiles(new File("/"), new String[]{}, true);
            for (File file : files) {
                try {
                    List<String> lines = FileUtils.readLines(file);
                    for (String line : lines) {
                        this.spoutOutputCollector.emit(new Values(line));
                    }
                    // 文件重命名，防止重复读取
                    FileUtils.moveFile(file, new File(file.getAbsolutePath()+System.currentTimeMillis()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
            outputFieldsDeclarer.declare(new Fields("line"));
        }
    }

    public static class WCSplitBolt extends BaseRichBolt {

        private Map map;
        private TopologyContext topologyContext;
        private OutputCollector outputCollector;
        @Override
        public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
            this.map = map;
            this.topologyContext = topologyContext;
            this.outputCollector = outputCollector;
        }

        @Override
        public void execute(Tuple tuple) {
            String line = tuple.getStringByField("line");
            String[] words = line.split("\t");
            for (String word : words) {
                this.outputCollector.emit(new Values(word));
            }
        }

        @Override
        public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
            outputFieldsDeclarer.declare(new Fields("word"));
        }
    }

    public static class WCCountBolt extends BaseRichBolt {

        private Map map;
        private TopologyContext topologyContext;
        private OutputCollector outputCollector;
        @Override
        public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
            this.map = map;
            this.topologyContext = topologyContext;
            this.outputCollector = outputCollector;
        }

        Map<String, Integer> wordCount = new HashMap<>();
        @Override
        public void execute(Tuple tuple) {
            String word = tuple.getStringByField("word");
            Integer count = wordCount.get(word);
            if (count == null) {
                count  = 0;
                wordCount.put(word, count);
            }
            count++;

            for (String w : wordCount.keySet()) {
                System.out.print(w + ": " + count);
            }
            System.out.println();
        }

        @Override
        public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

        }
    }

    public static void main(String[] args) {
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("wc_spout", new WCSpout());
        builder.setBolt("split_bolt", new WCSplitBolt()).shuffleGrouping("wc_spout");
        builder.setBolt("count_bolt", new WCCountBolt()).shuffleGrouping("split_bolt");

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("wc_topology", new Config(), builder.createTopology());


    }


}
