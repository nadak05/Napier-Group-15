# Use the MySQL image version 8.3 (allows native password plugin)
FROM mysql:8.3

# Copy the main SQL file to docker-entrypoint-initdb.d
# This file will initialize the database when the container starts
COPY world.sql /docker-entrypoint-initdb.d/

# Set the root password
ENV MYSQL_ROOT_PASSWORD=Password
