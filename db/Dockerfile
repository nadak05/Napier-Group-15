# Use the MySQL image version 8.3 (allows native password plugin)
FROM mysql:8.3

# Set the working directory
WORKDIR /tmp

# Copy the world.sql file to the working directory of the container
COPY world.sql /tmp/

# Copy the main SQL file to docker-entrypoint-initdb.d
# This file will initialize the database when the container starts
COPY world.sql /docker-entrypoint-initdb.d/

# Set the root password
ENV MYSQL_ROOT_PASSWORD=Password
