package com.spnotes.storm.spouts;


import com.spnotes.storm.spouts.LineReaderSpout;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;

public class HelloStorm {

	public static void main(String[] args) throws Exception{
		Config config = new Config();
		config.put("inputFile", args[0]);
		config.setDebug(true);
		config.put(Config.TOPOLOGY_MAX_SPOUT_PENDING, 1);
		
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("line-reader-spout", new LineReaderSpout());
		builder.setBolt("word-spitter", new WordSpitterBolt()).shuffleGrouping("line-reader-spout");
		builder.setBolt("word-counter", new WordCounterBolt()).shuffleGrouping("word-spitter");
		
		//LocalCluster cluster = new LocalCluster();
		//cluster.submitTopology("HelloStorm", config, builder.createTopology());
		
		StormSubmitter.submitTopology("HelloStorm", config, builder.createTopology()); // This is for production env

		Thread.sleep(10000);
		
		//cluster.shutdown(); // This is only for local cluster
	}

}