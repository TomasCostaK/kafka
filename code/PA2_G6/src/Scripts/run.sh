#!/bin/bash

kafka_home="kafka_scripts/"
broker_home="properties/servers/"
properties_home="properties/"
num_brokers=6

# Starting zookeper and one broker
$kafka_home/bin/zookeper-server-start.sh $properties_home/zookeper.properties >logs/zookeper.out
$kafka_home/bin/kafka-server-start.sh $server_properties/server0.properties >logs/server0.out
printf "Started zookeper\n"

sleep 10

# Creating topic
$kafka_home/bin/kafka-topics.sh --create --topic Sensor --replication-factor 3 --partitions 6 --config min.insync.replicas=2 --bootstrap-server localhost:9092
printf "Created Sensor topic\n"

# TODO
# Iterate over num_brokers and create server for each serverX.properties
# Have getopts or different scripts for starting, creating and maybe exiting gracefully