#!/usr/bin/env bash

gradle clean build && java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar build/libs/post-coder-0.1.0.jar