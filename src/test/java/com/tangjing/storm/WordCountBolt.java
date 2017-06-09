//package com.tangjing.storm;
//
//import org.apache.storm.task.OutputCollector;
//import org.apache.storm.task.TopologyContext;
//import org.apache.storm.topology.OutputFieldsDeclarer;
//import org.apache.storm.topology.base.BaseRichBolt;
//import org.apache.storm.tuple.Fields;
//import org.apache.storm.tuple.Tuple;
//import org.apache.storm.tuple.Values;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Describe:
// * User:tangjing
// * Date:2017/6/4
// * Time:下午12:24
// */
//public class WordCountBolt extends BaseRichBolt {
//    private OutputCollector collector;
//    private HashMap<String, Long> counts = null;
//
//    public void prepare(Map config, TopologyContext context, OutputCollector collector) {
//        this.collector = collector;
//        this.counts = new HashMap<String, Long>();
//    }
//
//    public void execute(Tuple tuple) {
//        String word  = tuple.getStringByField("word");
//        Long   count = this.counts.get(word);
//        if (count == null) {
//            count = 0L;
//        }
//        count++;
//        this.counts.put(word, count);
//        this.collector.emit(new Values(word, count));
//    }
//
//    public void declareOutputFields(OutputFieldsDeclarer declarer) {
//        declarer.declare(new Fields("word", "count"));
//    }
//}