# Use a base image with Java and Docker pre-installed
FROM openjdk:17-jdk-slim

# Set environment variables
ENV ARTEMIS_HOME=/opt/artemis \
    BROKER_HOME=/var/lib/artemis

# Install required packages
RUN apt-get update && apt-get install -y \
    wget \
    unzip

# Download ActiveMQ Artemis
RUN wget -O /tmp/apache-artemis.zip https://downloads.apache.org/activemq/activemq-artemis/2.28.0/apache-artemis-2.28.0-bin.zip

# Extract and move Artemis to the desired location
RUN unzip /tmp/apache-artemis.zip -d /opt && \
    mv /opt/apache-artemis-2.28.0 $ARTEMIS_HOME

# Create a new broker instance
RUN $ARTEMIS_HOME/bin/artemis create $BROKER_HOME --user admin --password admin --allow-anonymous

# Expose necessary ports
EXPOSE 8161 61616 5445

# Set the working directory
WORKDIR $BROKER_HOME/bin

# Start ActiveMQ Artemis
CMD ./artemis run
