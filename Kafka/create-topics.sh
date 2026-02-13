/opt/kafka/bin/kafka-topics.sh --create --topic recipe-programs --bootstrap-server localhost:9092
/opt/kafka/bin/kafka-topics.sh --create --topic customer-profile --bootstrap-server localhost:9092
/opt/kafka/bin/kafka-topics.sh --create --topic sent-notifications --bootstrap-server localhost:9092 --config retention.ms=2592000000
/opt/kafka/bin/kafka-topics.sh --create --topic notifications-to-send --bootstrap-server localhost:9092 --config retention.ms=2592000000