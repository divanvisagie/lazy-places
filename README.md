# Lazy Places

[![Build Status](https://travis-ci.org/divanvisagie/lazy-places.svg?branch=master)](https://travis-ci.org/divanvisagie/lazy-places)
[![Docker Pulls](https://img.shields.io/docker/pulls/divanvisagie/lazy-places.svg?maxAge=2592000)](https://hub.docker.com/r/divanvisagie/lazy-places)

Lazily get places from around an area based on gps location

## Design

[![Diagram](https://rawgithub.com/divanvisagie/lazy-places/master/documentation/lazy-places-diagram.svg)](https://drive.google.com/file/d/0B4_rnYwGIwrVbXlpRUlJaGlHN2M/view?usp=sharing)

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

## License
Copyright 2016 Divan Visagie

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
