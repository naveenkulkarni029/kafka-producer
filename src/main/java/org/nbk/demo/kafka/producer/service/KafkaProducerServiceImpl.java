package org.nbk.demo.kafka.producer.service;

import org.apache.kafka.common.record.RecordBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducerServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
	this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String message) {
	System.out.println(message);

	// Kafka Template.send: Creates an object of Apache Kafka ProducerRecord with 2
	// parameters "topic" and value is the message..
	// ProducerRecord class, Optional properties: partition, timestamp and Key
	// ProducerRecord class, Required properties: topic and value(content of the
	// message that are to be serialized using the specific serializer in the
	// configuration setting).

	// The values: must correspond to the serializer type specified in the
	// configuration. if there is a mismatch in the type specified in the config.
	// The
	// producer will generated a RTE serialization exception. type mismatch as per
	// the value.serialzer property.

	// TimeStamp: new addition from 0.10 version. allows explicit setting of
	// Timestamp. THe time stamp is transmitted with the message. Addition overhead
	// and impacts performance and throughput, Its not used now as the broker
	// server.properties file has this setting.

	// There are 2 mode for timestamps to have:
	// 1. createTime: default, timestamp applied to message is set by producer. It
	// does not matter if you want to set it explicitly. The producer will
	// automatically apply timestamp if ignored.
	// 2. LogAppendTime: overrides the timestamp coming from producer with
	// Timestamp of the broker at the time the message is appended to the log.

	// Key: IMPORTANT PROPERTY: if it is set it will determine how and to which
	// partition within a topic the kafka producer will be sending the message to.

	// Partition: LAST discussion. Line 71

	// BEST PRACTICE: Define the KEY
	// 1. Used as additional information for the message can be used to process
	// decision later.
	// 2. Determine what partition the message will be written to.

	// DOWN SIDE: Payload overhead with type of serialization is used.

	// EX: ProducerRecord<String, String> record = new ProducerRecord<String,
	// String>("adsa", "asdasd")

	// kafkaTemplate.send(record)

	// BEST PRACTICE of Producer: wrap the send call with try catch block as it can
	// be unsuccessful.

	// What happens when we send:

	// uses the bootstrap member ship and contacts the broker.

	// PARTITIONER:
	// How producer distributes messages to the partitioner:
	// Partition Routing:
	// 4 possible strategy:
	// 1. kafka producer looks for producerRecord content (Partition field) and
	// check
	// if the there is a value provided. If Yes, then is the proposed partition is
	// valid? EX: for topic requested is there a partition that matches the
	// proposed. Here the producer refers to the meta-data object maintains the
	// cluster of metadata.including list of topic there partition and leaders for
	// each. If value does not match known partition for topic or partition is not
	// available then exception will be thrown and send operation is aborted..

	// If it is a proposed partition is valid then the producer will add the
	// producer record object to specific partition buffer for a topic where it will
	// on a separate thread. await the actual send to the broker leader for the
	// specified partition..

	// If a partition is not specified?
	// Check if there is a key is specified in the kafka. If No, the message will be
	// routed using round robin strategy attempts to evenly distribute message
	// across all the partitions in the topic. This is defined in the
	// DefaultPartition class.

	// If there is a key provided?
	// check if there is a custom or non defaultPartition class was provided as a
	// part of the configuration properties provided to instantiated the kafka
	// producer. Here it the producer references to the producer configuration
	// object and
	// looks for a specific value called Partition_class_config which represents the
	// optional partitioner.class setting provided in the properties object. if
	// there is nothing provided?

	// the routing will be done by a key based partitioning scheme which kafka
	// provides as a default implementation of the partitioner interface. Default
	// class takes
	// the hash of the key and applies modules function by total no of partition
	// from the topic to decide for which partition to send it to.

	// Lastly, develop a custom partitioner implementation add it to the class part
	// and specify as a partitioner.class properties.

	kafkaTemplate.send("testMessage", message);
    }

}
