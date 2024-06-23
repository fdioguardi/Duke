# Use a Java runtime base image
FROM eclipse-temurin:21

ARG USER=duke
ENV home /home/${USER}

# add new user
RUN useradd -ms /bin/bash $USER && \
    chown -R $USER:$USER $home && \
    chmod -R 755 $home

USER $USER

# Set the working directory inside the container
WORKDIR /opt/duke

# Copy the JAR and config file from the host into the container
COPY duke.jar config.xml input/ ./

# Create a directory to store the output and input
RUN mkdir -p /opt/duke/output

# Set the volume to store the output and input
VOLUME /opt/duke

# Command to run the application with command-line options
CMD ["java", "-jar", "duke.jar", "--linkfile=/opt/duke/output/matches.txt", "--threads=4", "config.xml"]
