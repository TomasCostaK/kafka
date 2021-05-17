#!/bin/bash

kafka_home="kafka_scripts"
broker_home="properties/servers"
properties_home="properties"
num_brokers=6

# Starting zookeper and one broker
$kafka_home/bin/zookeeper-server-start.sh $properties_home/zookeeper.properties >logs/zookeeper.out 2>&1 &

for i in {0..5}
do
    sleep 5
    $kafka_home/bin/kafka-server-start.sh $broker_home/server$i.properties >logs/server$i.out 2>&1 &
    printf "Started kafka broker: $i\n"
done

sleep 20

# Creating topic
$kafka_home/bin/kafka-topics.sh --create --topic Sensor --replication-factor 3 --partitions 6 --config min.insync.replicas=2 --bootstrap-server localhost:9092 2>&1 &
printf "Created Sensor topic\n"

# TODO
# Iterate over num_brokers and create server for each serverX.properties
# Have getopts or different scripts for starting, creating and maybe exiting gracefully