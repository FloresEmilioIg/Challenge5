
# Optionally accept profile and port
PROFILE=${1:-local}
PORT=${2:-8080}


# Example usage: ./start.sh local 8080


export SPRING_PROFILES_ACTIVE=${PROFILE}
export SERVER_PORT=${PORT}


mvn clean package -DskipTests
java -jar target/Challenge5-0.0.1-SNAPSHOT.jar