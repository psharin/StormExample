


1. Download apache-storm-0.9.4 from net and extract zip file to folder
2. change the following enties in storm.yaml file

	storm.zookeeper.servers:
 		- "localhost"
 	nimbus.host: "localhost"

3. go to bin folder and run the below commands in the same order
	a)  ./storm dev-zookeeper
	b) ./storm nimbus
	c) ./storm supervisor
	d) ./storm ui
	
4. Compile spouts and bolts project and run either one of the below way

	a) run below one from storm/bin folder
		./storm jar /Users/puchaka/Sree/Apple/workspace/storm/target/storm-word-count.jar com.spnotes.storm.spouts.HelloStorm ~/Sree/Tools/Cassandra/Notes.txt
		
	b) run below from anywhere
		java -cp /Users/puchaka/Sree/Apple/workspace/storm/target/storm-word-count-jar-with-dependencies.jar com.spnotes.storm.spouts.HelloStorm ~/Sree/Tools/Cassandra/Notes.txt

5. Note that LocalCluster topology will not be reflected  the data in UI. You should use StormSubmitter topology to see the details in UI

6. UI can be accessed as http://localhost:8080
