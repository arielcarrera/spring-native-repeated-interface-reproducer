#!/bin/sh

java -agentlib:native-image-agent=config-output-dir=result -jar target/reproducer-0.1.0-SNAPSHOT.jar
