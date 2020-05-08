package org.nbk.demo.kafka.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfigurations {

    @Bean
    public ProducerFactory<String, String> producerFactory() {
	Map<String, Object> configProperties = new HashMap<>();
	// Bootstrap Server: Cluster membership this configuration is needed for the
	// producer
	// to start up. It uses this list to determine the partitions owner or leaders.
	// Best practice: Provide more than 1 broker in the broker list. if the first
	// broker specified is unavailable.

	configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

	// Key and value serialization: used to optimize the size of the message. for
	// storage and compression. the producer is responsible how the message content
	// should be encoded as it is the beginning of the message.
	// For this example we use string Serialzier class.

	// The values must correspond to the Serializer type specified in the
	// configuration. if there is a mismatch in the type specified in the config.
	// the
	// producer will generated a RTE serialization exception. type mismatch as per
	// the value.serialzer property.

	configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

	return new DefaultKafkaProducerFactory<>(configProperties);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
	return new KafkaTemplate<>(producerFactory());
    }

}
