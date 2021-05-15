#!/bin/bash

kafka_home="kafka_scripts"
broker_home="properties/servers"
properties_home="properties"
num_brokers=6

# Starting zookeper and one broker
$kafka_home/bin/kafka-server-stop.sh  >logs/servers_ending.out 2>&1 &
sleep 25
$kafka_home/bin/zookeeper-server-stop.sh  >logs/zookeeper_ending.out 2>&1 &
printf "Ended Kafka Service gracefully\n"

# TODO
# Iterate over num_brokers and create server for each serverX.properties
# Have getopts or different scripts for starting, creating and maybe exiting gracefully