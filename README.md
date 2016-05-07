# Lazy Places

[![Build Status](https://travis-ci.org/divanvisagie/lazy-places.svg?branch=master)](https://travis-ci.org/divanvisagie/lazy-places)
![Docker Pulls](https://img.shields.io/docker/pulls/divanvisagie/lazy-places.svg)

Lazily get places from around an area based on gps location


## Development Setup

### Ensime

Ensime files are ignored in this project so you will need to generate any required files
`sbt ensimeConfig`

### Google API key

Lazy-places reads from the google API , it's settings manager reads the key from an environment variable
set this on your local system or in the docker container

`export GOOGLE_API_SECRET=Your_Key`


### Running in docker

```sh
sbt docker:stage
docker-compose up
```
